import java.util.*;
import java.io.*;
public class Car {

   private int fuelCap;
   private int fuelEff;
   private int mileage;
   private double fuelLevel;
   private String name;
   
   public Car(String str, int max, int eff, int miles) {
      name = str;
      if (max < 0)
      {
         throw new IllegalArgumentException("Gas capacity is too low!");
      }
      else
      {
      fuelCap = max;
      }
      fuelEff = eff;
      fuelLevel = fuelCap / 2;
   }
    
   
   
   public String toString() {
      return String.format("%-20s %14d %6d %12.1f %9d", name, fuelCap, fuelEff, fuelLevel, mileage);

   }
   public void drive (int driven) {
      
        if (fuelLevel - driven/fuelEff < 0) {
            throw new IllegalArgumentException("Gas is not sufficient!");
        } 
        else {
            fuelLevel -= driven/fuelEff;
        }
        mileage+=driven;
   }
   
   public void addGas (double gas) {
      
      if ((fuelLevel + gas) > fuelCap)
      {
         throw new IllegalArgumentException("Gas exceeds the cap of fue!");
      }
      else {
         fuelLevel+= gas;
      }
   
   }
   
   public int getCap () {
      return fuelCap;
   }
   
   public int getEff () {
      return fuelEff;
   }
   
   public int getMil () {
      return mileage;
   }
   
   public double getFuelLevel () {
      return fuelLevel;
   }
   
   public String getName() {
      return name;
   }


}
