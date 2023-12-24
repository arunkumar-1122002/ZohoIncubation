public class Coolnumber {
    public static void main(String[] args) {
        int number=73501;
        int sum=0;
        int copy=number;
        while(copy>0)
        {
            sum+=copy%10;
            copy=copy/10;
        }
        System.out.println(isCoolNumber(sum, copy,number));
    }
    static boolean isCoolNumber(int sum,int process,int unprocess)
    {
        if((sum-process)==process)
        return true;
        if(unprocess==0)
        return false;
        boolean left= isCoolNumber(sum, process, unprocess/10);
        process=process+(unprocess%10);
        boolean right= isCoolNumber(sum, process, unprocess/10);
        return left||right;
    }
}
