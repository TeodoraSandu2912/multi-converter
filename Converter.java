package com.bham.pij.assignments.converters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Converter {

    private ConvertMode convertMode;
    private ArrayList<String> inputValues;
    private ArrayList<String> outputValues;

    public enum ConvertMode {
        BIN2HEX,
        HEX2BIN,
        BIN2DEC,
        DEC2BIN
    }


    public Converter(Converter.ConvertMode cm) {
        convertMode = cm;
        inputValues = new ArrayList<>();
        outputValues = new ArrayList<>();
    }


    public String convert(String value) throws InvalidFormatException {

        switch (this.convertMode) {
            case BIN2HEX:
                BinaryToHexadecimal binaryToHexadecimal = new BinaryToHexadecimal();
                return binaryToHexadecimal.convert(value);
            case HEX2BIN:
                HexadecimalToBinary hexadecimalToBinary = new HexadecimalToBinary();
                return hexadecimalToBinary.convert(value);
            case BIN2DEC:
                BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
                return binaryToDecimal.convert(value);
            case DEC2BIN:
                DecimalToBinary decimalToBinary = new DecimalToBinary();
                return decimalToBinary.convert(value);
        }
        return null;
    }


    public void fromFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String input = "";

            while ((input = br.readLine()) != null ) {
                    inputValues.add(input);
                    outputValues.add(convert(input));
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getInputValues() {

        return inputValues;

    }

    public ArrayList<String> getOutputValues() {

        for (int i = 0; i < inputValues.size(); i++) {
            outputValues.add(convert(inputValues.get(i)));
        }
        return outputValues;
    }
}



