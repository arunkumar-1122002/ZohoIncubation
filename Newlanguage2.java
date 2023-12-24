import java.util.Arrays;
import java.util.Scanner;
public class Newlanguage2 {
    public static void main(String[] args) {
        int[] Memory=new int[50];
        String query="+++++++++++++++++++++>.>.>.>.<<<<[->[+>]<<<<]>,>,>,>,";
        int length=query.length();
        int pointer=0;
        Scanner input=new Scanner(System.in);
        for(int i=0;i<length;i++)
        {
            char ch=query.charAt(i);
            switch(ch)
            {
                case '.':
                    System.out.println("Enter character");
                    char temp=input.next().charAt(0);
                    Memory[pointer]=(int)temp;
                    break;
                case ':':
                    System.out.println("Enter number");
                    Memory[pointer]=input.nextInt();
                    break;
                case '+':
                    Memory[pointer]+=1;
                    break;
                case '-':
                    Memory[pointer]-=1;
                    break;
                case '>':
                    pointer++;
                    break;
                case '<':
                    pointer--;
                    break;
                case '[':
                    if(Memory[pointer]==0)
                    {
                        for(int j=i;i<length;i++)
                        {
                            if(query.charAt(j)==']')
                            {
                                i=j;
                                break;
                            }
                        }
                    }
                    break;
                case ']':
                    if(Memory[pointer]!=0)
                    {
                        int helper=0;
                        for(int j=i-1;j>=0;j--)
                        {
                            if(query.charAt(j)=='[')
                            helper++;
                            if(query.charAt(j)==']')
                            helper--;
                            if(helper>0)
                            {
                                i=j;
                                break;
                            }
                        }
                    }
                    break;
                case ';':
                    System.out.println(Memory[pointer]);
                    break;
                case ',':
                    System.out.print((char)Memory[pointer]);
            }
        }
    }
}
