package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcadeRoomTest {

    static ArcadeRoom arcadeRoomTest = new ArcadeRoom();

    @BeforeAll
    public static void setUpClass(){
        int[] ranking = new int[]{200, 100, 0};
        Player player1 = new Player("María Luisa", "32027371A", 100, 10);
        Player player4 = new Player("Phoenix Wright", "33333333A", 0, 40);
        Player player5 = new Player("Dolores", "55555555A", 50, 99);
        Player[] bestPlayers = new Player[]{player5, player4, player1};
        ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, 10, ranking, bestPlayers,1978, "Taito");
        Player testPlayer = new Player("a", "a", 0, 0);
        Player[] players = {testPlayer};
        ArcadeMachine[] arcadeMachines = {testArcadeMachine};
        ArcadeRoom arcadeRoomTest = new ArcadeRoom(players, arcadeMachines);
    }

    @Test
    void playMachine() throws Exception {
        int[] ranking = new int[]{200, 100, 0};
        Player player1 = new Player("María Luisa", "32027371A", 100, 10);
        Player player4 = new Player("Phoenix Wright", "33333333A", 0, 40);
        Player player5 = new Player("Dolores", "55555555A", 50, 99);
        Player[] bestPlayers = new Player[]{player5, player4, player1};
        ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, 10, ranking, bestPlayers,1978, "Taito");
        Player testPlayer = new Player("a", "a", 0, 0);
        Player[] players = {testPlayer};
        ArcadeMachine[] arcadeMachines = {testArcadeMachine};
        ArcadeRoom arcadeRoomTest = new ArcadeRoom(players, arcadeMachines);
        arcadeRoomTest.arcadeMachines[0].modifyActivationMachine(false);
        arcadeRoomTest.players[0].rechargeCredits(10);
        arcadeRoomTest.playMachine("Escriba el ID del jugador que va a jugar (números y letra): ", "Escriba el nombre de la máquina que va a usarse: ", 9999, 20, 30);
        assertEquals(0, arcadeRoomTest.players[0].getAvailableCredits());
    }

    @Test
    void cantPlayMachineNotEnoughCredits() throws Exception {
        int[] ranking = new int[]{200, 100, 0};
        Player player1 = new Player("María Luisa", "32027371A", 100, 10);
        Player player4 = new Player("Phoenix Wright", "33333333A", 0, 40);
        Player player5 = new Player("Dolores", "55555555A", 50, 99);
        Player[] bestPlayers = new Player[]{player5, player4, player1};
        ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, 10, ranking, bestPlayers,1978, "Taito");
        Player testPlayer = new Player("a", "a", 0, 0);
        Player[] players = {testPlayer};
        ArcadeMachine[] arcadeMachines = {testArcadeMachine};
        ArcadeRoom arcadeRoomTest = new ArcadeRoom(players, arcadeMachines);
        Exception thrown = assertThrows(Exception.class, () -> arcadeRoomTest.playMachine("Escriba el ID del jugador que va a jugar (números y letra): ", "Escriba el nombre de la máquina que va a usarse: ", 9999, 20, 30));
    }
}