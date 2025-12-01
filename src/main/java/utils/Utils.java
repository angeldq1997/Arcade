package utils;

import java.util.Scanner;

public class Utils {

    public static int intVerified(){
        int result=0;
        Scanner keyboard= new Scanner(System.in);
        return result;
    }

    public static boolean testInRange(int min, int max, int numberToVerify){
        boolean inRange=false;
        if(numberToVerify>=min && numberToVerify<=max){
            inRange=true;
        }else{
            inRange=false;
        }
        return inRange;
    }
}