package training.section1;

/*
ID: m.vahid1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.Arrays;

/**
 * Created by Mohammad on 6/19/2016.
 */
public class beads {

    public static void main(String[] args) throws IOException {
        //Input file
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        //Output file
        PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter("beads.out"))));
        //Read
        boolean circularTrap = false;
        int n = Integer.parseInt(f.readLine().trim());
        int max = -1;
        int backwardPoint = 0;
        int forwardPoint = 0;
        int result = 0;
        char[] necklace = f.readLine().trim().toCharArray();

        for(int i=0;i<necklace.length; i++){
            backwardPoint = backwardCheck(i,necklace);
            if(backwardPoint == n){
                max = n;
                circularTrap = true;
                break;
            }else{
                forwardPoint = forwardCheck(forward(i,n),necklace);
            }
            result = backwardPoint+forwardPoint;
            System.out.println("Total: "+result);
            System.out.println("++++++++++++++++++++++++++++++++++++");
            if(result > max){
                max = result;
            }
        }

        if(max>n)
            max = n;
        out.println(max);
        System.out.println("Max: "+max);
        out.close();

    }

    private static int forwardCheck(int position, char[] necklace){
        int counter=1;
        char currentColor = necklace[position];
        int next=forward(position,necklace.length);
        System.out.print("Forward: "+necklace[position]+" ");

        if(currentColor == 'w'){
            if(necklace[forward(position,necklace.length)] != 'w'){
                currentColor = necklace[forward(position,necklace.length)];
            }else{
                currentColor = necklace[forward(forward(position,necklace.length),necklace.length)];
            }
        }
        while( ( (necklace[next] == currentColor) || (necklace[next] == 'w') ) && (counter < necklace.length) ){
            counter++;
            position = next;
            next=forward(position,necklace.length);
            System.out.print(necklace[position]+" ");
        }

        System.out.println("Result: "+counter);
        return counter;
    }

    private static int backwardCheck(int position, char[] necklace){
        int counter=1;
        char currentColor = necklace[position];
        int next=backward(position,necklace.length);
        System.out.print("Backward: "+necklace[position]+" ");
        if(currentColor == 'w'){
            if(necklace[forward(position,necklace.length)] != 'w'){
                currentColor = necklace[backward(position,necklace.length)];
            }else{
                currentColor = necklace[backward(backward(position,necklace.length),necklace.length)];
            }
        }
        while( ( (necklace[next] == currentColor) || (necklace[next] == 'w') ) && (counter < necklace.length) ){
            counter++;
            position = next;
            next=backward(position,necklace.length);
            System.out.print(necklace[position]+" ");
        }
        System.out.println("Result: "+counter);
        return counter;
    }

    private static int forward(int position, int n){
        return (position+1)%n;
    }

    private static int backward(int position, int n){
        if(position == 0){
            return n-1;
        }else{
            return position-1;
        }
    }



}
