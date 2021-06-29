package rental;

public class Movie extends Item
{
    private int lenght;

    public Movie(int id, String title, String author, String publishingHouse, float price, int lenght)
    {
        super(id, title, author, publishingHouse, price);
        this.lenght = lenght;
    }
}
