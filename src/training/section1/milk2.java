package training.section1;

/*
ID: m.vahid1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

/**
 * Created by Mohammad on 6/22/2016.
 */
public class milk2 {

    public static void main(String[] args) throws IOException {
        //Input file
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        //Output file
        PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter("milk2.out"))));
        int n = Integer.valueOf(f.readLine().trim());
        StringTokenizer st = null;
        Integer start=0,finish=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        Gap[] gaps = new Gap[n];
        HashMap<Integer,Integer> pairs = new HashMap<>();
        HashMap<Integer,Integer> vacantPairs = new HashMap<>();
        for(int i=0;i<n;i++){
            st= new StringTokenizer(f.readLine());
            start = Integer.parseInt(st.nextToken());
            finish = Integer.parseInt(st.nextToken());
            if(start<min){
                min = start;
            }
            if(finish>max){
                max = finish;
            }
            Gap gap = new Gap(start,finish);
            gaps[i]= gap;
        }

        Arrays.sort(gaps);

        System.out.print("Sorted array: |");
        for(int i=0;i<n;i++){
            System.out.print(gaps[i].start+","+gaps[i].finish+"|");
        }


        pairs.put(gaps[0].start, gaps[0].finish);
        boolean flag = true;
        for(int i=1;i<n;i++){
            int mstart = gaps[i].start;
            int mend = gaps[i].finish;
            Iterator it = pairs.entrySet().iterator();
            while (it.hasNext() && flag) {
                Map.Entry pair = (Map.Entry)it.next();
//                System.out.println(pair.getKey() + " = " + pair.getValue());
//                it.remove(); // avoids a ConcurrentModificationException
                if(mstart <= (Integer) pair.getValue()){
                    pairs.put((Integer) pair.getKey(),mend);
                    flag=false;
                }
            }
            if(flag){
                pairs.put(mstart,mend);
            }
            flag =true;
        }

        System.out.println();
        Iterator it = pairs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getKey() + " - " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
        }

        int vacantMax=0,busyMax=0;
        Iterator it2 = pairs.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry pair = (Map.Entry)it2.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
            int tempResult =(Integer) pair.getValue()-(Integer) pair.getKey();
            if(tempResult>busyMax){
                busyMax= tempResult;
            }
        }
        System.out.println("Busy max: "+busyMax);
        System.out.println("______________________________________");

        Iterator it3 = pairs.entrySet().iterator();
        int startMemory=-1,endMemory=-1;
        while (it3.hasNext()) {
            Map.Entry pair = (Map.Entry)it3.next();
//            System.out.println(pair.getKey() + " - " + pair.getValue());
            if(startMemory!=-1 && endMemory==-1){
                endMemory= (Integer) pair.getKey();
                vacantPairs.put(startMemory, endMemory);
                startMemory=-1;
                endMemory=-1;

            }
            if(startMemory==-1){
                startMemory= (Integer) pair.getValue();
            }

        }


        Iterator it4 = vacantPairs.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry pair = (Map.Entry)it4.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
            int tempResult =(Integer) pair.getValue()-(Integer) pair.getKey();
            if(tempResult>vacantMax){
                vacantMax= tempResult;
            }

        }
        System.out.println("Vacant max: "+vacantMax);

        out.println(busyMax+" "+vacantMax);
        out.close();


    }

    private static class Gap implements Comparable<Gap>{
        Integer start;
        Integer finish;

        Gap(int s,int f){
            start = s;
            finish = f;
        }

        @Override
        public int compareTo(Gap o) {
            int compareQuantity = ((Gap) o).start;

            //ascending order
            return this.start - compareQuantity;

            //descending order
            //return compareQuantity - this.quantity;
        }
    }


}
