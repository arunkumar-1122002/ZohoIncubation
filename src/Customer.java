import java.util.ArrayList;

public class Customer {
    int customerId;
    private String Name;
    private ArrayList<Book> holdingBooks=new ArrayList<>();
    Customer(){};
    Customer(int id,String name)
    { 
        customerId=id;
        Name=name;
       // holdingBooks.add(book);
    }
    void customerAddBook(Book book)
    {
        holdingBooks.add(book);
    }
    void printCustomerDetails()
    {
        System.out.println("Customer id : "+customerId+"\nName : "+Name);
        System.out.println("Customer Borrowed Books:");
        for(Book book:holdingBooks)
        System.out.print(book.bookTitle);
        
    }
    void removeReturnedBook(Book book)
    {
        holdingBooks.remove(book);
    }
    void addMoreBooks(Book book)
    {
        holdingBooks.add(book);
    }
    String getName()
    {
        return Name;
    }
}
