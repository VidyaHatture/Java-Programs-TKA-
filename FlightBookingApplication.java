
import java.util.Scanner;

class Flight {
    String name;
    int seats = 20;
    int fare = 4000;

    Flight(String name) {
        this.name = name;
    }
}

abstract class Passenger {
    String name;

    Passenger(String name) {
        this.name = name;
    }

    abstract double discount();
}

class Student extends Passenger {
    Student(String name) {
        super(name);
    }

    double discount() {
        return 0.10;
    }
}

class Regular extends Passenger {
    Regular(String name) {
        super(name);
    }

    double discount() {
        return 0;
    }
}

public class FlightBookingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Flight f = new Flight("Pune to Delhi");

        while (true) {
            System.out.println("\n1. View Flight");
            System.out.println("2. Book Flight");
            System.out.println("3. View Booking");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println(f.name + " | Seats: "
                        + f.seats + " | Fare: Rs." + f.fare);
            } else if (choice == 2) {
                System.out.print("Passenger name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Student or Regular: ");
                String type = sc.nextLine();

                System.out.print("Number of tickets: ");
                int tickets = sc.nextInt();
                sc.nextLine();

                if (name.trim().isEmpty() || age <= 0 ||
                    tickets <= 0 || tickets > f.seats ||
                    (!type.equalsIgnoreCase("Student") &&
                     !type.equalsIgnoreCase("Regular"))) {
                    System.out.println("Invalid booking details!");
                    continue;
                }

                Passenger p;
                if (type.equalsIgnoreCase("Student"))
                    p = new Student(name);
                else
                    p = new Regular(name);

                double total = f.fare * tickets;
                total = total - total * p.discount();

                f.seats -= tickets;

                System.out.println("Booking ID: BK1001");
                System.out.println("Passenger: " + p.name);
                System.out.println("Total Fare: Rs." + total);
            } else if (choice == 3) {
                System.out.println("Check the booking details shown after booking.");
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
