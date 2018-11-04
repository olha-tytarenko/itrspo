package JAXB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Game {

    private int id;

    private String studio;

    private String genre;

    private String platform;

    private String series;

    private String title;

    private double price;

    private String engine;

    private Date year;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getStudio ()
    {
        return studio;
    }

    public void setStudio (String studio)
    {
        this.studio = studio;
    }

    public String getGenre ()
    {
        return genre;
    }

    public void setGenre (String genre)
    {
        this.genre = genre;
    }

    public String getPlatform ()
    {
        return platform;
    }

    public void setPlatform (String platform)
    {
        this.platform = platform;
    }

    public String getSeries ()
    {
        return series;
    }

    public void setSeries (String series)
    {
        this.series = series;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public double getPrice ()
    {
        return price;
    }

    public void setPrice (double price)
    {
        this.price = price;
    }

    public String getEngine ()
    {
        return engine;
    }

    public void setEngine (String engine)
    {
        this.engine = engine;
    }

    public Date getYear ()
    {
        return year;
    }

    public void setYear (String year) throws ParseException {
        Date date = new SimpleDateFormat("MM dd yyyy").parse(year);
        this.year = date;
    }

    @Override
    public String toString()
    {
        return "id = "+id+ "\n" +"studio = "+studio+ "\n" +
                "genre = "+genre+ "\n" +"platform = "+platform+ "\n" +
                "series = "+series+ "\n" +"title = "+title+ "\n" +
                "price = "+price+ "\n" +"engine = "+engine+ "\n" +"year = "+year+ "\n";
    }

}
