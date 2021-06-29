package rental;

public class CD extends Item
{
    private int tracks;

    public CD(int id, String title, String author, String publishingHouse, float price, int tracks)
    {
        super(id, title, author, publishingHouse, price);
        this.tracks = tracks;
    }
}
