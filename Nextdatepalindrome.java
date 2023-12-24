import java.util.HashMap;
public class Nextdatepalindrome {
    public static void main(String[] args) {
        int date,month,year,answer;
        date=5;
        month=5;
        year=1998;
        HashMap<Integer,Integer> map=setDateEnd();
        answer=10;
        while(answer!=reverse(answer))
        {             
               
               if(date>=map.get(month))
               {
                date=1;
                month++;
               }
               if(month==13){
                date=1;
                month=1;
                year++;
               }
                date++;
               answer=mergeNumber(date, month, year);    
        }
        System.out.println(date+"-"+month+"-"+year);
    }
    static HashMap<Integer,Integer> setDateEnd()
    {
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 1; i <8; i++) 
         map.put(i,(i%2==1)?31:30); 
         for (int i = 8; i <13; i++) 
            map.put(i,(i%2==1)?30:31);

        map.put(2, 28);
        return map;
    }
    static int mergeNumber(int Date,int Month,int Year)
    {
        int ans;
        if(Month<10)
            ans=(Date*10)+Month;
        else
            ans=(Date*100)+Month;

    return ((ans*((int)Math.pow(10, noOfdigits(Year))))+Year);    
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
    }
