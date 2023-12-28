public class Book 
{
 int bookId;
 String bookTitle;   
 private String Author;
 private int publishedYear;
 boolean available;
 Book(){}
 Book(int id,String title,String author,int year)
 {
      this.bookId=id;
      this.bookTitle=title;
      this.Author=author;
      this.publishedYear=year;
      this.available=true;
 }
 public void printBookDetails()
 {
    System.out.println("Book id: "+bookId+"\nBook Title: "+bookTitle+"\nAuthor: "+Author+"\nPublished year: "+publishedYear);
 }
}
