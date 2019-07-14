package com.example.android.measurementconverter;

public class ConversionFunction {

    public static double milesToKilometers(double miles) {
        return 1.6093 * miles;
    }

    public static double kilometersToMiles(double kilometers) {
        return .6214 * kilometers;
    }

    public static double inchesToCentimeters(double inches) {
        return 2.54 * inches;
    }

    public static double centimetersToInches(double centimeters) {
        return .3937 * centimeters;
    }
}
