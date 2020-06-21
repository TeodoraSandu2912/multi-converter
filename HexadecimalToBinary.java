package com.bham.pij.assignments.converters;

import java.lang.*;

public class HexadecimalToBinary {

    private String digits = "0123456789ABCDEF";

    boolean checkHexadecimal(String hex) {

        if (hex.length() != 2 || hex.isEmpty()) {

            throw new InvalidFormatException();
        }

        if (!hex.matches("[0-9A-F]{2,}")) {
            throw new InvalidFormatException();
        }
        return true;
    }


    public String convert(String hexaDecimal) {

        if (checkHexadecimal(hexaDecimal)) {
            int val = 0;
            for (int i = 0; i < hexaDecimal.length(); i++) {
                char c = hexaDecimal.charAt(i);
                int d = digits.indexOf(c);
                val = 16 * val + d;
            }
            String n = Integer.toString(val);
            DecimalToBinary binary = new DecimalToBinary();
            return (binary.convert(n));
        }
        return null;
    }
}
