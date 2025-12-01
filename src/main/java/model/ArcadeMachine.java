package model;

public class ArcadeMachine {
    String name;
    String genre;
    int pricePerPlay;
    boolean activated;
    int timesPlayed;
    int[] rankingPoints;
    Player[] bestPlayers;

    public void activateMachine(){
        if(!this.activated){
            this.activated=true;
        }else{
            this.activated=false;
        }
    }


}
