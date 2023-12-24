import java.util.Arrays;

class Oddevenshorting
{
    public static void main(String[] args) {
        int[] arr={2,11,5,7,8,4};
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(isodd(arr[i]) && isodd(arr[j]))
                {
                    if(arr[i]>arr[j])
                    {
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
                else if(iseven(arr[i]) && isodd(arr[j]))
                {
                      int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;  
                }
                else if(iseven(arr[i])&& iseven(arr[j]))
                {
                    if(arr[j]<arr[i])
                    {
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp; 
                    }

                }
            }
            
        }
        System.out.println(Arrays.toString(arr));
    }
    static boolean isodd(int num)
    {
        return num%2==1;
    }
    static boolean iseven(int num)
    {
        return num%2==0;
    }
}
