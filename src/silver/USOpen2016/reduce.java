package silver.USOpen2016;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Mohammad on 4/2/2016.
 */
public class reduce {

    private static int[] x;
    private static int[] y;
    private static int n;
    private static int[] xSorted;
    private static int[] ySorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x= new int[n];
        y= new int[n];
        xSorted = new int[n];
        ySorted = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i]= Integer.parseInt(st.nextToken());
            y[i]= Integer.parseInt(st.nextToken());
            xSorted[i]= x[i];
            ySorted[i]= y[i];
        }

        int xMax=-1;
        int xMin=-1;
        int yMax=-1;
        int yMin=-1;

        //First try
        double xMean = meanFinder(x);
        double yMean = meanFinder(y);
        int bestLocation= -1;
        double maxDistance = Double.MIN_VALUE;
        double tempDistance = 0;

        for(int i=0; i<n; i++){
            tempDistance= distanceFinder(x[i],y[i],xMean,yMean);
            if((tempDistance > maxDistance) && (x[i] != -1) ){
                maxDistance= tempDistance;
                bestLocation= i;
            }
        }
        removePoint(bestLocation);
        //x
        //max
        xMax= maxFinder(xSorted);
        //min
        xMin= minFinder(xSorted);
        //y
        //max
        yMax= maxFinder(ySorted);
        //min
        yMin= minFinder(ySorted);

        //Second try
        xMean = meanFinder(x);
        yMean = meanFinder(y);
        bestLocation= -1;
        maxDistance = Double.MIN_VALUE;
        tempDistance = 0;

        for(int i=0; i<n; i++){
            tempDistance= distanceFinder(x[i],y[i],xMean,yMean);
            if((tempDistance > maxDistance) && (x[i] != -1)){
                maxDistance= tempDistance;
                bestLocation= i;
            }
        }

        removePoint(bestLocation);
        //x
        //max
        xMax= maxFinder(xSorted);
        //min
        xMin= minFinder(xSorted);
        //y
        //max
        yMax= maxFinder(ySorted);
        //min
        yMin= minFinder(ySorted);

        //Third try
        xMean = meanFinder(x);
        yMean = meanFinder(y);
        bestLocation= -1;
        maxDistance = Double.MIN_VALUE;
        tempDistance = 0;

        for(int i=0; i<n; i++){
            tempDistance= distanceFinder(x[i],y[i],xMean,yMean);
            if((tempDistance > maxDistance) && (x[i] != -1) ){
                maxDistance= tempDistance;
                bestLocation= i;
            }
        }

        removePoint(bestLocation);
        //x
        //max
        xMax= maxFinder(xSorted);
        //min
        xMin= minFinder(xSorted);
        //y
        //max
        yMax= maxFinder(ySorted);
        //min
        yMin= minFinder(ySorted);
        int tempArea= findArea(xMin,yMin,xMax,yMax);

        pw.println(tempArea);
        pw.close();


    }

    private static int minFinder(int[] input){
        for(int i=0; i<input.length; i++){
            if(input[i] != -1){
                return input[i];
            }
        }
        return -1;
    }

    private static void removePoint(int i){

        nullifyMember(x[i],y[i]);
        x[i]= -1;
        y[i]= -1;
    }

    private static double distanceFinder(int x1,int y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }

    private static int maxFinder(int[] input){
        for(int i=input.length-1; i>=0; i--){
            if(input[i] != -1){
                return input[i];
            }
        }
        return -1;
    }

    private static int findArea(int xMin, int yMin, int xMax, int yMax){
        return (yMax-yMin)*(xMax-xMin);
    }

    private static double meanFinder(int[] input){
        double result= 0;
        int resultNumber= 0;
        int tempMember;
        for(int i=0; i<input.length; i++){
            tempMember= input[i];
            if(tempMember != -1){
                result = result + tempMember;
                resultNumber++;
            }
        }
        return result/resultNumber;
    }

    private static void nullifyMember(int inputX, int inputY){
        {
            boolean xNulled= false;
            boolean yNulled= false;
            for(int i=0;i<xSorted.length; i++){
                if(xSorted[i] == inputX){
                    xSorted[i]= -1;
                    xNulled= true;
                }
                if(ySorted[i] == inputY){
                    ySorted[i]= -1;
                    yNulled= true;
                }
                if(xNulled && yNulled){
                    break;
                }
            }
        }
    }


}
