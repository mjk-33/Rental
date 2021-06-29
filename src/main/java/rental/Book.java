package rental;

public class Book extends Item
{
    private int pages;

    public Book(int id, String title, String author, String publishingHouse, float price, int pages)
    {
        super(id, title, author, publishingHouse, price);
        this.pages = pages;
    }
}
