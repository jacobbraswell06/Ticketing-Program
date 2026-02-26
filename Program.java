import java.util.*;

public class Program {

    static ArrayList<Ticket> board = new ArrayList<>();
    static String ticketName = "";
    static Scanner scnr = new Scanner(System.in);
    public static void main(String Args[]) {

        System.out.println("\n===== Welcome to Ticket Express! =====");

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

            option = getIntInRange("Choose an option (1-5): ",1,5);
            System.out.println("");

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

        String name;
        while (true) {
            System.out.print("Enter Ticket Name: ");
            name = scnr.nextLine().trim();

            if (!name.isEmpty()){
                break;
            } 
            else{
                System.out.println("Ticket name cannot be empty!");
            }
        }

        System.out.print("Enter the Tickets Description: ");
        String description = scnr.nextLine();

        System.out.print("Enter the Assignee on this Ticket: ");
        String assignee = scnr.nextLine();

        int priority = getIntInRange("Enter Priority (0=Critical,1=High,2=Medium,3=Low): ", 0, 3);

        Ticket t = new Ticket(name, description, 1, assignee, priority);
        board.add(t);

        System.out.println("\nTicket was added to the Board!");
    }

    //----------move a Ticket--------------------
    static void moveTicket(){

        if (board.isEmpty()){
            System.out.println("No tickets yet!");
            return;
        }
         
        listBoard();

        int index = getIntInRange("\nEnter a ticket number to move: ", 1, board.size());
        index--;

        int newStage = getIntInRange("Enter a new stage (1=new,2=open,3=pending,4=on-hold,5=solved): ", 1, 5);

        board.get(index).setStage(newStage);

        switch(newStage){
				case 1 -> System.out.println("\nTicket is moved to new!");
				case 2 -> System.out.println("\nTicket is moved to open!");
				case 3 -> System.out.println("\nTicket is moved to pending!");
				case 4 -> System.out.println("\nTicket is moved to on-hold!");
                case 5 -> System.out.println("\nTicket is moved to solved!");
			}
    }

    //----------edit a Ticket--------------------
    static void editTicket(){

        if (board.isEmpty()){
            System.out.println("No tickets yet!");
            return;
        }
         
        listBoard();

        int index = getIntInRange("\nEnter a ticket number to edit: ", 1, board.size());
        index--;

        System.out.print("Enter new description: ");
        String newDescription = scnr.nextLine();

        board.get(index).setDescription(newDescription);

        System.out.println("Ticket updated!");
    
    }

    //----------list the board of Tickets--------
    static void listBoard(){

        if (board.isEmpty()){
            System.out.println("No tickets yet!");
            return;
        }

        printStage(1, "NEW");
        printStage(2, "OPEN");
        printStage(3, "PENDING");
        printStage(4, "ON-HOLD");
        printStage(5, "SOLVED");
    }

    //----------Prints each stage of the board-----------
    static void printStage(int stageNumber, String stageName){

        System.out.println("============"+ stageName +"============");

        for(int i = 0; i < board.size(); i++){
            if (board.get(i).getStage() == stageNumber) {
                System.out.println((i+1) + ". " + board.get(i));
            }
        }
    }

    //----------Check if input is number in range----------
    static int getIntInRange(String prompt, int min, int max){

        while(true){

            System.out.print(prompt);
            String input = scnr.nextLine();

            try{
                int value = Integer.parseInt(input);

                if (value >= min && value <= max){
                    return value;
                }
                else {
                    System.out.println("Please enter a number between " +min+ " and " +max+ "!");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

}


// ========Ticket Class===========

class Ticket{

    private String name;
    private String description;
    private int stage;
    private String assignee;
    private int priority;

    public Ticket(String name, String description, int stage, String assignee, int priority){ //stages: 1.new 2.open 3.pending 4.on-hold 5.solved   //priority: 0-critical 1-high 2-medium 3-low
        this.name = name;
        this.description = description;
        this.stage = stage;
        this.assignee = assignee;
        this.priority = priority;
    }

    public void setStage(int stage){
        this.stage = stage;
    }

    public int getStage(){
        return stage;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String toString(){
        return "Name: " + name + "\t|| Description: " + description + "\t|| Priority: p" + priority + "\t|| Assignee: " + assignee;
    }

}