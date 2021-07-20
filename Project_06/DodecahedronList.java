import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
*This program creates a class with methods that accept parameters and return 
*values.
*
*
*Project 6
*@author Robert Henning - CPCS 1213-A01
*@version 09/28/2019
*/
public class DodecahedronList {

/**
*Lays out instance variables, constructors, and methods of Dodecahedron.
*
*
*@param args Command line arguments - not used
*/
   private String listName = "";
   private ArrayList<Dodecahedron> dList;
   private DecimalFormat fm1 = new DecimalFormat("#,##0.0##");
  
/**
*Creates the constructor for the DodecahedronList class. 
*
*
*@param listNameIn Command line arguments - not used
*@param dListIn Command line arguments - not used
*/
   public DodecahedronList(String listNameIn, 
      ArrayList<Dodecahedron> dListIn) {
      listName = listNameIn;
      dList = dListIn;
   
   }
 
/**
*Creates the getName method for the DodecahedronList class. 
*
*
*@return listName
*/     
   public String getName() {
      return listName;
   }

/**
*Creates the numberOfDodecahedrons method for the DodecahedronList class. 
*
*
*@return dList.size()
*/        
   public int numberOfDodecahedrons() {
      return dList.size();
   }

/**
*Creates the totalSurfaceArea method for the DodecahedronList class. 
*
*
*@return surfaceArea
*/        
   public double totalSurfaceArea() {
      double surfaceArea = 0.0;
      int index = 0;
      while (index < dList.size()) {
         surfaceArea += dList.get(index).surfaceArea();
         index++;
      }
      if (index < 1) {
         return 0;
      }
      else {
         return surfaceArea;
      }
   }

/**
*Creates the totalVolume method for the DodecahedronList class. 
*
*
*@return volume
*/          
   public double totalVolume() {
      double volume = 0.0;
      int index = 0;
      while (index < dList.size()) {
         volume += dList.get(index).volume();
         index++;
      }
      if (index < 1) {
         return 0;
      }
      else {
         return volume;
      }
   }
   
/**
*Creates the averageSurfaceArea method for the DodecahedronList class. 
*
*
*@return avgSurfaceArea
*/          
   public double averageSurfaceArea() {
      double surfaceArea1 = 0.0;
      double avgSurfaceArea = 0.0;
      int index = 0;
      while (index < dList.size()) {
         surfaceArea1 += dList.get(index).surfaceArea();
         index++;
      }
      avgSurfaceArea = surfaceArea1 / index;
      if (index < 1) {
         return 0;
      }
      else {
         return avgSurfaceArea;
      }
   }

/**
*Creates the averageVolume method for the DodecahedronList class. 
*
*
*@return avgVolume
*/          
   public double averageVolume() {
      double volume1 = 0.0;
      double avgVolume = 0.0;
      int index = 0;
      while (index < dList.size()) {
         volume1 += dList.get(index).volume();
         index++;
      }
      avgVolume = volume1 / index;
      if (index < 1) {
         return 0;
      }
      else {
         return avgVolume;
      }
   }
   
/**
*Creates the averageSurfaceToVolumeRatio method for the DodecahedronList class. 
*
*
*@return avgSurfacetoVolume
*/          
   public double averageSurfaceToVolumeRatio() {
      double surfaceToVolume = 0.0;
      double avgSurfaceToVolume = 0.0;
      int index = 0;
      while (index < dList.size()) {
         surfaceToVolume += dList.get(index).surfaceToVolumeRatio();
         index++;
      }
      avgSurfaceToVolume = surfaceToVolume / index;
      if (index < 1) {
         return 0;
      }
      else {
         return avgSurfaceToVolume;
      }
   }
  
/**
*Creates the toString method for the DodecahedronList class. 
*
*
*@return dInfo
*/        
   public String toString() {
      String dSpec = "";
      int index = 0;
      while (index < dList.size()) {
         dSpec += "\n" + dList.get(index).toString() + "\n";
         index++;
      }
      String dInfo = listName + "\n" + dSpec;
      return dInfo;
   }
   
/**
*Creates the summaryInfo method for the DodecahedronList class. 
*
*
*@return dSummary
*/       
   public String summaryInfo() {
      String dSummary = "---- Summary for " + listName + " -----";
      dSummary += "\nNumber of Dodecahedrons: " + dList.size();
      dSummary += "\nTotal Surface Area: " + fm1.format(totalSurfaceArea());
      dSummary += "\nTotal Volume: " + fm1.format(totalVolume());
      dSummary += "\nAverage Surface Area: " + fm1.format(averageSurfaceArea());
      dSummary += "\nAverage Volume: " + fm1.format(averageVolume());
      dSummary += "\nAverage Surface/Volume Ratio: "
         + fm1.format(averageSurfaceToVolumeRatio()) + "\n";
      return dSummary;
   }

/**
*Creates the getList method for the DodecahedronList class. 
*
*
*@return dList
*/    
   public ArrayList<Dodecahedron> getList() {
      return dList;
   }

/**
*Creates the readFile method for the DodecahedronList class. 
*
*
*@param fileNameIn Command line Arguments - not used
*@return myD12List
*@throws IOException from scanning input file
*/
   public DodecahedronList readFile(String fileNameIn)
                                    throws IOException {
                                    
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Dodecahedron> myList = new ArrayList<Dodecahedron>();
      String dListName = "";
      String label = "";
      String color = "";
      double edge = 0;
        
      dListName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Dodecahedron d12 = new Dodecahedron(label, color, edge);
         myList.add(d12);
      }
      
