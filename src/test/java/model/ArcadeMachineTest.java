package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcadeMachineTest {

    // Definimos el objeto para usarlo en todos los tests

    private Player player1 = new Player("María Luisa", "32027371A", 100, 10);
    private Player player4 = new Player("Phoenix Wright", "33333333A", 0, 40);
    private Player player5 = new Player("Dolores", "55555555A", 50, 99);
    private int[] ranking = new int[]{200, 100, 0};
    private Player[] bestPlayers = new Player[]{player5, player4, player1};
    private ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, 10, ranking, bestPlayers,1978, "Taito");
    private ArcadeMachine testArcadeMachine2 = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, 10, ranking, bestPlayers,1978, "Taito");

    @Test
    void modifyActivationMachine() throws Exception {
        assertTrue(testArcadeMachine.isActivated());
        testArcadeMachine.modifyActivationMachine(false);
        assertFalse(testArcadeMachine.isActivated());
    }


    @Test
    void addPlayTimeToMachine() throws Exception {
        assertEquals(0, testArcadeMachine.getTimesPlayed());
        testArcadeMachine.addPlayTimeToMachine();
        assertEquals(1, testArcadeMachine.getTimesPlayed());
    }

    @Test
    void reachOneHundredPlayedTimes() throws Exception {
        assertTrue(testArcadeMachine2.isActivated());
        assertEquals(99, testArcadeMachine2.getTimesPlayed());
        testArcadeMachine2.addPlayTimeToMachine();
        assertEquals(100, testArcadeMachine2.getTimesPlayed());
        assertFalse(testArcadeMachine2.isActivated());
    }
}