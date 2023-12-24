public class Balanceparanthesis {
    public static void main(String[] args) 
    {
        int n=4;
        balance("", n-1, n-1);
    }
    public static void balance(String str,int left,int right)
    {
        if(left==0 && right==0)
        {
            System.out.println("("+str+")");
        return ;
        }
        if(left>right) return;
        if(left>0) balance(str+"(", left-1, right);
        if(right>0) balance(str+")", left, right-1);
}
}
