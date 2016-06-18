package training.section1;

import java.io.*;
import java.util.*;

/**
 * Created by Mohammad on 6/18/2016.
 */
public class gift1 {

    public static void main(String[] args) throws IOException {
        //Input file
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        //Output file
        PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter("gift1.out"))));
        //Read
        int n = Integer.parseInt(f.readLine().trim());
        HashMap<String,Integer> hm = new HashMap();
        String[] names = new String[10];
        for(int i=0; i<n; i++){
            String tempName = f.readLine().trim();
            hm.put(tempName,0);
            names[i] = tempName;
        }
        // Print hashmap
        printHM(hm);
        //Gift giving
        for(int i=0; i<n; i++){
            int quota = 0;
            String giver, recepient;
            int initialAmount=0;
            giver = f.readLine().trim();
            //Tokenize
            StringTokenizer st = new StringTokenizer(f.readLine());
            //Read parameters
            int amount = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            //Calculate
            if(number != 0){
                quota = (int) Math.floor(amount/number);
                initialAmount = hm.get(giver);
                hm.put(giver,initialAmount-(number*quota));
                for(int j=0; j<number; j++){
                    recepient = f.readLine().trim();
                    initialAmount = hm.get(recepient);
                    hm.put(recepient,initialAmount+quota);
                }
            }

            printHM(hm);
        }

        //Output
        for(int i=0; i<n; i++){
            out.println(names[i]+" "+hm.get(names[i]));
            System.out.println(names[i]+" "+hm.get(names[i]));
        }
        //Close file
        out.close();
    }

    private static void printHM(HashMap hm){
        // Get a set of the entries
        Set set = hm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }

}
