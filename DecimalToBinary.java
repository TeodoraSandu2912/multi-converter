package com.bham.pij.assignments.converters;

import java.lang.*;

public class DecimalToBinary {


    boolean checkFormat(String dec) {

        if(dec.equals("0") || dec.equals("00") || dec.equals("000")) {

            return true;
        }

        if (dec.length() > 3 || dec.isEmpty()) {

            throw new InvalidFormatException();

        }

        if (Integer.parseInt(dec) < 0 || Integer.parseInt(dec) > 255) {

            throw new InvalidFormatException();

        }
        if(dec.startsWith("0")) {

            throw new InvalidFormatException();
        }

        for (int i = 0; i < dec.length(); i++) {

            if (Character.isDigit(dec.charAt(i))) {
                return true;
            }

        }
        throw new InvalidFormatException();
    }


    public String convert(String value) {

        if (checkFormat(value)) {
            int index = Integer.parseInt(value);
            String bin = "";
            for (int i = 0; i < 8; i++) {
                int rem = index % 2;
                bin += rem;
                index /= 2;
            }
            return new StringBuilder(bin).reverse().toString();
        }
        return null;
    }

}
