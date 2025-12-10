package model;

import utils.Utils;

import java.util.Arrays;

public class ArcadeMachine {
    private String name;
    private String genre;
    private int pricePerPlay;
    private boolean activated;
    private int timesPlayed;
    private int[] rankingScore;
    private Player[] bestPlayers;
    private int releasedYear;
    private String developer;

    public ArcadeMachine(String name, String genre, int pricePerPlay, int releasedYear, String developer) {
        this.name = name;
        this.genre = genre;
        this.pricePerPlay = pricePerPlay;
        this.activated = true;
        this.timesPlayed = 0;
        this.rankingScore = new int[]{0, 0, 0};
        this.bestPlayers = null;
        this.releasedYear = releasedYear;
         this.developer = developer;
    }

    public ArcadeMachine(String name, String genre, int pricePerPlay, boolean activated, int timesPlayed, int[] rankingScore, Player[] bestPlayers, int releasedYear, String developer) {
        this.name = name;
        this.genre = genre;
        this.pricePerPlay = pricePerPlay;
        this.activated = true;
        this.timesPlayed = 0;
        this.rankingScore = new int[]{0, 0, 0};
        this.bestPlayers = null;
        this.releasedYear = releasedYear;
        this.developer = developer;
    }

    public ArcadeMachine() {
        this.name = "Máquina desconocida";
        this.genre = "Género sin asignar";
        this.pricePerPlay = 0;
        this.activated = false;
        this.timesPlayed = 0;
        this.rankingScore = new int[]{0, 0, 0};
        this.bestPlayers = null;
        this.releasedYear = 1970;
        this.developer = "Unknown developer";
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

    public boolean isActivated() {
        return this.activated;
    }

    public int getTimesPlayed() {
        return this.timesPlayed;
    }

    public int[] getRankingScore() {
        return this.rankingScore;
    }

    public String getBestPlayers() {
        String bestPlayerList = null;
        for (int i = 0; i < this.bestPlayers.length; i++) {
            bestPlayerList += (this.bestPlayers[i].getName() + ", ");
        }
        return bestPlayerList;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    //TODO: TEMPORAL BORRALO LUEGO BURRO!!!!!!
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if (this == obj) {
            isEquals = true;
            // la segunda parte se podría hacer también con getclass en vez de instanceof
        } else if (obj != null && obj instanceof ArcadeMachine) {
            ArcadeMachine anotherMachine = (ArcadeMachine) obj;
            if (this.name.equals(anotherMachine.getName())) {
                isEquals = true;
            }
        }
        return isEquals;
    }

    @Override
    public String toString() {
        return "Máquina arcade" +
                "Nombre = " + this.name +
                ", género = " + this.genre +
                ", precio para jugar = " + this.pricePerPlay +
                ", está activa = " + this.activated +
                ", veces que se ha jugado = " + this.timesPlayed +
                ", mejores puntuaciones = " + Arrays.toString(this.rankingScore) +
                ", mejores jugadores = " + this.getBestPlayers() +
                ", año de lanzamiento = " + this.releasedYear +
                "y desarrollador/a = " + this.developer + ".";
    }

    /**
     * Función que modifica la activación de la máquina si ya estaba en el mismo estado seleccionado, lanza excepción.
     * @throws Exception Excepción lanzada en caso de que se seleccione la misma opción de estado de la máquina.
     */
    public void modifyActivationMachine(boolean state) throws Exception {
        if (state) {
            if (!this.activated) {
                this.activated = true;
            } else {
                throw new Exception("Error, la máquina no puede desactivarse ya está desactivada.");
            }
        } else {
            if (this.activated) {
                this.activated = false;
            } else {
                throw new Exception("Error, la máquina no puede activarse ya está activada.");
            }
        }
    }

    /**
     * Función para añadir 1 al número de veces que se ha jugado una máquina.
     * @throws Exception Lanza excepción si la máquina está apagada.
     */
    public void addPlayTimeToMachine() throws Exception {
        if (this.activated) {
            this.timesPlayed++;
            if ((this.timesPlayed) % 100 == 0) {
                modifyActivationMachine(false);
            }
        } else {
            throw new Exception("Error, no se puede añadir al número de veces jugadas estando apagada la máquina.");
        }
    }

    /**
     * Función para guardar puntuaciones del jugador en un array colocando correctamente dependiendo de la conseguida.
     * @param challenger Jugador que obtiene una puntuación concreta a comparar con las almacenadas.
     * @param score Puntuación obtenida por el jugador indicado tras haber jugado una partida.
     * @return Devuelve true si se ha almacenado correctamente y false si no se ha podido.
     */
    public boolean storeScore(Player challenger, int score) {
        boolean foundScore = false;
        //TODO: Añadir para array mayor de 3: Player aux = new Player();
        for (int i = 0; i < 3; i++) {
            if (!foundScore && score > rankingScore[0]) {
                score = rankingScore[0];
                foundScore = true;

            } else if (!foundScore && score > rankingScore[1]) {
                rankingScore[1] = rankingScore[2];
                this.bestPlayers[1] = this.bestPlayers[2];
                score = rankingScore[1];
                this.bestPlayers[1] = challenger;
                foundScore = true;

            } else if (!foundScore && score > rankingScore[2]) {
                score = rankingScore[2];
                foundScore = true;
            }
        }
        return foundScore;
    }
}