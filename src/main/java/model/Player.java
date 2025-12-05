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
        this.id = "No ID";
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
        return "Jugador " +
                "nombre = " + this.name +
                ", ID = " + this.id +
                ", créditos disponibles = " + this.disponibleCredits +
                ", partidas jugadas = " + this.playedGames;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if(this==obj) {
            isEquals = true;
            // la segunda parte se podría hacer también con getclass en vez de instanceof
        }else if(obj!=null && obj instanceof Player){
            Player anotherPlayer = (Player) obj;
            if(this.id.equals(anotherPlayer.getId())){
                isEquals = true;
            }
        }
        return isEquals;
    }

    /**
     * Función para recargar créditos al jugador.
     */
    public void rechargeCredits(int creditsToRecharge){
        this.disponibleCredits+=creditsToRecharge;
    }

    /**
     * Función para incrementar número de partidas jugadas.
     */
    public void incrementTimesArcadePlayed(){
        this.playedGames++;
    }

    /**
     * Función que gasta créditos para jugar una partida
     * @param costArcadeMachine
     * @throws Exception
     */
    public boolean spendCredits(int costArcadeMachine) throws Exception {
        boolean canPay = false;
        if(this.disponibleCredits>=costArcadeMachine){
            disponibleCredits-=costArcadeMachine;
            canPay = true;
        }else{
            throw new Exception("No tiene suficientes créditos para jugar.");
        }
        return canPay;
    }
}