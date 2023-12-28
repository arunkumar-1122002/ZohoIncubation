import java.util.ArrayList;
import java.util.Scanner;

public class Management
{
    //ArrayList<Book> available=new ArrayList<>();
    ArrayList<Customer> customers=new ArrayList<>();
    ArrayList<Book> totalBooks=new ArrayList<>();
    ArrayList<History> histories=new ArrayList<>();
    static int newCustomerId=100;
    public void printAvailableBooks()
    {
        System.out.println("S.no     Bookid          BookTitle       Availability");
        int i=1;
        for(Book book:totalBooks)
        {
            if(book.available)
            {
            System.out.println(i+"   "+book.bookId+"    "+book.bookTitle+"    "+book.available);
            i++;
            }
        }
    }
    public void newBorrow()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your name:");
        String name=input.nextLine();
        newCustomerId+=1;
        System.out.println("\nYour user id is: "+newCustomerId+"\nGentle Remember:Dont forgot the user id!!!!");
        customers.add(new Customer(newCustomerId,name));
        Borrow();
        input.close();
    }
    public void Borrow()
    {
        Scanner input=new Scanner(System.in);
        int count=0;
        // if(available.isEmpty())
        // {
        //     System.out.println("Currently no books available");
        //     return ;
        // }
        for(Book book:totalBooks)
        {
            if(book.available==true)
            count++;
        }
        if(count==0)
        {
            System.out.println("Currently no books available");
            return;
        }
        System.out.println("Enter your id");
        int customerid=input.nextInt();
        System.out.println("Enter today date(dd-mm-year):");
        String date=input.next();
        System.out.println("Available Books:");
        printAvailableBooks();
        System.out.println("Enter the book id to borrow");
        int borrowedBookId=input.nextInt();
        Book bookBorrowed=null;
        for(Book book:totalBooks)
        {
            if(book.bookId==borrowedBookId)
            {
                bookBorrowed=book;
                book.available=false;
                break;
            }
        }
        for(Customer customer:customers)
        {
            if(customer.customerId==customerid)
            {
            customer.addMoreBooks(bookBorrowed);
            histories.add(new History(customerid, customer.getName(), bookBorrowed.bookId, bookBorrowed.bookTitle, date));
            break;
            }
        } 
        input.close();
        }
    public void returnBooks()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter today date:");
        String date=input.nextLine();
        System.out.println("Enter Customer id:");
        int cReturnId=input.nextInt();
        System.out.println("Enter book id you want return:");
        int bookid=input.nextInt();
        Book bookReturned=new Book();
        for(Book book:totalBooks)
        {
            if(book.bookId==bookid)
            {
            //available.add(book);
            book.available=true;
            bookReturned=book;
            break;
            }
        }
        for(Customer customer:customers)
        {
            if(customer.customerId==cReturnId)
            {
            customer.removeReturnedBook(bookReturned);
            break;
            }
        }
        for(History history:histories)
        {
            if(history.getId()==cReturnId && history.getBookId()==bookid)
            {
                history.setReturndate(date);
                break;
            }
        }
        input.close();
   }
    public void customerDetails()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter customer id :");
        int customerId=input.nextInt();
        for(Customer customer:customers)
        {
            if(customer.customerId==customerId)
            {
                customer.printCustomerDetails();
                break;
            }
        }
        input.close();
    }
    public void bookDetails()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Book id :");
        int bookId=input.nextInt();
        for(Book book:totalBooks)
        {
            if(book.bookId==bookId)
            {
                book.printBookDetails();
                break;
            }
        }
        input.close();
    }
    public void printHistory()
    {
        System.out.println("CustomerId     customerName     bookId     bookName     borrowDate      returnDate");
        for(History history:histories)
        {
            history.Print();
        }
    }
    void addBooks()//in default i am setting 5 books in library
    {
        Book bk1=new Book(1001,"java    ","james gosling",1995);
       // available.add(bk1);
        totalBooks.add(bk1);
        Book bk2=new Book(1002,"c        ","dennis ritche",1970);
        //available.add(bk2);
        totalBooks.add(bk2);
        Book bk3=new Book(1003,"python    "," Van Rossum",1991);
        //available.add(bk3);
        totalBooks.add(bk3);
        Book bk4=new Book(1004,"Html     ","Tim berners lee",1999);
        //available.add(bk4);
        totalBooks.add(bk4);
        Book bk5=new Book(1005,"c++    ","stroustrup",1983);
       // available.add(bk5);
        totalBooks.add(bk5);
    }
}