import java.util.ArrayList;
import java.util.Scanner;

class Student
{
    private String name;
    private int id=0;
    private int[] marks=new int[6];
    private float cutOff;
    private int total;
    Student(){};
    Student(String name,int id,int[] marks)
    {
        this.name=name;
        this.id=id;
        this.marks=marks;
        this.cutOff=cutOff();
        this.total=total();
    }
    public float cutOff()
    {
        float cutoff=((float)marks[3]/2.0f+(float)marks[4]/2.0f);
       cutoff+=(float)marks[2];
       return cutoff;
    }
    public int total()
    {
        int total=0;
        for (int i = 0; i < 6; i++)
            total+=marks[i];
        return total;
    }
    public String getName()
    {
        System.out.print("id: "+id+" Name: ");
        return name;
    }
    public boolean isgreaterThan(Student s)
    {
        if(this.cutOff<s.cutOff)
        return true;
        else if(this.total<s.total)
        return true;
        else if(this.marks[2]<s.marks[2])
        return true;
        else if(this.marks[3]<s.marks[3])
        return true;
        else if(this.marks[4]<s.marks[4])
        return true;
        else
        return false;
    }
}

public class StudentRecord {

    static Student studentdetails(int studentid)
    {
        
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter name:");
        String name=inp.nextLine();
        System.out.println("Enter Marks :\nTamil\nEnglish\nMaths\nPhysics\nChemistry\nBiology/ComputerScience \n(*Enter marks in this order*)");
        int marks[]=new int[6];
            for (int i = 0; i < 6; i++) 
                marks[i]=inp.nextInt();
        return new Student(name,studentid,marks);
    }
    static  void printResult(ArrayList<Student> stud)
    {
        int size=stud.size();
        for (int i = 0; i < size; i++)
         for (int j = i; j < size-i-1; j++)
         if(stud.get(j).isgreaterThan(stud.get(j+1)))
            stud=swap(stud, j, j+1);

        for (int i = 0; i <size; i++) {
            System.out.println(stud.get(i).getName());
        }
    }
    static ArrayList<Student> swap(ArrayList<Student> stud,int s1,int s2)
    {
        Student temp=stud.get(s1);
            stud.set(s1, (stud.get(s2)));
            stud.set(s2,temp);
        return stud;
    }
    public static void main(String[] args)
    {
        int studentid=0;
        Scanner inp=new Scanner(System.in);
        ArrayList<Student> result=new ArrayList<>();
        while (true)
        {
            System.out.println("1.Add data\n2.Results\n3.End the program");
            int option=inp.nextInt();
            switch(option)
            {
            case 1:
            result.add(studentdetails(studentid));
            studentid++;
            break;
            case 2:
            printResult(result);
            break;
            case 3:
            System.exit(0);
            break;
            default:
            System.out.println("select correct option");
            break;
            }
        }
    }
}
