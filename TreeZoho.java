import java.util.Scanner;

public class TreeZoho {
    public static void main(String[] args) throws Exception 
    {
        Scanner scan=new Scanner(System.in);
        String firstInput=scan.next();
        int length=firstInput.length();
        Node root=createNode(firstInput.charAt(0));
        if(length>1)
        root.left=createNode(firstInput.charAt(1));
        if(length>2)
        root.right=createNode(firstInput.charAt(2));
        System.out.println();
        printElement(root);
        while(true)
        {
        String input=scan.next();
        if(input.equals("end"))
        break;
        length=input.length();
        Node current=searchElement(input.charAt(0),root);
        if(length>1)
        current.left=createNode(input.charAt(1));
        if(length>2)
        current.right=createNode(input.charAt(2));
       // printElement(root);
        System.out.println();
        }
        System.out.println("Print by level order");
        printLikeTree(root);
    }
    static void printLikeTree(Node root)
    {
        if(root==null)
        return;
        int height=height(root);
        for (int i = 1; i <=height; i++) 
        {
            for (int j = 0; j<height-i; j++) 
            {
                System.out.print("  ");
            }
             printCurrentLevel(root,i,1);   
             System.out.println();
        }
    }
    static void printCurrentLevel(Node root,int targetlevel,int currentlevel)
    {
        if(root==null)
        return ;
        if(currentlevel==targetlevel)
        System.out.print(root.data+"  ");
        printCurrentLevel(root.left,targetlevel,currentlevel+1);
        printCurrentLevel(root.right,targetlevel, currentlevel+1);

    }
    static int height(Node root)
    {
        if(root==null)
        return 0;
        int left=height(root.left);
        int right=height(root.right);
        if(left>right)
        return left+1;
        else
        return right+1;
    }
    static Node createNode(char ch)
    {
        Node node=new Node(ch);
        return node;
    }
    static void printElement(Node currnet)
    {
        if(currnet==null)
        return ;
        System.out.print(currnet.data+"   ");
        printElement(currnet.left);
        printElement(currnet.right);
    }
    static Node searchElement(char ch,Node currnet)
    {
        if(currnet==null)
        return null;
        if(currnet.data==ch)
        return currnet;

        Node left= searchElement(ch,currnet.left);
        Node right=searchElement(ch,currnet.right);

        if(left==null)
        return right;
        else
        return left;
    }
}
