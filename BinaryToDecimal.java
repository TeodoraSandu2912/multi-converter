package com.bham.pij.assignments.converters;

import java.lang.*;

public class BinaryToDecimal {

    private void checkFormat(String bin) {

        if (bin.length() != 8) {
            throw new InvalidFormatException();
        }
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) != '0' && bin.charAt(i) != '1') {
                throw new InvalidFormatException();
            }
        }

    }

    public String convert(String value) {

        checkFormat(value);

        int decimal = 0;
        int n = 0;
        int binary = Integer.parseInt(value);
        while (true) {
            if (binary == 0) {
                break;
            } else {
                int temp = binary % 10;
                decimal += temp * Math.pow(2, n);
                binary = binary / 10;
                n++;
            }
        }
        return Integer.toString(decimal);
    }
}

