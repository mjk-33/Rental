package rental;

import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Item
{
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private float price;
    private LocalDate rentDate;
    private int whoRented;


    public Item(int id, String title, String author, String publishingHouse, float price)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.price = price;
        this.rentDate = null;
        this.whoRented = -1;
    }

    public int getId()
    {
        return id;
    }
    void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle()
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setAuthor()
    {
        this.author = author;
    }

    public String getPublishingHouse()
    {
        return publishingHouse;
    }
    public void setPublishingHouse()
    {
        this.publishingHouse = publishingHouse;
    }

    public float getPrice()
    {
        return price;
    }
    public void setPrice()
    {
        this.price = price;
    }

    public int getWhoRented()
    {
        return whoRented;
    }

    public LocalDate getRentDate() {
        return this.rentDate;
    }

    public String getRentDate(String format)
    {
        return this.rentDate.format(DateTimeFormatter.ofPattern(format));
    }

    public void setRentDateDate(String date)
    {
        this.rentDate = LocalDate.parse(date);
    }

    public void borrow(int userId, String borrowTo)
    {
        this.whoRented = userId;
        this.rentDate = LocalDate.parse(borrowTo, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public float getPenalty()
    {
        if (this.rentDate == null)
        {
            return 0.0f;
        }
        Period period = Period.between(this.rentDate, LocalDate.now());
        return period.getDays() * 5.00f;
    }


}
