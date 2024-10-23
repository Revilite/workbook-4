package com.pluralsight.cars;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        try{
        BufferedReader buffRead = new BufferedReader(new FileReader("./src/main/resources/WorkshopFiles/inventory.csv"));
        String[] fileLine = buffRead.readLine().split("[|]");
        return new Dealership(fileLine[0], fileLine[1], fileLine[2]);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void saveDealership(Dealership dealership) throws IOException{
        try{
        BufferedWriter buffWrite =  new BufferedWriter(new FileWriter("./src/main/resources/WorkshopFiles/inventory.csv", true));
        buffWrite.write(dealership.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
