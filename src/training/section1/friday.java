package training.section1;

/*
ID: m.vahid1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.Arrays;

/**
 * Created by Mohammad on 6/19/2016.
 */
public class friday {

    public static void main(String[] args) throws IOException {
        //Input file
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        //Output file
        PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter("friday.out"))));
        //Read
        int n = Integer.parseInt(f.readLine().trim());
        //mon 0, Tue 1, Wed 2, Thu 3, Fri 4, Sat 5, Sun 6
        int[] days = new int[7];
        Arrays.fill(days,0);
        int[] months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int currentDay = 0;

        for(int i=1900; i<=(1900+n-1); i++){
            if(isLeapYear(i)){
                months[1]=29;
            }else{
                months[1]=28;
            }
            for(int j=0; j<12; j++){
                if(i==1900 && j==0){
                    currentDay = 5;
                    days[currentDay]++;
                }else if(j == 0){
                    currentDay = (currentDay + months[11])%7;
                    days[currentDay]++;
                }else{
                    currentDay = (currentDay + months[j-1])%7;
                    days[currentDay]++;
                }

            }
        }

        System.out.print(days[5]+" ");
        System.out.print(days[6]+" ");
        System.out.print(days[0]+" ");
        System.out.print(days[1]+" ");
        System.out.print(days[2]+" ");
        System.out.print(days[3]+" ");
        System.out.print(days[4]+" ");

        out.print(days[5]+" ");
        out.print(days[6]+" ");
        out.print(days[0]+" ");
        out.print(days[1]+" ");
        out.print(days[2]+" ");
        out.print(days[3]+" ");
        out.print(days[4]+" ");

        out.close();

    }

    private static boolean isLeapYear(int year){
        if(year%100 == 0){
            if(year%400 == 0){
                return true;
            }else{
                return false;
            }
        }else if(year%4 == 0){
            return true;
        }else{
            return false;
        }

    }



}
