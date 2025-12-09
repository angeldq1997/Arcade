package model;

public class Player {
    private String name;
    private String id;
    private int availableCredits;
    private int gamesPlayed;

    public Player(String name, String id, int availableCredits, int gamesPlayed) {
        this.name = name;
        this.id = id;
        this.availableCredits = availableCredits;
        this.gamesPlayed = gamesPlayed;
    }

    public Player() {
        this.name = "Unknown";
        this.id = "NONE";
        this.availableCredits = 0;
        this.gamesPlayed = 0;
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

    public int getAvailableCredits() {
        return availableCredits;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public String toString() {
        return "Jugador " +
                "nombre = " + this.name +
                ", ID = " + this.id +
                ", créditos disponibles = " + this.availableCredits +
                ", partidas jugadas = " + this.gamesPlayed;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if (this == obj) {
            isEquals = true;
            // la segunda parte se podría hacer también con getclass en vez de instanceof
        } else if (obj != null && obj instanceof Player) {
            Player anotherPlayer = (Player) obj;
            if (this.id.equals(anotherPlayer.getId())) {
                isEquals = true;
            }
        }
        return isEquals;
    }

    /**
     * Función para recargar créditos al jugador.
     */
    public void rechargeCredits(int creditsToRecharge) throws Exception {
        if(creditsToRecharge>0){
            this.availableCredits += creditsToRecharge;
        }else{
            throw new Exception("Error, no puedes recargar créditos negativos.");
        }
    }

    /**
     * Función para incrementar número de partidas jugadas.
     */
    public void incrementTimesArcadePlayed() {
        this.gamesPlayed++;
    }

    /**
     * Función que gasta créditos para jugar una partida.
     *
     * @param costArcadeMachine
     * @throws Exception
     */
    public boolean spendCredits(int costArcadeMachine) throws Exception {
        boolean canPay = false;
        if (this.availableCredits >= costArcadeMachine) {
            availableCredits -= costArcadeMachine;
            canPay = true;
        } else {
            throw new Exception("Error, no tiene suficientes créditos para jugar.");
        }
        return canPay;
    }
}