import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    static int correct_result = 0;
    static int flag_count=0;
    static int no_of_bomb=0;
    static int boardsize=0;
    static char[][] displayArray ;
    static char[][] dataArray;
    static void difficultylevel(String str)
    {
        switch (str) {
            case "easy":
                System.out.println("You need to find 2 bomb");
                no_of_bomb+=2;
                boardsize+=5;
                boardsetup();
                break;
            case "medium":
                System.out.println("You need to find 3 bomb");
                no_of_bomb+=3;
                boardsize+=6;
                boardsetup();
                break;
            case "hard":
                System.out.println("You need to find 6 bomb");
                no_of_bomb+=6;
                boardsize+=8;
                boardsetup();
                break;
        }
       
    }
    static void boardsetup()
    {
        Random rn=new Random();
        dataArray=new char[boardsize][boardsize];
        displayArray=new char[boardsize][boardsize];
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; j <boardsize; j++) {
                dataArray[i][j]=' ';
                displayArray[i][j]='?';
            }
        }
      for (int i = 0; i <no_of_bomb; i++)
        {  
            int row=rn.nextInt(boardsize);
            int col=rn.nextInt(boardsize);
            if(dataArray[row][col]==' ')
            {
            dataArray[row][col]='B';
            countBomb(row,col);
            }
            else if((col+1)!=boardsize && dataArray[row][col]=='B')
            {
            dataArray[row][col+1]='B';
            countBomb(row,col+1);
            }
            else if((row+1)!=boardsize && dataArray[row][col+1]=='B')
            {
                dataArray[row+1][col]='B';
                countBomb(row+1,col);
            }
            else if((row-1)!=-1 && dataArray[row+1][col]=='B')
            {
                dataArray[row-1][col]='B';
                countBomb(row-1,col);
            }
            else if((col-1)!=-1 && dataArray[row-1][col]=='B')
            {
                dataArray[row][col-1]='B';
                countBomb(row,col-1);
            }
            else
            {
                i--;
            }
        }  
    }
    static void countBomb(int bomb_row,int bomb_col)
    {
            
            int row_st=(bomb_row-1<0)?bomb_row:bomb_row-1;
            int row_nd=(bomb_row+1==boardsize)?bomb_row:bomb_row+1;
            int col_st=(bomb_col-1<0)?bomb_col:bomb_col-1;
            int col_nd=(bomb_col+1==boardsize)?bomb_col:bomb_col+1;
            
            for(int j=row_st;j<=row_nd;j++)
            {
                for(int k=col_st;k<=col_nd;k++)
                {
                    if(dataArray[j][k] >='1')
                    {
                        if(dataArray[j][k]!='B')
                        {
                            dataArray[j][k]=(char)(dataArray[j][k]+1);
                        }
                    }
                    else
                    {
                        dataArray[j][k]='1';
                    }
                }
            }
        
    
    }
    static void flag(int row, int col) {
            if(
              dataArray[row][col]=='B')
              correct_result++; 
        if (row >= boardsize || col >= boardsize)
            System.out.println("INVALID INPUT");
        else {
            if (displayArray[row][col] == '?') {
                displayArray[row][col] = 'F';
                flag_count++;
                displayBoard();
            } 
            else if (displayArray[row][col] == 'F')
                System.out.println("Already flaged");
            else
                System.out.println("Can't perform"); // Already displayed value
            }
        
               if(correct_result==no_of_bomb)
                {
                    System.out.println("CONGRAGULATION YOU WON THE GAME");
                    System.exit(0);
                }
               if(flag_count>=no_of_bomb)
        {
            System.out.println("Some flags are not correct ...\n unflag and change the flag position");
        }
    }

    static void displayBoard() {

        for (int i = 0; i <boardsize; i++) {
           System.out.print("| ");
            for (int j = 0; j <boardsize; j++) {
                System.out.print(displayArray[i][j] + " |");
            }
            System.out.println();
        }

    }

    static void unflag(int row, int col) {
        if (displayArray[row][col] == 'F') {
            displayArray[row][col] = '?';
            flag_count--;
        } else {
            System.out.println("No flag to unflag");
        }
    }

   static boolean isBomb(int row, int col) {
        return (dataArray[row][col]=='B');
    }

    static void burstBomb() {
        int n = dataArray.length;
        int m = dataArray[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dataArray[i][j] == 'B' && displayArray[i][j] != 'F')
                    displayArray[i][j] = 'B';

                if (displayArray[i][j] == 'F' && dataArray[i][j] != 'B') {
                    displayArray[i][j] = 'X';
                }
            }
        }
    }

    static void revealArea(int row, int col,boolean[][]isVisited) {
        if (row == -1 || col == -1 || row ==boardsize || col == boardsize) {
            return;
        }
        if (!isVisited[row][col]) {
            if (dataArray[row][col] != 'B') {
                displayArray[row][col] = dataArray[row][col];
            }
            return;
        }
        isVisited[row][col] = false;
        displayArray[row][col] = dataArray[row][col];
        revealArea(row - 1, col,isVisited); // top
        revealArea(row, col - 1,isVisited); // left
        revealArea(row, col + 1,isVisited); // right
        revealArea(row + 1, col,isVisited); // bottom
        revealArea(row - 1, col - 1,isVisited); // vertical top Left
        revealArea(row - 1, col + 1,isVisited); // vertical top right
        revealArea(row + 1, col - 1,isVisited); // vertical bottom left
        revealArea(row + 1, col + 1,isVisited); // vertical bottom right
        isVisited[row][col] = true;
    }

    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
        System.out.println("Minesweeper");
        System.out.println("enter difficulty level:ex(easy,medium,hard)");
        String difficulty=scan.nextLine();
        difficultylevel(difficulty);
        boolean[][] isVisited=new boolean[boardsize][boardsize];
        for (int i = 0; i <boardsize; i++) {
            for (int j = 0; j <boardsize; j++) {
                isVisited[i][j]=(dataArray[i][j]==' ');
            }
            
        }
        int row, col;
        while (true) {
            System.out.println("Enter the row and column input seperate by space and process(ex: 1 1 M)");
            row = scan.nextInt();
            col = scan.nextInt();
            String function = scan.next();
            char func = function.charAt(0);
            switch (func) {
                case ('M'):
                    if (isBomb(row,col))//isBomb(row, col) 
                    {
                        burstBomb();
                        displayBoard();
                        System.out.println("Game Over");
                        return;
                    }
                    revealArea(row, col,isVisited);
                    displayBoard();
                    break;
                case ('F'):
                    flag(row, col);
                    break;
                case ('U'):
                    unflag(row, col);
                    displayBoard();
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
