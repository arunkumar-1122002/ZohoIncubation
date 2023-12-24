import java.util.Scanner;
/*program to print next 10 palindrome numbers for given input..You can optimize if you want for 1 number*/
public class Nextpalindrome{
public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int num=inp.nextInt();
        for (int i = 0; i < 10; i++) {
            num=findSolution(num);
            System.out.println(num);
        }
    }
    static int findSolution(int num)
    {
        int count=noOfdigits(num),multiplier;
        multiplier=(int)Math.pow(10,count/2);
        int quationt=num/multiplier;
        int remainder=num%multiplier; 
        int quationRev=reverse(quationt);
        if(isOdd(count))
        quationRev=reverse(quationt/10);
       if(quationRev>remainder)
       return((quationt*multiplier)+quationRev);
       else 
       {
        if(isOdd(count))
        return(((quationt+1)*(multiplier))+reverse((quationt+1)/10));
        else
       return((quationt+1)*multiplier+reverse(quationt+1));
       }
    }
    static boolean isOdd(int num)
    {
    return num%2==1;
    }
    static int reverse(int num)
    {
        int r,ans=0;
        while(num>0)
        {
           r=num%10;
         ans=(ans*10)+r;
         num=num/10;
        }
        return ans;
    }
    static int noOfdigits(int num)
    {
        int count=0;
        while(num>0)
        {
           num=num/10;
           count++;
        }
        return count;
    }
}
