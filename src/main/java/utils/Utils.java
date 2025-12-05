package utils;

import model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    /**
     * Solicita al usuario un número entero por consola y valida que la entrada sea correcta.
     * Si el usuario introduce un valor que no es un entero (por ejemplo, texto o decimales),
     * el método muestra un mensaje de error y vuelve a pedir el número hasta que sea válido.
     *
     * @param msn      mensaje que se muestra al usuario para solicitar el número
     * @param msnError mensaje que se muestra cuando la entrada no es válida
     * @return el número entero introducido correctamente por el usuario
     */
    public static int readInt(String msn, String msnError) {
        int result = 0;
        boolean isValid = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(msn);
                result = sc.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println(msnError);
                isValid = false;
                sc.nextLine();

            }
        } while (!isValid);
        return result;
    }

    /**
     * Lee un número entero introducido por el usuario y valida que esté dentro de un rango
     * específico definido por min y max.
     * Si el número está fuera del rango, se muestra un mensaje de aviso y se vuelve a solicitar la entrada.
     *
     * @param min      valor mínimo permitido (incluido)
     * @param max      valor máximo permitido (incluido)
     * @param msn      mensaje que se muestra para pedir el número
     * @param msnError mensaje que se muestra cuando la entrada no es válida
     * @return un número entero dentro del rango [min, max]
     */
    public static int readIntInRange(int min, int max, String msn, String msnError) {
        int result = 0;
        boolean validNumber = false;
        do {
            result = readInt(msn, msnError);
            if (result >= min && result <= max) {
                validNumber = true;
            } else {
                System.out.println(msnError);
                validNumber = false;
            }
        } while (!validNumber);
        return result;
    }


    public static boolean testInRange(int min, int max, int numberToVerify) {
        boolean inRange = false;
        if (numberToVerify >= min && numberToVerify <= max) {
            inRange = true;
        } else {
            inRange = false;
        }
        return inRange;
    }

    public static int genRandomNumber (int max){
        int randomNumber = (int) (Math.random()* (max+1));
        return randomNumber;
    }

    public int[] moveValues(int[] array, int position){
        int[] copy = new int[array.length];
        if(position > array.length){

        }
        for (int i = position; i < array.length; i++) {

        }
        return copy;
    }
}