import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  Stephen Fitzpatrick
    CS4222
    21263213
 */

public class PlayList {

    private String playlistName;
    private ArrayList<Track> trackList;

    public PlayList() {
        this.playlistName = "New PlayList";
        this.trackList = new ArrayList<>();
    }

    public PlayList(String name) {
        this.playlistName = name;
        this.trackList = new ArrayList<>();
    }

    public void setName(String name) {
        this.playlistName = name;
    }

    public String getName() {
        return playlistName;
    }

    public void add(String title, String artist) {
        add(title, artist, 0, 0);
    }

    public String toString() {
        String outputString = String.format("%s%n", playlistName);
        if (!trackList.isEmpty()) {
            for(int i=0; i< trackList.size(); i++){
                outputString = outputString + trackList.get(i)+"\n";
            }
        }
        return outputString.substring(0, outputString.length()-1);
    }

    public void add(String title, String artist, int year, int duration) {
        add(new Track(title, artist, year, duration));
    }

    public void add(Track t) {
        trackList.add(t);
    }

    public boolean remove(String title) {
        boolean exists = false;
        title = title.toLowerCase();
        if (!trackList.isEmpty()) {
            for (int i = 0; i < trackList.size(); i++) {
                if (title.equals(trackList.get(i).getTitle())) {
                    exists = true;
                    trackList.remove(i);
                    break;
                }
            }
        }
        return exists;
    }

    public void showList() {
        if (trackList.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println(playlistName);
            for (int i = 0; i < trackList.size(); i++) {
                System.out.println(trackList.get(i));
            }
        }
    }

    public void playAll(boolean random) {
        if (!trackList.isEmpty()) {
            if (random == true) { //Create an ArrayList to store shuffled songs
                ArrayList<Track> shuffledList = new ArrayList<>(trackList);
                for (int i = 0; i < trackList.size(); i++) {
                    int temp = (int) (Math.random() * shuffledList.size()); //Temp value gets random value between 0 and the size of the original list
                    System.out.println(shuffledList.get(temp)); //Prints value
                    shuffledList.remove(temp);//No repetition
                }
            } else  //If false just prints list out normally
                for (int i = 0; i < trackList.size(); i++) {
                    System.out.println(trackList.get(i));
                }
        }

    }

    public void playOnly(String artist) {
        String artistLower = artist.toLowerCase();
        String[] playOnlyCondition = artistLower.split(" ");
        Object[] trackListNew = trackList.toArray();

        if (!trackList.isEmpty()) {
            for (int i = 0; i < playOnlyCondition.length - 1; i++) {
                for (int j = 0; j < trackListNew.length; j++) {
                    if (trackList.get(j).equals(playOnlyCondition[i])) {
                        System.out.println(trackList.get(j));
                        break;
                    }
                }
            }
        }
    }


    public void playOnly ( int year){
        if (!trackList.isEmpty()) {
            for (int i = 0; i < trackList.size(); i++) {
                if (year == trackList.get(i).getYear()) {
                    System.out.println(trackList.get(i));
                    break;
                }
            }
        }
    }
}





