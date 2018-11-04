package JAXB;

public class GameStorage {

    private Games games;

    public Games getGames ()
    {
        return games;
    }

    public void setGames (Games games)
    {
        this.games = games;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [games = "+games+"]";
    }

}
