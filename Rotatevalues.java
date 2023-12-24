
import java.util.Scanner;
public class Rotatevalues {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
    System.out.println("Enter the String:");
     String word=inp.nextLine();
     System.out.println("Enter Integer");
    int num=inp.nextInt();
    System.out.println("Enter no of rotation:");
       int rotation=inp.nextInt();
         System.out.println(rotateString(word,rotation));
     System.out.println(rotateInteger(num,rotation));
     inp.close();
    }
    static String rotateString(String word,int rotate)
    {
        String first="",last="";
        int strlength=word.length();
          for (int i = 0; i < strlength; i++)
          {
          if(i>=rotate)
          first+=word.charAt(i);
          else
          last+=word.charAt(i);
          }
          return first+last;
    }
    static int rotateInteger(int num,int rotation)
    {
        int copy=num;
        int length=0;
        while(copy>0)
        {
            copy=copy/10;
            length++;
        }
        int divider=tenPower(length-rotation);
        copy=num/divider;
        num=num%divider;
        num=num*tenPower(rotation);
        return num+copy;
    }
    static int tenPower(int pow)
    {
        int num=1;
        for (int i = 0; i <pow ; i++) {
            num*=10;
        }
        return num;
    }
}
