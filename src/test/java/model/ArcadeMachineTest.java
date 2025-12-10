package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcadeMachineTest {

    // Definimos el objeto para usarlo en todos los tests
    static ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, 1978, "Taito");

    @BeforeAll
    public static void setUpClass(){
        ArcadeMachine testArcadeMachine = new ArcadeMachine("Space Invaders", "Shoot' em Up", 10, 1978, "Taito");
    }

    @Test
    void modifyActivationMachine() throws Exception {
        assertTrue(testArcadeMachine.isActivated());
        testArcadeMachine.modifyActivationMachine(false);
        assertFalse(testArcadeMachine.isActivated());
    }

    @Test
    void addPlayTimeToMachine() {
    }
}