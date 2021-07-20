import java.text.DecimalFormat;
/**
*This program creates a class with methods that accept parameters and return 
*values.
*
*
*Project 6
*@author Robert Henning - CPCS 1213-A01
*@version 09/28/2019
*/
public class Dodecahedron {
/**
*Lays out instance variables, constructors, and methods of Dodecahedron.
*
*
*@param args Command line arguments - not used
*/
   // instance variables
   private String label = "";
   private String color = "";
   private double edge = 0;

/**
*Creates the constructor for the Dodecahedron class. 
*
*
*@param labelIn Command line arguments - not used
*@param colorIn Command line arguments - not used
*@param edgeIn Command line arguments - not used
*/
   // constructor
   public Dodecahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   }
         
   // methods
/**
*Creates the setLabel method for the Dodecahedron class. 
*
*
*@param labelIn Command line arguments - not used
*@return isSet
*/     
   public boolean setLabel(String labelIn) {
      boolean isSet = false;
      if (labelIn != null) {
         label = labelIn.trim();
         isSet = true;
      }
      return isSet;
   }
   
/**
*Creates the getLabel method for the Dodecahedron class. 
*
*
*@return label
*/   
   public String getLabel() {
      return label;
   }
   
/**
*Creates the setColor method for the Dodecahedron class. 
*
*
*@param colorIn Command line arguments - not used
*@return isSet2
*/  
   public boolean setColor(String colorIn) {
      boolean isSet2 = false;
      if (colorIn != null) {
         color = colorIn.trim();
         isSet2 = true;
      }
      return isSet2;
   }
   
/**
*Creates the getColor method for the Dodecahedron class. 
*
*
*@return color
*/   
   public String getColor() {
      return color;
   }
   
/**
*Creates the setEdge method for the Dodecahedron class. 
*
*
*@param edgeIn Command line arguments - not used
*@return isSet3
*/
   public boolean setEdge(double edgeIn) {
      if (edgeIn < 0) {
         return false;
      }
      else {
         edge = edgeIn;
         return true;
      }
   }

/**
*Creates the getEdge method for the Dodecahedron class. 
*
*
*@return edge
*/   
   public double getEdge() {
      return edge;
   }
   
/**
*Creates the SurfaceArea method for the Dodecahedron class. 
*
*
*@return surfaceArea
*/   
   public double surfaceArea() { 
      return 3 * Math.sqrt(25 + (10 * Math.sqrt(5))) * Math.pow(edge, 2);
   }
   
/**
*Creates the Volume method for the Dodecahedron class. 
*
*
*@return volume
*/
   public double volume() {
      return ((15 + (7 * Math.sqrt(5))) / 4) * Math.pow(edge, 3);
   }
   
/**
*Creates the SurfaceToVolumeRatio method for the Dodecahedron class. 
*
*
*@return surfaceToVolumeRatio
*/   
   public double surfaceToVolumeRatio() {
      return surfaceArea() / volume();
      
   }
/**
*Creates the toString method for the Dodecahedron class. 
*
*
*@return output
*/
   public String toString() {
      DecimalFormat fm1 = new DecimalFormat("#,##0.0##");
      
      String output = "Dodecahedron \"" + label + "\" is \"" + color + "\""
         + " with 30 edges of length " + edge + " units.\n";
      output += "\tsurface area = " + fm1.format(surfaceArea())
         + " square units\n";
      output += "\tvolume = " + fm1.format(volume()) + " cubic units\n";
      output += "\tsurface/volume ratio = " 
         + fm1.format(surfaceToVolumeRatio());
      return output;
   }
   

}
  
