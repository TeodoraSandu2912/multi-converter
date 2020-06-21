package com.bham.pij.assignments.converters;

public class BinaryToHexadecimal {

    private boolean checkBinary1(String value) {

        if (value.length() != 8) {
            throw new InvalidFormatException();
        }

        for (char c : value.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new InvalidFormatException();
            }
        }

        return true;

    }


    public String convert(String value) {

        checkBinary1(value);
        String hexa = "";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                'b', 'c', 'd', 'e', 'f'};
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        int decimal = Integer.parseInt(binaryToDecimal.convert(value));

        if (decimal == 0) {
            return "00";
        }

        while (decimal > 0) {
            hexa = hex[decimal % 16] + hexa;
            decimal /= 16;
        }

        if (hexa.length() == 1) {
            hexa = "0" + hexa;
        }


        return hexa.toUpperCase();
    }

}
