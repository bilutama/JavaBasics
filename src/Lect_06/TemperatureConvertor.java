package Lect_06;

import java.util.Scanner;

public class TemperatureConvertor {
    public static final double ABSOLUTE_ZERO_CELSIUS = -273.15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double temperatureCelsius = ABSOLUTE_ZERO_CELSIUS - 1.0;
        final double epsilon = 1.0e-10;

        while (temperatureCelsius - ABSOLUTE_ZERO_CELSIUS < epsilon) {
            System.out.print("Enter temperature in Celsius degrees: ");
            temperatureCelsius = scanner.nextDouble();
        }

        double temperatureKelvins = convertCelsiusToKelvins(temperatureCelsius);
        System.out.printf("Temperature in Kelvins: %.3f%n", temperatureKelvins);

        double temperatureFahrenheits = convertCelsiusToFahrenheits(temperatureCelsius);
        System.out.printf("Temperature in Fahrenheits: %.3f%n", temperatureFahrenheits);
    }

    public static double convertCelsiusToKelvins(double celsiusDegrees) {
        return celsiusDegrees - ABSOLUTE_ZERO_CELSIUS;
    }

    public static double convertCelsiusToFahrenheits(double celsiusDegrees) {
        return celsiusDegrees * 9 / 5 + 32;
    }
}