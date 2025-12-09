package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

    // Definimos el objeto para usarlo en todos los tests
    static Utils myUtils;

    @BeforeAll
    public static void setUpClass(){
        Utils myUtils = new Utils();
    }

    @Test
    void genRandomNumber() {
        assertTrue(Utils.genRandomNumber(9999)<10000);
        assertTrue(Utils.genRandomNumber(9999)>1);
    }

    @Test
    void verifyInRange() {
        assertTrue(Utils.verifyInRange(1, 10, 5));
        assertTrue(Utils.verifyInRange(-100, 1, -20));
        assertFalse(Utils.verifyInRange(10, 20, 30));
        assertFalse(Utils.verifyInRange(-100, -30, 20));
    }
}