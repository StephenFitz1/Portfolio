/*
Stephen Fitzpatrick
21263213
CS4222
 */

import java.util.*;
import java.io.*;

public class ApplicantAnalysis {

    public static void main(String[] args) {
        if (args.length == 2) {
            // File containg applicant information
            String filePath = args[0];
            // Course points cutoff - passed in the command line as a String and converted to an integer
            int cutoff = Integer.parseInt(args[1]);
            // TreeMap stores the applicant Number and associated points total (i.e. ID ---> Points)
            TreeMap<String, Integer> candidateScores = calculateApplicantScores(filePath);
            if (candidateScores != null) {
                // LinkedList stores a list of applicantNumbers containing the applicants with Points >= cutoff
                LinkedList<String> chosenApplicants = select(candidateScores, cutoff);
                // LinkedList toString method will automatically be used to display list of successful applicantNumbers
                if (chosenApplicants != null) {
                    System.out.println(chosenApplicants);
                } else {
                    System.out.println("There are no applicants with sufficient points for the course!");
                }
            } else {
                System.out.println("There are no applicants for the course!");
            }
        } else {
            // Program command line is incorrect
            System.out.println("Command Line format error.");
            System.out.println("Use 'ApplicantAnalysis filepath cutoff'");
            System.out.println("For example - ApplicantAnalysis LM999.CSV 390'");
        }
    }

    public static TreeMap<String, Integer> calculateApplicantScores(String filePath) {
        try {
            // Create a File object to access the file
            File fileHandle = new File(filePath);
            // Create an instance of the Scanner to actually read the file
            Scanner csvFile = new Scanner(fileHandle);
            // TreeMap stores the applicant applicantNumber and associated points total (i.e. ID ---> Points)
            TreeMap<String, Integer> candidates = new TreeMap<String, Integer>();
            // Read through the CSV file of Applicant Numbers and  LCE grades
            // and calculate the applicant points scores
            while (csvFile.hasNext()) {
                // Read the next applicant data line (applicantNumber followed by grades - comma separated)
                String applicantDetails = csvFile.nextLine();
                // Find end of applicant Number (i.e. first comma)
                int posFirstComma = applicantDetails.indexOf(",");
                // Extract the applicant Exam Number
                String applicantID = applicantDetails.substring(0, posFirstComma);
                // Extract the part of the CSV line that contains the grades (i.e. from position after first comma)
                String applicantGrades = applicantDetails.substring(posFirstComma + 1);
                // Use String split operation to create array from grades
                String[] grades = applicantGrades.split(",");
                // For testing purposes we might want to display the data
//                System.out.printf("\nThis applicant : %s - %s\n",applicantID, Arrays.toString(grades));
                // Use the "pointsScore" method to calculate the applicants points total and
                // add the applicantNumber and points score to the TreeMap
                candidates.put(applicantID, pointsScore(grades));
            }
            // Return the TreeMap
            return candidates;
        } catch (IOException e) {
            // If there is some problem with the file we just report it
            System.out.printf("Cannot access the file named '%s'!\n", filePath);
            return null;
        }
    }

    public static LinkedList<String> select(TreeMap<String, Integer> candidateScores, int cutoff) {
        LinkedList<String> select = new LinkedList<>();
        for (Map.Entry<String, Integer> candidate : candidateScores.entrySet()) { //
            String id = candidate.getKey(); //Key is just the id
            int points = candidate.getValue(); //Integer value is the number of marks added in total
            if (points >= cutoff) {
                select.add(id);
            }
        }
        if (select.size() == 0) {
            return null;
        }
        return select;
    }

    public static HashMap<String, Integer> gradeScores = setGradeScores();

    private static HashMap<String, Integer> setGradeScores(){ //Helper method just to tidy up the code
        HashMap<String, Integer> pointsTotal = new HashMap<>();
        pointsTotal.put("H1", 100);//Initialising the grade values into a HashMap
        pointsTotal.put("H2", 88);
        pointsTotal.put("H3", 77);
        pointsTotal.put("H4", 66);
        pointsTotal.put("H5", 56);
        pointsTotal.put("H6", 46);
        pointsTotal.put("H7", 37);
        pointsTotal.put("H8", 0);
        pointsTotal.put("O1", 56);
        pointsTotal.put("O2", 46);
        pointsTotal.put("O3", 37);
        pointsTotal.put("O4", 28);
        pointsTotal.put("O5", 20);
        pointsTotal.put("O6", 12);
        pointsTotal.put("O7", 0);
        pointsTotal.put("O8", 0);

        pointsTotal.put("", 0);

        return pointsTotal;
    }

    public static int pointsScore(String[] subjectGrades) {
        LinkedList<Integer> results = new LinkedList<>();
        for (String grade: subjectGrades){
            results.add(gradeScores.get(grade)); //Add all of the values to the new ArrayList for easy sorting using Collections
        }
        results.sort(Collections.reverseOrder()); //Reversing this allows us to access the highest marks from left to right, originally would be lowest to highest
        int result = 0;
        for (int i = 0; i < 6; i++){ //Brief states to get the value of the best 6 so even if there was more than 6, it only takes top 6 into account
            result += results.get(i);
        }
        return result;
    }
}

