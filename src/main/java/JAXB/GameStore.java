package JAXB;

public class GameStore {

    private Game[] game;

    public Game[] getGame ()
    {
        return game;
    }

    public void setGame (Game[] game)
    {
        this.game = game;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [game = "+game+"]";
    }

}
