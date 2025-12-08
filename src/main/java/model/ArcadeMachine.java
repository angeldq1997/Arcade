package model;

import utils.Utils;

import java.util.Arrays;
import java.util.Objects;

public class ArcadeMachine {
    private String name;
    private String genre;
    private int pricePerPlay;
    private boolean activated;
    private int timesPlayed;
    private int[] rankingScore;
    private Player[] bestPlayers;

    public ArcadeMachine(String name, String genre, int pricePerPlay) {
        this.name = name;
        this.genre = genre;
        this.pricePerPlay = pricePerPlay;
        this.activated = true;
        this.timesPlayed = 0;
        this.rankingScore = new int[]{0, 0, 0};
        this.bestPlayers = new Player[3];
    }

    public ArcadeMachine(){
        this.name = "Máquina desconocida";
        this.genre = "Género sin asignar";
        this.pricePerPlay = 0;
        this.activated = false;
        this.timesPlayed = 0;
        this.rankingScore = new int[]{0, 0, 0};
        this.bestPlayers = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setPricePerPlay(int pricePerPlay) {
        this.pricePerPlay = pricePerPlay;
    }

    public int getPricePerPlay() {
        return this.pricePerPlay;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean IsActivated() {
        return activated;
    }

    public int getTimesPlayed() {
        return this.timesPlayed;
    }

    public int[] getRankingScore() {
        return this.rankingScore;
    }

    public Player[] getBestPlayers() {
        return this.bestPlayers;
    }

    //TEMPORAL BORRALO LUEGO BURRO!!!!!!
    public void setTimesPlayed(int timesPlayed){
        this.timesPlayed=timesPlayed;
    }
    //TEMPORAL BORRALO LUEGO BURRO!!!!!!
    public void setRankingScore(int[] rankingScore) {
        this.rankingScore = rankingScore;
    }

    /**
     * Función que modifica la activación de la máquina si ya estaba en el mismo estado seleccionado, lanza excepción.
     * @throws Exception Excepción lanzada en caso de que se seleccione la misma opción de estado de la máquina.
     */
    public void modifyActivationMachine(boolean state) throws Exception {
        if(state) {
            if (this.activated) {
                this.activated = false;
            } else {
                throw new Exception("La máquina no puede desactivarse ya está desactivada.");
            }
        }else{
            if (!this.activated) {
                    this.activated = true;
                } else {
                    throw new Exception("La máquina no puede activarse ya está activada.");
                }
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if(this==obj) {
            isEquals = true;
            // la segunda parte se podría hacer también con getclass en vez de instanceof
        }else if(obj!=null && obj instanceof ArcadeMachine){
            ArcadeMachine anotherMachine = (ArcadeMachine) obj;
            if(this.name.equals(anotherMachine.getName())){
                isEquals = true;
            }
        }
        return isEquals;
    }

    @Override
    public String toString() {
        return  name +
                ", género = " + genre +
                ", precio para jugar = " + pricePerPlay +
                ", está activa = " + activated +
                ", veces que se ha jugado = " + timesPlayed +
                ", mejores puntuaciones = " + Arrays.toString(rankingScore) +
                ", mejores jugadores = " + //todo añadir mejores +".";
    }

    /**
     * Función para añadir 1 al número de veces que se ha jugado una máquina.
     * @throws Exception Lanza excepción si la máquina está apagada.
     */
    public void addPlay() throws Exception {
        if(this.activated) {
            this.timesPlayed++;
            if ((this.timesPlayed) % 100 == 0) {
                modifyActivationMachine(false);
            }
        }else{
            throw new Exception("No se puede añadir al número de veces jugadas estando apagada la máquina.");
        }
    }

    public boolean storeScore(Player challenger, int score){
        boolean foundScore = false;
        Player temporalPlayer = new Player();
        int temporalScore = 0;
        for (int i = 0; i < this.rankingScore.length; i++) {
            if (!foundScore && score > rankingScore[0]) {
                score = rankingScore[0];
                foundScore = true;

            } else if (!foundScore && score > rankingScore[i]) {
                temporalScore = rankingScore[i];
                temporalPlayer = this.bestPlayers[i];
                score = rankingScore[i];
                this.bestPlayers[i] = challenger;
                foundScore = true;
            }
        }
        return foundScore;
    }

    public void showBestPlayers(){
        for (int i = 0; i < this.bestPlayers.length; i++) {
            this.bestPlayers[i].getName();
        }
    }

    public void playMachine(){
        final int MAXSCORE = 9999;
        int score = Utils.genRandomNumber(MAXSCORE);
        try{
            this.addPlay();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}