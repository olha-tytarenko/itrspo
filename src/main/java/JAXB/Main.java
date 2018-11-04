package JAXB;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        Game game = new Game();
        game.setId(7);
        game.setTitle("Some game");
        game.setStudio("Some studio");
        game.setGenre("SomeGenre");
        game.setPlatform("Some platform");
        game.setSeries("Some series");
        game.setEngine("Some Engine");
        game.setPrice(99.99);
        game.setYear("12 31 2009");

        System.out.println(game.toString());
    }

}
