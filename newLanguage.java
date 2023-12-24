import java.util.Scanner;
public class newLanguage {
    public static void main(String[] args) 
    {
        Scanner inp=new Scanner(System.in);
        int[] Memory=new int[40];
      // Memory[0]=4;
       //Memory[1]=8;
 String query=":[->];<[->>+;<]<[->>>+;<<]<[->>[>]<<[->>+>+<<<]>>>[-<<<+>>>]<<[->>+>+<<<]>>>[-<<<+>>>]<[-<+>]<;[<]<]";
//Find square 
//String query=":[->+>+<<]>[->[->+>+<<]>>[-<<+>>]<<<]>>;";
//String query=":>:<[->[->+>+<<]>>[-<<+>>]<<<]>>[-->+<]>;";
       int Openposition=-1;
        int[] Opening=new int[15];
        int length=query.length();
        int pointer=0;
        for(int i=0;i<length;i++)
        {
            char ch=query.charAt(i);
            switch(ch)
            {
                case ':':
                    System.out.println("Enter number :");
                    Memory[pointer]=inp.nextInt();
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
                    Openposition++;
                    Opening[Openposition]=i;
                    break;
                case ']':
                    if(Memory[pointer]!=0)
                        i=Opening[Openposition];
                    else                
                        Openposition--;
                    break;
                case ';':
                    System.out.print(Memory[pointer]+" ");
                    break;
            }
        }
    }
    
}
