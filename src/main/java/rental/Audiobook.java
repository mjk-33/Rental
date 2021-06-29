package rental;

public class Audiobook extends Item
{
    private int lenght;

    public Audiobook(int id, String title, String author, String publishingHouse, float price, int lenght)
    {
        super(id, title, author, publishingHouse, price);
        this.lenght = lenght;
    }
}
