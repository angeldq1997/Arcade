package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    // Definimos el objeto para usarlo en todos los tests
    private Player testPlayer;

    @BeforeEach
    public void setUpClass(){
        Player testPlayer = new Player("A", "1", 0, 0);
    }

    @Test
    void rechargeCredits() throws Exception {
        Exception thrown = assertThrows(Exception.class, () -> testPlayer.rechargeCredits(0));
        Exception thrown2 = assertThrows(Exception.class, () -> testPlayer.rechargeCredits(-30));

        testPlayer.rechargeCredits(1);
        assertEquals(1, testPlayer.getAvailableCredits());

        testPlayer.spendCredits(1);
        testPlayer.rechargeCredits(20);
        assertEquals(20, testPlayer.getAvailableCredits());
    }

    @Test
    @DisplayName("Test de créditos para verificar negativos, más de lo que tiene y que se descuentan los correctos.")
    void spendCredits() throws Exception {
        Exception thrown = assertThrows(Exception.class, () -> testPlayer.spendCredits(100));
        Exception thrown2 = assertThrows(Exception.class, () -> testPlayer.spendCredits(-20));
        testPlayer.rechargeCredits(20);
        testPlayer.spendCredits(20);
        assertEquals(0, testPlayer.getAvailableCredits());
        testPlayer.rechargeCredits(100);
        testPlayer.spendCredits(20);
        assertEquals(80, testPlayer.getAvailableCredits());
    }

    @Test
    @DisplayName("Test de créditos para no gastar más de los que tiene.")
    void spendCreditsNoMore() throws Exception {
        testPlayer.rechargeCredits(20);
        Exception thrown = assertThrows(Exception.class, () -> testPlayer.spendCredits(30));
        assertEquals(20, testPlayer.getAvailableCredits());
    }
}