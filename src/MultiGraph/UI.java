package MultiGraph;

import java.util.List;
import java.util.Scanner;

public class UI {

    private String firstStationName;
    private String secondStationName;
    private int firstStationId;
    private int secondStationId;

    public UI() {

    }

    /**
     * Asks, recieves and checks input from the user
     *
     * @param bms
     * @param firstOrSecond
     */
    void selectStationName(BostonMetroSystem bms, boolean firstOrSecond) {

        String userInput;
        String paul;
        Scanner sc = new Scanner(System.in);
        List<INode> nodes = bms.getStations();

        while (true) {
            if (firstOrSecond) {
                System.out.println("Please type the name of your starting station or 'quit' to exit the program.");

            } else {
                System.out.println("Please type the name of your destination station or 'quit' to exit the program.");
            }

            userInput = sc.nextLine();
            userInput = userInput.replaceAll(" ", "");

            if (userInput.equalsIgnoreCase("quit")) {
                quit();
            }

            System.out.println();

            //NEW STUFF-----------------------------------------
            if (userInput.equalsIgnoreCase("st.paulstreet")) {
                while (true) {
                    System.out.println("If you mean the station on Green B, input B.");
                    System.out.println("If you mean the station on Green C, input C.");

                    paul = sc.nextLine();
                    paul = paul.replaceAll(" ", "");

                    if (paul.equalsIgnoreCase("b")) {
                        if (firstOrSecond) {
                            firstStationId = 38;
                            firstStationName = "st.paulstreet";
                        } else {
                            secondStationId = 38;
                            secondStationName = "st.paulstreet";
                        }
                        break;
                    }
                    if (paul.equalsIgnoreCase("c")) {
                        if (firstOrSecond) {
                            firstStationId = 61;
                            firstStationName = "st.paulstreet";
                        } else {
                            secondStationId = 61;
                            secondStationName = "st.paulstreet";
                        }
                        break;
                    }
                    System.out.println("Sorry but that line doesn't exist. Please try again.\n");
                }
            }


            if (doesStationExist(bms, userInput)) {

                if (firstOrSecond) {
                    if (firstStationId != 31 && firstStationId != 68) {
                        firstStationName = userInput;
                    }
                    break;
                } else {
                    if (secondStationId != 31 && secondStationId != 68)
                        secondStationName = userInput;
                    break;
                }
            } else {
                System.out.println("Sorry, that name doesn't match any station. Please try again.\n");
            }


        }
        for (INode node : nodes) {
            String nodeName = node.getName();
            int nodeId = node.getId();

            if (nodeName.equalsIgnoreCase(firstStationName) && !nodeName.equalsIgnoreCase("st.paulstreet")) {
                firstStationId = nodeId;
            }
            if (nodeName.equalsIgnoreCase(secondStationName) && !nodeName.equalsIgnoreCase("st.paulstreet")) {
                secondStationId = nodeId;
            }

        }

    }

    /**
     * Checks if station given exists within the BostonMetroSystem
     * @param bms
     * @param stationName
     * @return
     */
    private boolean doesStationExist(BostonMetroSystem bms, String stationName) {
        List<INode> nodes = bms.getStations();
        for (INode node : nodes) {
            if (node.getName().equalsIgnoreCase(stationName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Exits program
     */
    private void quit() {
        System.out.println("Thank you for using the Boston Metro System. Have a nice day!");
        System.exit(0);
    }

    /**
     * Returns the first station's ID
     * @return
     */
    int getFirstStationId() {
        return firstStationId;
    }

    /**
     * Returns the second station's ID
     * @return
     */
    int getSecondStationId() {
        return secondStationId;
    }
}