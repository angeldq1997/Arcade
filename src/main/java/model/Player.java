package model;

public class Player {
    private String name;
    private String id;
    private int disponibleCredits;
    private int playedGames;

    public Player(String name, String id, int disponibleCredits, int playedGames){
        this.name = name;
        this.id = id;
        this.disponibleCredits = disponibleCredits;
        this.playedGames = playedGames;
    }

    public Player(){
        this.name = "Unknown";
        this.id = "000";
        this.disponibleCredits = 0;
        this.playedGames = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDisponibleCredits() {
        return disponibleCredits;
    }

    public void setDisponibleCredits(int disponibleCredits) {
        this.disponibleCredits = disponibleCredits;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    @Override
    public String toString() {
        return "";
    }
}
