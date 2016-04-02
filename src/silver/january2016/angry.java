package silver.january2016;

/**
 * Created by Mohammad on 4/1/2016.
 */

import java.io.*;
import java.util.*;

public class angry {

    public static void main(String[] args) throws IOException {
        try {
            //Reading the input file
            BufferedReader br = new BufferedReader(new FileReader("angry.in"));

            //Initializing the output file
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

            //Reading the first line
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            //Reading the remaining n lines
            int[] locations = new int[n];
            for(int i = 0; i < n; i++) {
                locations[i] = Integer.parseInt(br.readLine());
            }

            //Sort the locations
            Arrays.sort(locations);

            //energy should be something between zero and the number of hay bales
            int min = 0;
            int max = 500000000;
            while(min != max) {
                int mid = (min+max)/2;
                int used = 0;
                int last = 0;
                while(last < n) {
                    //Use another cow
                    used++;
                    int curr = last+1;
                    while(curr < n && locations[curr] - locations[last] <= 2*mid) {
                        curr++;
                    }
                    last = curr;
                }

                //Check if the number of used cows are less than allowed
                if(used <= k) {
                    max = mid;
                }
                else {
                    //Remember we are using binary search
                    min = mid+1;
                }
            }

            pw.println(min);
            pw.close();

        }catch(Exception e){
            System.out.println(e.toString());
        }

    }

}
