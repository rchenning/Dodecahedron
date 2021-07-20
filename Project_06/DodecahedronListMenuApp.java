import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

/**
*This program creates an app that creates a list of options to interact with 
*a list using class methods from Dodecahedron.java and
*DodecahedronList.java.
*
*
*Project 6
*@author Robert Henning - CPCS 1213-A01
*@version 09/28/2019
*/
public class DodecahedronListMenuApp {

/**
*Accepts files and return a list using class methods from Dodecahedron.java and
*DodecahedronList.java.
* 
* @param args - is not used.
* @throws IOException from scanning input file.
*/
   public static void main(String[] args) throws IOException {
   
      ArrayList<Dodecahedron> myList = new ArrayList<Dodecahedron>();
      String dListName = "*** no list name assigned ***";
      String fileName = "no file name";
      DodecahedronList myDList = new DodecahedronList(dListName, myList);
      String label = "";
      String color = "";
      double edge = 0;
      
      String code = "";
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Dodecahedron List System Menu\n"
                        + "R - Read File and Create Dodecahedron List\n"
                        + "P - Print Dodecahedron List\n"
                        + "S - Print Summary\n"
                        + "A - Add Dodecahedron\n"
                        + "D - Delete Dodecahedron\n"
                        + "F - Find Dodecahedron\n"
                        + "E - Edit Dodecahedron\n"
                        + "Q - Quit");
      
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
            
               myDList = myDList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "Dodecahedron List object created\n");
               break;
           
            case 'P':
               System.out.println(myDList.toString());
               break;
           
            case 'S':
               System.out.println("\n" + myDList.summaryInfo());
               break;
           
            case 'A':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tColor: ");
               color = scan.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scan.nextLine());
            
               myDList.addDodecahedron(label, color, edge);
               System.out.println("\t*** Dodecahedron added ***\n");
               break;
              
            case 'D':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               
               if (myDList.deleteDodecahedron(label) != null) {
                  System.out.println("\"" + label + "\" deleted\n");
               }
               else {
                  System.out.println("\"" + label + "\" not found\n");
               }
               break;
              
            case 'F':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               if (myDList.findDodecahedron(label) != null) {
                  System.out.println(myDList.findDodecahedron(label).toString()
                                  + "\n");
               }
               
               else {
                  System.out.println("\"" + label + "\" not found\n");
               }
               break;
           
            case 'E':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tColor: ");
               color = scan.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scan.nextLine());
               
               if (myDList.editDodecahedron(label, color, edge)) {
                  System.out.println("\"" + label 
                                    + "\" successfully edited\n");
               }
               
               else {
                  System.out.println("\"" + label + "\" not found\n");
               }
               break;
           
            case 'Q':
               break;
           
            default:
               System.out.println("\t*** invalid code ****\n");
               break;   
         
         }
      } while (!code.equalsIgnoreCase("Q"));
   }
}