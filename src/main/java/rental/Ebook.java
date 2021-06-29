package rental;

public class Ebook extends Item
{
    private int pages;

    public Ebook(int id, String title, String author, String publishingHouse, float price, int pages)
    {
        super(id, title, author, publishingHouse, price);
        this.pages = pages;
    }
}