      DodecahedronList myD12List = new DodecahedronList(dListName, myList);
      return myD12List;
   }
   
/**
* Creates the addDodecahedron method for the DodecahedronList Class.
*   
* @param labelIn Command Line arguments - not used
* @param colorIn Command Line arguments - not used
* @param edgeIn Command Line arguments - not used
*/   
   public void addDodecahedron(String labelIn, String colorIn, double edgeIn) {
   
      Dodecahedron d = new Dodecahedron(labelIn, colorIn, edgeIn);
   
      dList.add(d);
   }
   
/**
* Creates the findDodecahedron method for the DodecahedronList Class.
*   
*@param labelIn Command Line arguments - not used
*@return d12
*/
   public Dodecahedron findDodecahedron(String labelIn) {
      Dodecahedron d12 = null;
      int index = -1;
      for (Dodecahedron d : dList) {
         if (d.getLabel().equalsIgnoreCase(labelIn)) {
            index = dList.indexOf(d);
            d12 = dList.get(index);
            break;
         }
      }
      return d12;    
   }
 
/**
* Creates the deleteDodecahedron method for the DodecahedronList Class.
*   
* @param labelIn Command Line arguments - not used
* @return d12
*/      
   public Dodecahedron deleteDodecahedron(String labelIn) {  	
      Dodecahedron d12 = null;
      int index = -1;
      for (Dodecahedron d : dList) {
         if (d.getLabel().equalsIgnoreCase(labelIn)) {
            index = dList.indexOf(d);
            d12 = dList.get(index);
            break;
         }
      }
          	
      if (index >= 0) {
         dList.remove(index);
      } 
      return d12;    
   }

/**
* Creates the editDodecahedron method for the DodecahedronList Class.
*   
* @param labelIn Command Line arguments - not used
* @param colorIn Command Line arguments - not used
* @param edgeIn Command Line arguments - not used
* @return true if deleted else return false
*/   
   public boolean editDodecahedron(String labelIn, String colorIn,
                                                       double edgeIn) {
      boolean result = false;
      int index = -1;
      Dodecahedron d12 = null;
      for (Dodecahedron d : dList) {
         if (d.getLabel().equalsIgnoreCase(labelIn)) {
            index = dList.indexOf(d);
            d12 = dList.get(index);
            break;
         }
      }
         
      if (index >= 0) {
         d12.setLabel(labelIn);
         d12.setColor(colorIn);
         d12.setEdge(edgeIn);
         result = true;
      }
      return result;
   }
}