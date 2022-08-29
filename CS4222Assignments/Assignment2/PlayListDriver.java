/*  Stephen Fitzpatrick
    CS4222
    21263213
 */

public class PlayListDriver {
    public static void main(String[] args) {
        PlayList test = new PlayList();
        System.out.println(test.getName());
        test.setName("Test name");
        System.out.println(test.getName());
        System.out.println();

        PlayList favourites = new PlayList("My Favourites");
        System.out.println(favourites.getName());
        favourites.setName("Best Songs Ever!!!!");
        System.out.println(favourites.getName());
        System.out.println();



        favourites.add(new Track("Bob Dylan","The Times They Are A-Changin'",1964,192/*3:12*/));
        favourites.add(new Track("Eagles","Desperado",1973,214/*3:34*/));
        favourites.add(new Track("The Beatles","Let It Be",1970,230/*3:50*/));
        favourites.add(new Track("U2","Acrobat",1980,270/*4:30*/));
        favourites.add(new Track("Genesis","Turn It On Again",1980,231/*3:51*/));
        favourites.add(new Track("Miley Cyrus","The Climb",2009,241/*4:01*/));
        favourites.add(new Track("Billy Joel","Leningrad",2004,243/*4:03*/));
        favourites.add(new Track("Marilyn Martin & Phil Collins","Separate Lives",1984,375/*6:15*/));
        favourites.add(new Track("Harry Chapin","Flowers Are Red",1979,305/*5:05*/));
        favourites.add(new Track("Metallica", "The Four Horsemen", 1983, 441));
        favourites.add(new Track("Metallica", "Motorbreath", 1983, 187));


        favourites.add(new Track("August Burns Red", "White Washed"));
        favourites.add(new Track("August Burns Red", "Rationalist"));
        favourites.showList();

        favourites.playOnly("eagles");
        favourites.toString();
        favourites.toString();
        favourites.showList();
        System.out.println();

        System.out.println("Play NOT shuffled...");
        favourites.playAll(false);
        System.out.println();

        System.out.println("PLay shuffled..");
        favourites.playAll(true);
        System.out.println();


        favourites.remove("joel");
        favourites.remove("U6");
        favourites.remove("chap");
        favourites.playAll(true);
        System.out.println();
        favourites.playAll(false);
        System.out.println();
        favourites.playOnly(1983); //Shows the songs from the specified year in order
        favourites.playOnly("bob");


    }
}
