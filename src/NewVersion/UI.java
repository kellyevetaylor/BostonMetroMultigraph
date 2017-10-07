package NewVersion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private String firstStationName;
    private String secondStationName;
    private static BostonMetroSystem bms;
    ArrayList<Integer> path = new ArrayList<Integer>();

    public UI()  {

    }

    public String getFirstStationName(){
        return firstStationName;
    }

    public String getSecondStationName(){
        return secondStationName;
    }

    public void selectStationName(BostonMetroSystem bms, boolean firstOrSecond) {
        String userInput;
        Scanner sc = new Scanner(System.in);
        while (1==1){
            if(firstOrSecond) {
                System.out.println("Please type the name of your starting station or 'quit' to exit the program.");
            } else {
                System.out.println("Please type the name of your destination station or 'quit' to exit the program.");
            }

            userInput = sc.nextLine();
            userInput = userInput.replaceAll(" ", "");

            if (userInput.equalsIgnoreCase("quit")){
                quit();
            }
            if (doesStationExist(bms, userInput)){
                if(firstOrSecond) {
                    firstStationName = userInput;
                    break;
                } else {
                    secondStationName = userInput;
                    break;
                }
            } else {
                System.out.println("Sorry, that name doesn't match any station. Please try again.");
            }
        }
    }

    private boolean doesStationExist(BostonMetroSystem bms, String stationName) {
        List<INode> nodes = bms.getStations();
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).getName().equalsIgnoreCase(stationName)) {
                return true;
            }
        }
        return false;
    }

    private void quit() {
        System.out.println("Thank you for using the Boston Metro System. Have a nice day!");
        System.exit(0);
    }

}
