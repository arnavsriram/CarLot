import java.util.*;
import java.io.*;
public class CarLot {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      Car[] cars = initializeCars();
      printCarInventory(cars);
      String response;
      do {
         System.out.print("Do you want to (D)rive, (A)dd gas, or (Q)uit? ");
         response = console.next();
         if (!quit(response)) {
            System.out.print("Which Car (1-" + (cars.length) + ")? ");
            int carNum = console.nextInt() - 1;
            try {
               if (response.equalsIgnoreCase("D")) { // Drive
                  System.out.print("How many miles? ");
                  cars[carNum].drive(console.nextInt());
               } else { // Add gas
                  System.out.print("How much gas? ");
                  cars[carNum].addGas(console.nextDouble());
               }
            } catch (Exception cause) {
               Throwable rootCause = cause;
               while(rootCause.getCause() != null &&  rootCause.getCause() != 
rootCause)
                  rootCause = rootCause.getCause();            
                
               System.out.println("\n***" + cause + "; Class: " + 
                  rootCause.getStackTrace()[0].getClassName() +
                     ", line: " + cause.getStackTrace()[0].getLineNumber());       
            }
            System.out.println();
            printCarInventory(cars);
         }
      } while(!quit(response));
   }
   public static Car[] initializeCars() throws FileNotFoundException {      
      Scanner fileReader = new Scanner(new File("cars.txt"));
      Car[] cars = new Car[fileReader.nextInt()];
      fileReader.nextLine();
      for (int i = 0; i < cars.length; i++) {
         String name = fileReader.nextLine();
         Scanner singleCarData = new Scanner(fileReader.nextLine());
         cars[i] = new Car(name, 
                           singleCarData.nextInt(), 
                           singleCarData.nextInt(), 
                           singleCarData.nextInt());
      }
      return cars;
   }
   public static void printCarInventory(Car[] cars) {
      System.out.printf("%-23s %14s %6s %12s %9s\n", 
                        "   Car Name", "Fuel Capacity", "MPG", "Fuel Level", 
"Mileage");
      for (int i = 0; i < cars.length; i++) {
         System.out.println((i + 1) + ": " + cars[i]);
      }
      System.out.println();
   }
   
   public static boolean quit(String response) {
      return !response.equalsIgnoreCase("D") && !response.equalsIgnoreCase("A");
   }
}