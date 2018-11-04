package JAXB;

public class Games {

    private GameStore gameStore;

    public GameStore getGameStore ()
    {
        return gameStore;
    }

    public void setGameStore (GameStore gameStore)
    {
        this.gameStore = gameStore;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [gameStore = "+gameStore+"]";
    }

}
