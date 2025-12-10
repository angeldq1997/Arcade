package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    /**
     * Solicita al usuario un número entero por consola y valida que la entrada sea correcta.
     * Si el usuario introduce un valor que no es un entero (por ejemplo, texto o decimales),
     * la función muestra un mensaje de error y vuelve a pedir el número hasta que sea válido.
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

    /**
     * Función para verificar una cadena, si excede un número de carácteres concreto salta excepción.
     * @param message Mensaje a introducir antes de pedir la cadena concreta, para especificar de que se trata.
     * @param characterCount Número máximo de carácteres que no debe exceder la cadena.
     * @return La cadena ya verificada.
     * @throws Exception Una excepción si la cadena está vacía o si excede el número de carácteres.
     */
    public static String verifyString(String message,int characterCount) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        String textToVerify = "";
        boolean isValid = false;
        do {
            System.out.println(message);
            textToVerify = keyboard.nextLine().trim();
            if (textToVerify.length() > characterCount) {
                throw new Exception("Error, ha excedido el número de carácteres máximo.");
            } else if (textToVerify.isEmpty()) {
                throw new Exception("Error, ha introducido un texto vacío.");
            }
            isValid = true;
        }while(!isValid);
        return textToVerify;
    }

    /**
     * Función para generar un número aleatorio desde 0 hasta el máximo indicado.
     * @param max El entero máximo indicado como límite del rango del aleatorio.
     * @return El número aleatorio generado.
     */
    public static int genRandomNumber(int max) {
        int randomNumber = (int) (Math.random() * (max + 1));
        return randomNumber;
    }

    /**
     * Función que comprueba un entero en un rango concreto, devuelve false si está fuera del rango y true si está dentro.
     * @param min Mínimo a introducir para el rango.
     * @param max Máximo a introducir para el rango.
     * @param numberToCheck Número a comprobar dentro del rango.
     * @return True si está dentro y false si está fuera.
     */
    public static boolean verifyInRange(int min, int max, int numberToCheck){
        boolean isInRange = false;
        if (numberToCheck >= min && numberToCheck <= max) {
            isInRange = true;
        } else {
            isInRange = false;
        }
        return isInRange;
    }

    /**
     * Función que comprueba si hay un objeto nulo dentro de un array concreto.
     * @param arrayToCheck Array a comprobar.
     * @return True si tiene un nulo y false si no tiene ninguno.
     */
    public static boolean isANullInArray(Object[] arrayToCheck){
        boolean thereIsAtLeastANull = false;
        for (int i = 0; i < arrayToCheck.length; i++) {
            if(arrayToCheck[i] == null){
                thereIsAtLeastANull = true;
            }
        }
        return thereIsAtLeastANull;
    }

    //TODO: Modificar función para desplazar valores array.
    public int[] moveValues(int[] array, int position) {
        int[] copy = new int[array.length];
        if (position > array.length) {

        }
        for (int i = position; i < array.length; i++) {

        }
        return copy;
    }
}