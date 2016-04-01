package silver.february2016;

import java.io.*;
import java.util.*;

/**
 * Created by Mohammad on 3/22/2016.
 */
public class cbarn {
    private static int[] c;
    private static int roomFinderDistance;
    private static LinkedList emptyRooms = new LinkedList();
    private static int n;
    public static void main(String[] args) throws IOException {

        //Read the inputs and initialize the outputs
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c= new int[n];
        emptyRooms = new LinkedList();
        System.out.println("Rooms:");
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            c[i] = Integer.parseInt(st.nextToken());
            if(c[i] == 0){
                emptyRooms.add(i);
            }
            System.out.println(c[i]);
        }

        System.out.println("Empty Rooms:");
        for(int i=0; i<emptyRooms.size(); i++){
            System.out.println(emptyRooms.get(i));
        }

        int totalCost= 0;
        HashMap emptyRoomsCosts = new HashMap();

        while(emptyRooms.size() > 0){
            int min= Integer.MAX_VALUE;
            int minIndex = -1;
            int targetIndex = -1;

            for(int i=0; i<emptyRooms.size(); i++){
//            System.out.println(emptyRooms.get(i));
                int candidateIndex = roomFinder((int) emptyRooms.get(i));
                if(roomFinderDistance < min){
                    min = roomFinderDistance;
                    minIndex = candidateIndex;
                    targetIndex = (int) emptyRooms.get(i);
                }
            }

            applyMove(minIndex,targetIndex);
            int tempDistance = distanceFinder(minIndex,targetIndex);
            totalCost = totalCost + tempDistance*tempDistance;

            System.out.println("\nRoom finder distance: "+tempDistance);

            System.out.println("Empty Rooms:");
            for(int i=0; i<emptyRooms.size(); i++){
                System.out.print(emptyRooms.get(i)+",");
            }

            System.out.println("\nRooms:");
            for(int i=0; i<n; i++){
                System.out.print(c[i]+",");
            }

            System.out.println("\nTotal cost: "+totalCost);


        }


        //Minimum
//        int minEnergy= Integer.MAX_VALUE;

        //Print the outputs
        System.out.println("\nTotal cost: "+totalCost);
        pw.println(totalCost);
        pw.close();
    }

    public static int roomFinder(int index){
        roomFinderDistance= 0;
        index = previousFinder(index);
        while(c[index] < 1){
            index = previousFinder(index);
            roomFinderDistance++;
        }
        return index;
    }

    private static int previousFinder(int index){
        if(index == 0){
            return c.length-1;
        }else{
            return index - 1;
        }
    }

    private static int
    nextFinder(int index){
        if(index == n-1){
            return 0;
        }else{
            return index + 1;
        }
    }

    private static void applyMove(int source, int target){

        System.out.println("\nmove from: "+source+" to "+target);

        c[source]--;
        if(c[source] == 0){
            emptyRooms.add(source);
        }
        int tempRemoveIndex = emptyRooms.indexOf(target);
        emptyRooms.remove(tempRemoveIndex);
        c[target]++;

    }

    private static int distanceFinder(int source, int target){
        int distance = 0;
        while(source != target){
            source = nextFinder(source);
            distance++;
        }
        return distance;
    }

}
