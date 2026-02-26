import java.util.*;

public class program {

    static String[] board = new String[50];
    static int boardLength = 0;
    static String ticketName = "";
    static Scanner scnr = new Scanner(System.in);
    public static void main(String Args[]) {

        System.out.println("\nWelcome to Ticket Express!");

        //main menu portion
        int option = 0;
        while (option != 5) {
            System.out.println("\nPlease Enter a Number for an Option 1-5:\n1.\tAdd Ticket\n2.\tMove Ticket\n3.\tEdit Ticket\n4.\tPrint Ticket Board\n5.\tExit\n");
            String input = scnr.nextLine();
            System.out.println("");

            if(Character.isDigit(input.charAt(0))){
				option = Integer.parseInt(input);
			}
			else {
				option = 0;
			}

            if(option == 5) {
				System.out.println("Goodbye!");
				break;
			}
			else if (option < 1 || option > 5){
				System.out.println("***That is not an option.***");
			}
			else {
				switch(option){
					case 1:
						System.out.println("option 1");
						break;
					case 2:
						System.out.println("option 2");
						break;
					case 3:
						System.out.println("option 3");
						break;
					case 4:
						System.out.println("option 4");
						break;
				}
			}
        }
        scnr.close();
    }

    static void addTicket(){

    }

    static void moveTicket(){

    }

    static void editTicket(){

    }

    static void listBoard(){

    }

    public ticket(String name, String description, int stage, String assignees, int priority){ //stages: 1.new 2.open 3.pending 4.on-hold 5.solved   //priority: 0-critical 1-high 2-medium 3-low

    }
}
