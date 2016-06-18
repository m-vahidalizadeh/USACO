package training.section1;

import java.io.*;

/**
 * Created by Mohammad on 6/18/2016.
 */
public class ride {
    private static final String GO = "GO", STAY="STAY";
    public static void main(String[] args) throws IOException {
        //Input file
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        //Output file
        PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter("ride.out"))));
        //Read parameters
        char[] cometName = f.readLine().trim().toCharArray();
        char[] groupName = f.readLine().trim().toCharArray();
        //Calculate and output
        if(calculateValue(cometName) == calculateValue(groupName)){
            out.println(GO);
            System.out.println(GO);
        }else{
            out.println(STAY);
            System.out.println(STAY);
        }
        //Close file
        out.close();
    }

    private static int calculateValue(char[] input){
        int result = 1;
        for(int i=0; i<input.length; i++){
            result = result * (input[i]-'A'+1);
        }
        return result % 47;
    }
}
