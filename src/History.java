public class History {
    private int customerId;
    private String customerName;
    private int Bookid;
    private String BookName;
    private String BorrowDate;
    private String returnDate="------";
    History(int custId,String custname,int Bkid,String BkName,String Borrowdate)
    {
        this.customerId=custId;
        this.customerName=custname;
        this.Bookid=Bkid;
        this.BookName=BkName;
        this.BorrowDate=Borrowdate;
    }
    void Print()
    {
        System.out.println(customerId+"     "+customerName+"           "+Bookid+"         "+BookName+"      "+BorrowDate+"     "+returnDate);
    }
    int getId()
    {
        return customerId;
    }
    int getBookId()
    {
        return Bookid;
    }
    void setReturndate(String Returndate)
    {
        this.returnDate=Returndate;
    }
}
