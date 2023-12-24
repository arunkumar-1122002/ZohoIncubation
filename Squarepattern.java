public class Squarepattern 
{
    public static void main(String[] args) {
        int n=4;
        int limit=(n*2)-1;
        for (int row= 1; row <=limit; row++)
         {
            for(int col=1;col<=limit;col++)
            {
                int left=col-1;
                int right=limit-col;
                int top=row-1;
                int bottom=limit-row;
                int value=min(min(left,right),min(top,bottom));
                System.out.print(n-value+" ");
            }
            System.out.println();
        }
    }
    static int min(int val1,int val2)
    {
        return val1<val2?val1:val2;
    }
}
