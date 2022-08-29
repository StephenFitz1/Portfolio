import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;


public class Dictionary {

    private ArrayList<String> words;
    private int shortest;
    private int longest;
    private String word;

    public Dictionary(String filePath, int shortest, int longest) {
        this.shortest = shortest;
        this.longest = longest;
        this.words = new ArrayList<>();

        try {
            File file = new File(filePath);
//            if (!file.canRead()) {
//                System.out.println("Can't read file");
//                return;
//            }
            Scanner scan = new Scanner(file);
            String line;
            while (scan.hasNext()) {
                line = scan.nextLine().toUpperCase();
                if (!line.isBlank()) {
                    String[] lineArray = line.split(",");
                    for (int i = 0; i < lineArray.length; i++) {
                        String word = lineArray[i].trim();
                        if (!words.contains(word) && word.length() >= shortest && word.length() <= longest) {
                            words.add(word);
                        }
                    }
                }

            }
            scan.close();
        } catch (Exception e) {
            System.out.println("There was a problem " + e);
        }
        Collections.sort(this.words);
        System.out.println(this.words);
    }

        public boolean add(String word){
            word = word.trim();
            int index = Collections.binarySearch(this.words, word.toUpperCase());
            System.out.println(word);
            if (index < -1) {
                words.add(word.toUpperCase());
                System.out.println(word.toUpperCase()+ " has been successfully added to the list");
                Collections.sort(words); //After adding new word, sorts list alphabetically
                System.out.println(words);
                return true;
            } else
                System.out.println(word.toUpperCase() + " is already in the list");  // at index: " + index);
                System.out.println(words);
        return false;
    }

//        public String nextWord() {
//
//        }
//
//        public boolean inDictionary (String word){
//
//        }

    }

