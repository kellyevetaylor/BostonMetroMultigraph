//package LessDependenciesBFS;
//
//import java.io.IOException;
//import java.util.*;
//
//public class UI {
//    //Add special cases for duplicate station names.
//    // Need to produce path and present to user.
//
//    private String firstStationName;
//    private String secondStationName;
//    private static BostonMetroSystem bms;
//    ArrayList<Integer> path = new ArrayList<Integer>();
//
//    // Runs the UI and search.
//
//    public UI() {
//
//        public static void main(String[] args) {
//            MetroMapParser mmp = null;
//            try {
//                mmp = new MetroMapParser("bostonmetro.txt");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Search search = new Search();
//            try {
//                bms = (BostonMetroSystem) mmp.generateGraphFromFile();
//            } catch (BadFileException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            selectStationName(true);
//            selectStationName(false);
//
//            path = search.search(bms, bms.stationNametoID(firstStationName), bms.stationNametoID(secondStationName));
//
//        }
//
//    }
//
//    //Asks the user for either starting or finishing station.
//
//    private void selectStationName(boolean firstOrSecond) {
//        String userInput;
//        Scanner sc = new Scanner(System.in);
//        while (1==1){
//            if(firstOrSecond) {
//                System.out.println("Please type the name of your starting station or 'quit' to exit the program.");
//            } else {
//                System.out.println("Please type the name of your destination station or 'quit' to exit the program.");
//            }
//            userInput = sc.next();
//            if (userInput.compareTo("quit") == 0){
//                quit();
//            }
//            if (bms.doesStationExist(userInput)){
//                if(firstOrSecond) {
//                    firstStationName = userInput;
//                    break;
//                } else {
//                    secondStationName = userInput;
//                    break;
//                }
//            } else {
//                System.out.println("Sorry, that name doesn't match any station. Please try again.");
//            }
//        }
//    }
//
//    //Prints a message then exists the program.
//
//    private void quit() {
//        System.out.println("Thank you for using the Boston Metro System. Have a nice day!");
//        System.exit(0);
//    }
//
//
//
//
//}