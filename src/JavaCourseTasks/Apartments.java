package JavaCourseTasks;

import java.util.Scanner;

public class Apartments {
    public static void main(String[] args) {
        int entrancesCount = -1;
        int floorsCount = -1;

        Scanner scanner = new Scanner(System.in);

        // Assure that entrancesCount is not 0 nor negative
        while (entrancesCount <= 0) {
            System.out.print("Enter numbers of entrances (values > 0): ");
            entrancesCount = scanner.nextInt();
        }

        // Assure that floorsCount is not 0 nor negative
        while (floorsCount <= 0) {
            System.out.print("Enter numbers of floors (values > 0): ");
            floorsCount = scanner.nextInt();
        }

        int apartmentNumber = -1;
        // Assure that apartmentNumber is not 0 nor negative
        while (apartmentNumber <= 0) {
            System.out.print("Enter the apartment number (value > 0): ");
            apartmentNumber = scanner.nextInt();
        }

        final int apartmentsCountPerFloor = 4;
        //TODO: Implement an algorithm for variable number of apartments per floor

        // Assure that apartmentNumber doesn't exceed number of apartments in the building
        if (apartmentNumber > apartmentsCountPerFloor * entrancesCount * floorsCount) {
            System.out.print("The number of apartment you've entered ");
            System.out.println("exceeds the number of apartments in the building.");
        } else {
            int apartmentEntrance = (apartmentNumber - 1) / (floorsCount * apartmentsCountPerFloor) + 1;
            int apartmentFloor = (apartmentNumber - (apartmentEntrance - 1) * floorsCount * apartmentsCountPerFloor - 1) / apartmentsCountPerFloor + 1;

            /* Determination of the apartment's location on the following floor map:
            2 (Left Up)        3 (Right Up)
            1 (Left Down)      4 (Right Down)
             */
            int apartmentIndexOnFloor = apartmentNumber % apartmentsCountPerFloor;
            String apartmentLocationOnFloor;

            if (apartmentIndexOnFloor == 1) {
                apartmentLocationOnFloor = "Left Down";
            } else if (apartmentIndexOnFloor == 2) {
                apartmentLocationOnFloor = "Left Up";
            } else if (apartmentIndexOnFloor == 3) {
                apartmentLocationOnFloor = "Right Up";
            } else {
                apartmentLocationOnFloor = "Right Down";
            }

            System.out.printf("Entrance %d, floor %d, location is %s", apartmentEntrance, apartmentFloor, apartmentLocationOnFloor);
        }
    }
}