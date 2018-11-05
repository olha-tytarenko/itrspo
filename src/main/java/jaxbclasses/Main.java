package jaxbclasses;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        GameType gameType = new GameType();
        gameType.setTitle("Assassin's Creed Odyssey");
        gameType.setStudio("Ubisoft");
        gameType.setYear("2018-10-05");
        gameType.setGenre("Action, RPG");
        gameType.setPlatform("PlayStation 4, Xbox One, Nintendo Switch, Microsoft Windows");
        gameType.setSeries("Assassin’s Creed");
        gameType.setEngine("Anvil engine");
        gameType.setPrice(BigDecimal.valueOf(23.45));
        gameType.setQuantity(1234);
        gameType.setPromocode("str12340");
        GameType.Rating rating = new GameType.Rating();
        rating.getAwesome();
        gameType.setRating(rating);
        GameType.Producer producer = new GameType.Producer();
        producer.setFirstname("Some");
        producer.setLastname("ONE");
        gameType.setProducer(producer);

        System.out.println("Title : " + gameType.getTitle() + "\n" +
                "Studio : " + gameType.getStudio() + "\n" +
                "Outcome date : " + gameType.getYear() + "\n" +
                "Genre : " + gameType.getGenre() + "\n" +
                "Platform : " + gameType.getPlatform() + "\n" +
                "Series : " + gameType.getSeries() + "\n" +
                "Engine : " + gameType.getEngine() + "\n" +
                "Price : " + gameType.getPrice() + "\n" +
                "Quantity : " + gameType.getQuantity() + "\n" +
                "Producer : " + gameType.getProducer().getFirstname() + " " + gameType.getProducer().getLastname() + "\n" +
                "Rating : " + gameType.getRating().getAwesome());
    }
}
