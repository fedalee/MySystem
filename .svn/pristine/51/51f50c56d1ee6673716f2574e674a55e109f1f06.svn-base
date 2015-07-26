package com.wabacus.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author 晶晶
 */
public class IdentifierGenerator {

    /**
     * @param args the command line arguments
     */

    final static private StringBuilder stringBuffer = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int range = stringBuffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(stringBuffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }


    public static String getStringId() {
        return (new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date())) + "_" + getRandomString(9);

    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

    
    
}

