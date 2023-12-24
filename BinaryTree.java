class BinaryTree
{
    Node root;
    static int noOfelemnts=0;
    public Node addRoot(int value)
    {
        Node node=new Node(value);
        root=node;
        noOfelemnts++;
        return node;
    }
    public static Node createNode(int value)
    {
        Node node=new Node(value);
        noOfelemnts++;
        return node;
    }
    public Node getRoot()
    {
        return root;
    }
    public int size()
    {
        return noOfelemnts;
    }
    public Node searchElement(char ch,Node currnet)
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
    public void printLikeTree(Node node)
    {
        if(node==null)
        return;
        int height=height(root);
        for (int i = 1; i <=height; i++) 
        {
            for (int j = 0; j<height-i; j++) 
            {
                System.out.print("  ");
            }
             printCurrentLevel(node,i,1);   
             System.out.println();
        }
    }
    public void printInorder(Node currnet)
    {
        if(currnet==null)
        return ;
        printInorder(currnet.left);
        System.out.print(currnet.data+"   ");
        printInorder(currnet.right);
    }
    public void printPreorder(Node currnet)
    {
        if(currnet==null)
        return ;
        System.out.print(currnet.data+"   ");
        printInorder(currnet.left);
        printInorder(currnet.right);
    }
    public void printPostorder(Node currnet)
    {
        if(currnet==null)
        return ;
        printInorder(currnet.left);
        printInorder(currnet.right);
        System.out.print(currnet.data+"   ");
    }

    public int height(Node node)
    {
        if(node==null)
        return 0;
        int left=height(node.left);
        int right=height(node.right);
        if(left>right)
        return left+1;
        else
        return right+1;
    }
    public void printCurrentLevel(Node node,int targetlevel,int currentlevel)
    {
        if(node==null)
        return ;
        if(currentlevel==targetlevel)
        System.out.print(node.data+"  ");
        printCurrentLevel(node.left,targetlevel,currentlevel+1);
        printCurrentLevel(node.right,targetlevel, currentlevel+1);

    }
}
