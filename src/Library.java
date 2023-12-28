import java.util.Scanner;
public class Library {
    public static void main(String[] args) throws Exception 
    {
        Scanner inp=new Scanner(System.in);
        Management manage=new Management();
        manage.addBooks();
        System.out.println("Welcome to ZOHO book management System");
        while(true)
        {
            
            System.out.println("1.Available books\n2.Borrow\n3.Return\n4.Get Book details\n5.Get Cutomer  details \n6.History \n7.End process");
          int option=inp.nextInt();
          System.out.println("\n\n\n\n\n\n\n\n\n\n");
          switch (option) {
            case 1:  
              manage.printAvailableBooks();
              break;
            case 2:
            System.out.println("Are you new to the library (\n1.YES\n2.NO)");
            int yes=inp.nextInt();
            if(yes==1)
              manage.newBorrow();
            else if(option==2)
              manage.Borrow();
              break;
            case 3:
              manage.returnBooks();
              break;
            case 4:
              manage.bookDetails();
              break;
            case 5:
              manage.customerDetails();
              break;
            case 6:
              manage.printHistory();
              break;
            case 7:
              System.out.println("Thank you for using our services");
              System.exit(0);
            default:
              System.out.println("Select correct option:");
              break;
          }
        }
    }
}
