package Lect_06;

import java.util.Scanner;

public class TemperatureConvertor {
    final static double absoluteZeroCelsius = -237.15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double temperatureCelsius = absoluteZeroCelsius;

        while (temperatureCelsius <= absoluteZeroCelsius) {
            System.out.print("Enter temperature in Celsius degrees: ");
            temperatureCelsius = scanner.nextDouble();
        }

        double temperatureKelvins = convertCelsiusToKelvins(temperatureCelsius);
        System.out.printf("Temperature in Kelvins: %.3f%n", temperatureKelvins);

        double temperatureFahrenheits = convertCelsiusToFahrenheits(temperatureCelsius);
        System.out.printf("Temperature in Fahrenheits: %.3f%n", temperatureFahrenheits);
    }

    public static double convertCelsiusToKelvins(double celsiusDegrees) {
        return celsiusDegrees - absoluteZeroCelsius;
    }

    public static double convertCelsiusToFahrenheits(double celsiusDegrees) {
        return celsiusDegrees * 9 / 5 + 32;
    }
}