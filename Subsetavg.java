import java.util.Arrays;

public class Subsetavg {
    public static void main(String[] args) {
        int arr[]={20,40,60};
        int[] process=new int[arr.length];
        printSubArrayAvg(process, arr, arr.length);
    }
    static void printSubArrayAvg(int[] process,int[] unprocess,int limit)
    {
        if(average(process)==average(unprocess))
        {
            System.out.println((Arrays.toString(process))+" "+Arrays.toString(unprocess));
            return;
        }
        if(limit==0) return;
        limit--;
        for (int i = 0; i <=limit ; i++)
        {
            process[limit]=unprocess[i];
            unprocess[i]=0;
            printSubArrayAvg(process, unprocess, limit);
        }
    }
    static double average(int[] arr)
    {
        double avg=0;
        for (int i = 0; i < arr.length; i++) 
        {
             avg+=arr[i];   
        }
        return avg/arr.length;
    }
}
