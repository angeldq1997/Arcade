package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcadeMachineTest {

    // Definimos el objeto para usarlo en todos los tests
    static ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, true, 0,1978, "Taito");
    static ArcadeMachine testArcadeMachine2 = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, true, 99,1978, "Taito");

    @BeforeAll
    public static void setUpClass(){
        ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, true, 0,1978, "Taito");
    }

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