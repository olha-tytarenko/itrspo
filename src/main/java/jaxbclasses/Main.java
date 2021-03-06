package jaxbclasses;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        GameType movieType = new GameType();
        movieType.setTitle("Assassin's Creed Odyssey");
        movieType.setStudio("Ubisoft");
        movieType.setYear("2018-10-05");
        movieType.setGenre("Action, RPG");
        movieType.setLanguage("Anvil engine");
        movieType.setPrice(BigDecimal.valueOf(23.45));
        movieType.setQuantity(1234);
        GameType.Rating rating = new GameType.Rating();
        rating.getAwesome();
        movieType.setRating(rating);
        GameType.Producer producer = new GameType.Producer();
        producer.setFirstname("Some");
        producer.setLastname("ONE");
        movieType.setProducer(producer);

        System.out.println("Title : " + movieType.getTitle() + "\n" +
                "Studio : " + movieType.getStudio() + "\n" +
                "Outcome date : " + movieType.getYear() + "\n" +
                "Genre : " + movieType.getGenre() + "\n" +
                "Language : " + movieType.getLanguage() + "\n" +
                "Price : " + movieType.getPrice() + "\n" +
                "Quantity : " + movieType.getQuantity() + "\n" +
                "Producer : " + movieType.getProducer().getFirstname() + " " + movieType.getProducer().getLastname() + "\n" +
                "Rating : " + movieType.getRating().getAwesome());
    }
}
