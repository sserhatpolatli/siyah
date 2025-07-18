package greedy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GreenLife {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //adding all tools into an arraylist.
        ArrayList<Tools> tools = new ArrayList<>(List.of(
            new Tools("ENERGY SAVING BULB", 50, 100),
            new Tools("SMART TEA MAKER", 1200, 500),
            new Tools("SOLAR WATER HEATER", 6000, 1500),
            new Tools("FRIDGE", 5000, 700),
            new Tools("SOLAR PANEL (1kW)", 12000, 1200),
            new Tools("SOLAR POWERED CAMERA", 15000, 2000),
            new Tools("MOTION SENSOR CAMERA", 250, 150),
            new Tools("INSULATED WINDOW", 8000, 600),
            new Tools("NON-ELECTRIC DOORBELL", 4000, 500),
            new Tools("INVERTER AIR CONDITIONER", 9000, 900),
            new Tools("TIMER SOCKET", 150, 80),
            new Tools("SMART KITCHEN SINK", 200, 100),
            new Tools("INSULATED HEATING RADIATOR", 7000, 1000),
            new Tools("NIGHT LAMP WITH MOTION SENSOR", 500, 200),
            new Tools("LED SCREEN TELEVISION", 2000, 400),
            new Tools("FREE TO USE BIKE STATION", 800, 300),
            new Tools("SMART TOILET", 600, 150),
            new Tools("SMART CURTAIN", 300, 100),
            new Tools("RECYCLING BIN", 3000, 350),
            new Tools("TIMER OVEN", 3000, 350)
        ));

        //Opening page that includes some choice.
        while (true) {
            System.out.println("\n--- WELCOME TO GREENLIFE APP ---");
            System.out.println("\n--- PLEASE CHOOSE YOUR OPERATION ---");
            System.out.println("1. LIST TOOLS");
            System.out.println("2. CHOOSING WITH THE GREEDY ALGORITHM");
            System.out.println("0. EXIT");
            System.out.print("MY CHOICE: ");
            int choice = scanner.nextInt();

            //Switch-Case statement according to user's choice.
            switch (choice) {
                //Listing all tools by using for loop.
                case 1:
                    System.out.println("\nALL TOOLS:");
                    for (Tools t : tools) {
                        System.out.println(t.toolname + " - COST: " + t.cost + " TL, ENERGY-SAVING RATE: " +
                                t.energysavingrate);
                    }
                    break;

                // Comparing and sorting tools.
                    case 2:
                    System.out.print("ENTER YOUR BUDGET (TL): ");
                    int budget = scanner.nextInt();

                    
                    tools.sort((t1, t2) -> Double.compare(t2.benefit, t1.benefit));


                    int totalCost = 0, totalSaving = 0;
                    ArrayList<Tools> selected = new ArrayList<>();

                    for (Tools t : tools) {
                        if (totalCost + t.cost <= budget) {
                            selected.add(t);
                            totalCost += t.cost;
                            totalSaving += t.energysavingrate;
                        }
                    }
                    // When user enters low budget according to tool's cost.
                    if (selected.isEmpty()) {
                        System.out.println("\nBUDGET IS TOO LOW. PLEASE ENTER AGAIN.");
                        break;
                    }
                        
                    // Best opition are selected in this statement and printing.
                    System.out.println("\nSELECTED TOOLS:");
                    for (Tools t : selected) {
                        System.out.println("- " + t.toolname + " (COST: " + t.cost + " TL, ENERGY-SAVING: " +
                                t.energysavingrate+")");
                    }
                    System.out.println("TOTAL COST: " + totalCost + " TL");
                    System.out.println("TOTAL ENERGY-SAVING: " + totalSaving);
                    break;

                case 0:
                    System.out.println("PROGRAM EXITING...");
                    return;

                // When user chooses invalid number, this warning is printing.
                    default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }

}
