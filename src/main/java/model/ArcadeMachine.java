package model;

import utils.Utils;

import java.util.Arrays;

public class ArcadeMachine {
    private String name;
    private String genre;
    private int pricePerPlay;
    private boolean activated;
    private int timesPlayed;
    private int[] rankingPoints;
    private Player[] bestPlayers;

    public ArcadeMachine(String name, String genre, int pricePerPlay) {
        this.name = name;
        this.genre = genre;
        this.pricePerPlay = pricePerPlay;
        this.activated = true;
        this.timesPlayed = 0;
        this.rankingPoints = new int[]{0, 0, 0};
        this.bestPlayers = null;
    }

    public ArcadeMachine(){
        this.name = "Máquina desconocida";
        this.genre = "Género sin asignar";
        this.pricePerPlay = 0;
        this.activated = false;
        this.timesPlayed = 0;
        this.rankingPoints = new int[]{0, 0, 0};
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

    public int[] getRankingPoints() {
        return this.rankingPoints;
    }

    public Player[] getBestPlayers() {
        return this.bestPlayers;
    }

    //TEMPORAL BORRALO LUEGO BURRO!!!!!!
    public void setTimesPlayed(int timesPlayed){
        this.timesPlayed=timesPlayed;
    }

    /**
     * Función que modifica la activación de la máquina si ya estaba en el mismo estado seleccionado, lanza excepción.
     * @throws Exception Excepción lanzada en caso de que se seleccione la misma opción de estado de la máquina.
     */
    public void modifyActivationMachine(String activation) throws Exception {
        switch (activation.toLowerCase()) {
            case "off":
                if (this.activated) {
                    this.activated = false;
                } else {
                    throw new Exception("La máquina no puede desactivarse ya está desactivada.");
                }
                break;
            case "on":
                if (!this.activated) {
                    this.activated = true;
                } else {
                    throw new Exception("La máquina no puede activarse ya está activada.");
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "ArcadeMachine{" +
                "Nombre = " + name + "\n" +
                ", género = " + genre + '\'' +
                ", precio para jugar = " + pricePerPlay +
                ", está activa = " + activated +
                ", veces que se ha jugado = " + timesPlayed +
                ", mejores puntuaciones = " + Arrays.toString(rankingPoints) +
                ", mejores jugadores = " + Arrays.toString(bestPlayers) +".";
    }

    /**
     * Función para añadir 1 al número de veces que se ha jugado una máquina.
     * @throws Exception Lanza excepción si la máquina está apagada.
     */
    public void addPlay() throws Exception {
        if(this.activated) {
            this.timesPlayed++;
            if ((this.timesPlayed) % 100 == 0) {
                modifyActivationMachine("off");
            }
        }else{
            throw new Exception("No se puede añadir al número de veces jugadas estando apagada la máquina.");
        }
    }


    public void playMachine(){
        int score = Utils.genRandomNumber(9999);

    }
}
