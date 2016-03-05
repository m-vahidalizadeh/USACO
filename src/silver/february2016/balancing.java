package silver.february2016;

import java.io.*;
import java.util.*;

/**
 * Created by Mohammad on 3/4/2016.
 */
public class balancing {

    private static int[] x;
    private static int[] y;
    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x= new int[n];
        y= new int[n];
        int[] xSorted = new int[n];
        int[] ySorted = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i]= Integer.parseInt(st.nextToken());
            y[i]= Integer.parseInt(st.nextToken());
            xSorted[i]= x[i];
            ySorted[i]= y[i];
        }


        Arrays.sort(xSorted);
        Arrays.sort(ySorted);

        int midX;
            midX= (int) Math.ceil(n/2);

        int midY;
            midY= (int) Math.ceil(n/2);

//        System.out.println("original:");
//        for(int i=0; i<n; i++){
//            System.out.println(x[i]+","+y[i]);
//        }
//
//        System.out.println("sorted:");
//        for(int i=0; i<n; i++){
//            System.out.println(x[i]+","+y[i]);
//        }

//        System.out.println("n: "+n+" midx: "+midX+" midY: "+midY);
        int min= Integer.MAX_VALUE;
        int a, b;
        int result;
        int domain= Math.round(n/10+n/20)+1;

            for(int i=-domain;i<=domain;i++){
                for(int j=-domain;j<=domain;j++){
                    a= midX+i;
                    b= midY+j;
                    result= Math.min(Math.min(check(xSorted[a]-1,ySorted[b]-1),check(xSorted[a]-1,ySorted[b]+1)),Math.min(check(xSorted[a]+1
                            ,ySorted[b]-1),check(xSorted[a]+1,ySorted[b]+1)));
                    min = Math.min(min, result);
                }
            }


        pw.println(min);
        pw.close();
    }


    private static int check(int A, int B){
        int region1=0, region2=0, region3=0, region4=0;
//        System.out.println("-------------------------------------");
        for(int i=0;i<n;i++){
                if((x[i]<A) && (y[i]>B)){
                    region1++;
//                    System.out.println(x[i]+","+y[i]+" region1");
                }else if((x[i]>A) && (y[i]>B)){
                    region2++;
//                    System.out.println(x[i]+","+y[i]+" region2");
                }else if((x[i]<A) && (y[i]<B)){
                    region3++;
//                    System.out.println(x[i]+","+y[i]+" region3");
                }else{
                    region4++;
//                    System.out.println(x[i]+","+y[i]+" region4");
                }

        }

//        System.out.println("a: "+A+" b: "+B+" Max: "+Math.max(Math.max(region1,region2), Math.max(region3, region4)));
//        System.out.println(region1+", "+region2+", "+region3+", "+region4);
//        System.out.println("----------------------------------------");
        return Math.max(Math.max(region1,region2), Math.max(region3, region4));
    }


}
