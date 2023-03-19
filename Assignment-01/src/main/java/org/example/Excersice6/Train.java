package org.example.Excersice6;

import java.util.*;

public class Train {
    public static void main(String[] args) {

        List<String> stations = new LinkedList<>();

        stations.addAll(Arrays.asList("Colombo Fort", "Maradana", "Dematagoda", "Kelaniya", "Wanawasala", "Hunupitiya", "Ederamulla"));

        Scanner input = new Scanner(System.in);

        int x =0;
        for (String station : stations) {

            System.out.println( "["+x+"] " +station);
            x++;
        }

        try {
            System.out.println("Enter Start Location : ");
            Integer startIndex = input.nextInt();

            System.out.println("Enter Destination Location : ");
            Integer endIndex = input.nextInt();
            if(!(startIndex>=0 && startIndex<stations.size() && endIndex>=0 && endIndex<stations.size())){
               throw new Exception("Invalid input");
            }

            String start =stations.get(startIndex);

            String destination = stations.get(endIndex);

            Iterator<String> iterator = stations.iterator();
            Boolean startFound= false;

            while(iterator.hasNext()){
                String temp = iterator.next();
                if(temp.equals(start)){
                    startFound =true;
                    System.out.print(temp + "->");
                    continue;
                }

                if (temp.equals(destination)){
                    System.out.print(temp+".");
                    break;
                }
                if(startFound) {
                    System.out.print(temp+"->");
                }
                // next() return the next element in the iteration
            }

        }
        catch (Exception e){
            System.out.println("Invalid Input");
            System.exit(0);
        }




    }
}
