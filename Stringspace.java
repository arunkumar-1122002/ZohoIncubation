public class Stringspace {
    public static void main(String[] args) {
        String paragraph="sethu institute trecyhh sethu institute technology sethu institute of technology  sethu institute of technology sethu institute of technology sethu institute of technology";
        int lineLimit=28;
        int start=0,end=0;
        int paraLength=paragraph.length();
        for (int i = lineLimit; i < paraLength; i+=lineLimit) 
        {
            end = i;
             for (int j = i; j >start; j--) 
                {
                    if(paragraph.charAt(j)==' '){
                         end=j;
                         break;
                      }
                }
            printLine(paragraph,start,end, lineLimit);
            start=end+1;
            i=start;
        }
        System.out.println(paragraph.substring(start, paraLength));  
              
    }
    static void printLine(String currentLine,int start,int end,int target)
    {
        int length=end-start;
        int space=0,difference,addingDigits,lastSpace;
        for (int i =start ;i<end; i++) {
            if(currentLine.charAt(i)==' ')
            space++;
        }
        difference=target-length;
        addingDigits=difference/space;
        lastSpace=difference%space;
        String empty=spaceAdder(addingDigits);
        String answer="";
        for (int i = start; i < end; i++)
        {
            char temp=currentLine.charAt(i);
            if(temp==' '){
            space--;
            answer+=empty;
            if(lastSpace!=0){
            answer+=' ';
            lastSpace--;
            }
            }
            else
            answer+=temp;
        }
        System.out.println(answer);
    }
    static String spaceAdder(int num)
    {
        String emptys="_";
        for (int i = 0; i <num; i++) {
         emptys+="_";   
        }
        return emptys;
    }
    
}
