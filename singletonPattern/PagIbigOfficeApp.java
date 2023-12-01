package singletonPattern;
import java.util.*;

public class PagIbigOfficeApp {
    public static void main(String[] args) {

        // Instantiate the queuing system.
        CentralizedQueuingSystem queuingSystem = CentralizedQueuingSystem.getInstance();
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to Centralized Queuing System for Pag-ibig Office!");

        while (true) {

            boolean problem;
            do { // If there are no problems in the queuing system at any Help Desk station.
                problem = true;
                System.out.println("\n================ Current Help Desk Station Status ================");

                // To issue individual in help desk station.
                Integer individualVisits = 15;
                for (int i = 0; i < individualVisits; i++) {
                    Integer individual = rand.nextInt(3) + 1;
                    queuingSystem.issueQueueNumber(individual);
                }

                System.out.println();

                // To display current queue number and individuals count at each help desk station.
                System.out.println("==== Current Queued Number ====");
                System.out.println("Current Queue Number: " + queuingSystem.getCurrentQueueNumber());
                queuingSystem.displayIndividualVisits();
                System.out.println();

                // Prompt the user if there is a problem.
                System.out.print("Is there any problem? [Yes or No]: ");
                String userChoice = userInput.nextLine().toLowerCase();
                if (userChoice.equals("yes")) {
                    problem = false;
                }

            } while (problem);

            /* If there is a problem. */
            // Simulate help desk station reset based on user input.
            System.out.print("\nWhat Help Desk Station are you? [1, 2, or 3]: ");
            Integer helpDeskStation = userInput.nextInt();

            System.out.println("\nHelp Desk Station " + helpDeskStation + "! you're resetting the queuing number... ");
            System.out.print("Enter new queuing number: ");
            Integer newQueuingNumber = userInput.nextInt();
            userInput.nextLine();

            queuingSystem.resetQueuingSystem(helpDeskStation, newQueuingNumber); // To reset queuing system.

            System.out.println("\n================ New Help Desk Station Status ================");

            // To issue New individual visits in help desk station after reset.
            Integer individualVisits = 10;
            for (int i = 0; i < individualVisits; i++) {
                Integer individual = rand.nextInt(3) + 1;
                queuingSystem.issueQueueNumber(individual);
            }
            System.out.println();

            // to display current queue number and individuals count at each help desk station after reset.
            System.out.println("==== New Queued Number ====");
            System.out.println("Current Queue Number: " + queuingSystem.getCurrentQueueNumber());
            queuingSystem.displayIndividualVisits();
            System.out.println();

            // prompt the user if he/she wants to run again the program.
            System.out.print("\nWould you like to continue the program? (Y/N): ");
            String userChoiceB = userInput.nextLine();
            System.out.println();

            if (!userChoiceB.toLowerCase().equals("y")) {
                System.out.println("Program Terminated!");
                System.out.println("Programmed by: Ronan D. Soriano | 3 BSCS - 1");
                break;
            }
        }
        userInput.close();
    }
}