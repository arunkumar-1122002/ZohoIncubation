public class Minimumadd {
    public static void main(String[] args)
    {
        int arr[]={9,4,7,1,8,2,6};
        BinaryTree tree=new BinaryTree();
        int min=minimum(0, arr.length-1, arr);
        Node root=tree.addRoot(arr[min]);
        addElement(0, arr.length-1, root, min, arr);
        System.out.println();
        tree.printLikeTree(root);
        tree.printInorder(root);
        System.out.println();
        // tree.printPreorder(root);
        // System.out.println();
        // tree.printPostorder(root);
        // System.out.println();
       System.out.println("Number of elements: "+tree.size());
    } 
    static void addElement(int start,int end,Node node,int min,int[] arr)
    {
        if(start>end)
        return;
        int minLeft=minimum(start,min-1,arr);
        int minRight=minimum(min+1, end, arr);
        if(minLeft!=-1)
        {
        node.left=BinaryTree.createNode(arr[minLeft]);
        addElement(start, min-1, node.left,minLeft, arr);
        }
        if(minRight!=-1)
        {
        node.right=BinaryTree.createNode(arr[minRight]);
        addElement(min+1, end, node.right,minRight, arr);
        }
    }
    static int minimum(int start,int end,int[] arr)
    {
        if(start>end)
        return -1;
        int min=start;
        if(start!=end)
        {
            for (int i = start; i <=end; i++) {
                    if(arr[i]<arr[min])
                    min=i;
            }
        }
        return min;
    }
}
