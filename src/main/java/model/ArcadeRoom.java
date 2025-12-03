package model;

public class ArcadeRoom {
    Player[] players;
    ArcadeMachine[] arcadeMachines;

    //Contructor básico
    public ArcadeRoom(Player[] players, ArcadeMachine[] arcadeMachines){
        this.players = players;
        this.arcadeMachines = arcadeMachines;
    }

    /**
     * Función para encontrar un jugador concreto en el array de jugadores
     * @param playerToFind Jugador a buscar.
     * @return True si ha encontrado al jugador con la misma ID y false si no lo encuentra.
     */
    private boolean findPlayer(Player playerToFind){
        boolean foundPlayer = false;
        for (int i = 0; i < this.players.length; i++) {
            if(this.players[i].equals(playerToFind)){
                foundPlayer=true;
            }
        }
        return foundPlayer;
    }
}
