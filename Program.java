import java.util.*;

public class Program {

    static ArrayList<Ticket> board = new ArrayList<>();
    static String ticketName = "";
    static Scanner scnr = new Scanner(System.in);
    public static void main(String Args[]) {

        System.out.println("\nWelcome to Ticket Express!");

        //-----------main menu portion----------
        int option = 0;
        while (option != 5) {

            System.out.println("""
            \nPlease Enter a Number for an Option 1-5:
            1.\tAdd Ticket
            2.\tMove Ticket
            3.\tEdit Ticket
            4.\tPrint Ticket Board
            5.\tExit\n""");

            String input = scnr.nextLine();
            System.out.println("");

            if(input.matches("\\d")){
				option = Integer.parseInt(input);
			}
			else {
				option = 0;
			}

			switch(option){
				case 1 -> addTicket();
				case 2 -> moveTicket();
				case 3 -> editTicket();
				case 4 -> listBoard();
                case 5 -> System.out.println("Goodbye!");
                default ->System.out.println("***That is not an option.***");
			}
        }
        scnr.close();
    }

    //----------add a Ticket---------------------
    static void addTicket(){ 
        System.out.print("Enter Ticket Name: ");
        String name = scnr.nextLine();

        System.out.print("Enter the Tickets Description: ");
        String description = scnr.nextLine();

        System.out.print("Enter the Assignee on this Ticket: ");
        String assignee = scnr.nextLine();

        System.out.print("Enter Priority (0=Critical,1=High,2=Medium,3=Low): ");
        int priority = Integer.parseInt(scnr.nextLine());

        Ticket t = new Ticket(name, description, 1, assignee, priority);
        board.add(t);

        System.out.println("\nTicket was added to the Board!");
    }

    //----------move a Ticket--------------------
    static void moveTicket(){
        System.out.println("two");
    }

    //----------edit a Ticket--------------------
    static void editTicket(){
        System.out.println("three");
    }

    //----------list the board of Tickets--------
    static void listBoard(){

        if (board.isEmpty()){
            System.out.println("No tickets yet!");
        }

        for (int i = 0; i < board.size(); i++){
            System.out.println((i+1) + ". " + board.get(i));
        }
    }

}


// ========Ticket Class===========

class Ticket{

    private String name;
    private String description;
    private int stage;
    private String assignees;
    private int priority;

    public Ticket(String name, String description, int stage, String assignees, int priority){ //stages: 1.new 2.open 3.pending 4.on-hold 5.solved   //priority: 0-critical 1-high 2-medium 3-low
        this.name = name;
        this.description = description;
        this.stage = stage;
        this.assignees = assignees;
        this.priority = priority;
    }

    public String toString(){
        return "Name: " + name + "\t|| Description: " + description;
    }
}