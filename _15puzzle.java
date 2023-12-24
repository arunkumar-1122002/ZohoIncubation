import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class _15puzzle 
{
 static Stack<String> stack=new Stack<>(); 
 static Stack<String> solution=new Stack<>();
static int[][] board;
static int[][] reset;
static int[][] resetempty=new int[1][2];
static int[][] empty=new int[1][2];
static int boardsize;
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        stack.push("");
        System.out.println("Enter board size:");
        boardsize=inp.nextInt();
        board=new int[boardsize][boardsize];
        reset=new int[boardsize][boardsize];
        createboard();
        display();
        System.out.println("");
        shuffleboard();
        updatereset();
        display();
        //empty=find_empty();
        while(check_answer())
        {
            System.out.println("1.left\n2.right\n3.top\n4.down\n5.reset and give solution\n6.Give hint");
            int n=inp.nextInt(); 
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            switch(n)
            {
                case 1:
                    empty=moveleft();
                    display();
                    break;
                case 2:
                    empty=moveright();
                    display();
                    break;
                case 3:
                    empty=movetop();
                    display();
                    break;
                case 4:
                    empty=movedown();
                    display();
                    break;
                case 5:
                    boardreset(); 
                    System.out.println("Board reset");
                    break;
                case 6:
                    System.out.println("Go "+stack.peek()+"\n");
                    break;
                default:
                    System.out.println("Select correct option in above");
                    
            }
        }
    }
    static void boardreset()
    {
               empty[0][0]=resetempty[0][0];
               empty[0][1]=resetempty[0][1];
                  for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
               board[i][j]=reset[i][j];          
            }           
        }
                    display();
               Collections.reverse(solution);
               System.out.println("Do this move to win game :\n " + solution);
               Collections.reverse(solution);
               stack=solution;
    }
    static boolean check_answer()
    {
        int valuegenerator=1;
        for (int i = 0; i < boardsize; i++)
        {
            for (int j = 0; j < boardsize; j++)
            {
                
                if(board[i][j]!=valuegenerator)
                    return true;
                valuegenerator++;
                
                if(valuegenerator==boardsize*boardsize)
                {
                    System.out.println("CONGRATES YOU WON THE GAME");
                    return false;
                }
                
            }
        }
        return false;
    }
    static void createboard(){
        int valuegenerator=1;
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; j < boardsize; j++) {
             board[i][j]=valuegenerator;
                valuegenerator++;
            }      
        }
        board[boardsize-1][boardsize-1]=0;
      empty[0][0]=boardsize-1;
      empty[0][1]=boardsize-1;
    }
    static void shuffleboard()
    {
        Random rd=new Random();
        for (int i = 0; i <boardsize*3; i++) {
            int move=rd.nextInt(4);
            switch(move%4)
            {
                case 0://shuffle top if its impossible move down
                    if(empty[0][0]==0)
                    {
                        empty=movedown();
                    }
                    else{
                    empty=movetop();
                    }
                    break;
                case 1://shuffle down if its impossible move top
                    if(empty[0][0]==boardsize-1)
                    {
                        empty=movetop();
                    }
                    else
                    {
                    empty=movedown();
                    }
                    break;
                case 2://shuffle left if its impossible move right
                    if(empty[0][1]==0)
                    {
                        empty=moveright();
                    }
                    else
                    {
                    empty=moveleft();
                    }
                    break;
                case 3://shuffle right if its impossible move left
                    if(empty[0][1]==boardsize-1)
                    {
                        empty=moveleft();
                    }
                    else
                    {
                    empty=moveright();
                    }
                    break;
            }
        }
        solution=stack;
    }
    static void display()
    {
        for (int i = 0; i < boardsize; i++) {
            System.out.print("|");
            for (int j = 0; j < boardsize; j++) {
                int value=board[i][j];
                if(value==0)
                {
                    System.out.print(" "+' '+"  |");
                continue;
                }
                if(value<10)
                System.out.print(" "+value+"  |");
                else
                    System.out.print(" "+value+" |");
                
            }
            System.out.println();
            
        }
    }
    static int[][] movetop()
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(row==0)
        {
            System.out.println("You cannot move up...invalid move");
        }
        else
        {
            if(stack.peek()=="top")
                stack.pop();
            else
            stack.push("down");
            swap(row,col,row-1,col);
         return new int[][]{{row-1,col}};
         
        }
        return empty;
    }
    static int[][] moveleft()
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(col==0)
        {
            System.out.println("You cannot move left...invalid move");
        }
        else
        {
            if(stack.peek()=="left")
                stack.pop();
            else
            stack.push("right");
            swap(row,col,row,col-1);
         return new int[][]{{row,col-1}};
        }
        
        return empty;
    }
    static int[][] moveright()
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(col==boardsize-1)
        {
            System.out.println("You cannot move right...invalid move");
        }
        else
        {
            if(stack.peek()=="right")
                stack.pop();
            else
            stack.push("left");
            swap(row,col,row,col+1);
         return new int[][]{{row,col+1}};
        }
       return empty; 
        
    }
    static int[][] movedown()
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(row==boardsize-1)
        {
            System.out.println("You cannot move down...invalid move");
        }
        else
        {
            if(stack.peek()=="down")
                stack.pop();
            else
            stack.push("top");
            swap(row,col,row+1,col);
         return new int[][]{{row+1,col}};
        }
     return empty;   
    }
    static void updatereset()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
               reset[i][j]=board[i][j];          
            }           
        }
               resetempty[0][0]=empty[0][0];
               resetempty[0][1]=empty[0][1];
    }
    static void swap(int source_row,int source_col,int dest_row,int dest_col)
    {
        int temp=board[source_row][source_col];
         board[source_row][source_col]=board[dest_row][dest_col];
         board[dest_row][dest_col]=temp;
    }
}
