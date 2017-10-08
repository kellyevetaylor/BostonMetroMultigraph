package NewVersion; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private String firstStationName;
    private String secondStationName;
    private int firstStationId;
    private int secondStationId;
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
    public int getFirstStationId(){
        return firstStationId;
    }

    public int getSecondStationId(){
        return secondStationId;
    }

    public void selectStationName(BostonMetroSystem bms, boolean firstOrSecond) {
        String userInput;
        String paul;
        Scanner sc = new Scanner(System.in);
        List<INode> nodes = bms.getStations();
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
   //NEW STUFF-----------------------------------------         
        	if (userInput.equalsIgnoreCase("st.paulstreet")) {
   		    System.out.println("If you mean the one on Green B, input B.");
   		    System.out.println("If you mean the one on Green C, input C.");
   		    paul = sc.next();
   		    
   		    if (paul.equalsIgnoreCase("b")) {
   		    	if(firstOrSecond){
   		    		firstStationId=38;
   		    		firstStationName = "st.paulstreet";
   		    	}
   		    	else{
   		    		secondStationId=38;
   		    		secondStationName = "st.paulstreet";
   		    	}
   		    }
   		   if (paul.equalsIgnoreCase("c")) {
		    	if(firstOrSecond){
		    		firstStationId=61;
		    		firstStationName = "st.paulstreet";
		    	}
		    	else{
		    		secondStationId=61;
		    		secondStationName = "st.paulstreet";
		    	}
		    }
        	}
   		    	
   		   
        	

            if (doesStationExist(bms, userInput)){
            	
                if(firstOrSecond) {
                	if (firstStationId!=31 && firstStationId!=68) {
                    firstStationName = userInput;
                	}
                    break;
                } else {
                	if (secondStationId!=31 && secondStationId!=68)
                    secondStationName = userInput;
                    break;
                }
            } 
            else {
                System.out.println("Sorry, that name doesn't match any station. Please try again.");
            }
            
           
            
            
            
        	}
        for(int i = 0; i < nodes.size(); i++) {
    		if (nodes.get(i).getName().equalsIgnoreCase(firstStationName) && !nodes.get(i).getName().equalsIgnoreCase("st.paulstreet")) {
    			firstStationId=nodes.get(i).getId();
    		}
    		if (nodes.get(i).getName().equalsIgnoreCase(secondStationName) && !nodes.get(i).getName().equalsIgnoreCase("st.paulstreet")) {
    			secondStationId=nodes.get(i).getId();
    		}
    		 
    }
      //NEW STUFF--------------------------------

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