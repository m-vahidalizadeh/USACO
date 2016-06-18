package training.section1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Mohammad on 6/18/2016.
 */
public class test {

        public static void main(String[] args) throws IOException {
            //Input file
            BufferedReader f = new BufferedReader(new FileReader("test.in"));
            //Output file
            PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter("test.out"))));
            //Tokenize
            StringTokenizer st = new StringTokenizer(f.readLine());
            //Read parameters
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            //Calculate
            int result = i1 + i2;
            //Output
            out.println(result);
            System.out.println(result);
            //Close file
            out.close();
        }


}
