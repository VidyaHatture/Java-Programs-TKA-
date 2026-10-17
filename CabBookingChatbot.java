
import java.util.Scanner;

public class CabBookingChatbot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Cab Booking Chatbot ---");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("\nChoose Cab:");
                System.out.println("1. Auto - Rs.12/km");
                System.out.println("2. Sedan - Rs.18/km");
                System.out.println("3. SUV - Rs.25/km");
                System.out.print("Enter choice: ");

                int cab = sc.nextInt();
                int rate = 0;
                String cabName = "";

                if (cab == 1) {
                    cabName = "Auto";
                    rate = 12;
                } else if (cab == 2) {
                    cabName = "Sedan";
                    rate = 18;
                } else if (cab == 3) {
                    cabName = "SUV";
                    rate = 25;
                } else {
                    System.out.println("Invalid cab choice!");
                    continue;
                }

                System.out.println("\nChoose Route:");
                System.out.println("1. Pune Station to Shivajinagar - 5 km");
                System.out.println("2. Swargate to Kothrud - 8 km");
                System.out.println("3. Hinjawadi to Wakad - 10 km");
                System.out.print("Enter route: ");

                int route = sc.nextInt();
                String source = "";
                String destination = "";
                int distance = 0;

                if (route == 1) {
                    source = "Pune Station";
                    destination = "Shivajinagar";
                    distance = 5;
                } else if (route == 2) {
                    source = "Swargate";
                    destination = "Kothrud";
                    distance = 8;
                } else if (route == 3) {
                    source = "Hinjawadi";
                    destination = "Wakad";
                    distance = 10;
                } else {
                    System.out.println("Invalid route!");
                    continue;
                }

                int fare = rate * distance;

                System.out.println("\n--- Ride Details ---");
                System.out.println("Cab: " + cabName);
                System.out.println("Source: " + source);
                System.out.println("Destination: " + destination);
                System.out.println("Distance: " + distance + " km");
                System.out.println("Rate: Rs." + rate + "/km");
                System.out.println("Total Fare: Rs." + fare);

                System.out.println("\n1. Confirm and Share OTP");
                System.out.println("2. Cancel Ride");
                System.out.print("Enter choice: ");

                int confirm = sc.nextInt();

                if (confirm == 2) {
                    System.out.println("Ride cancelled!");
                } else if (confirm == 1) {

                    int otp = (int)(Math.random() * 9000) + 1000;

                    System.out.println("Your OTP is: " + otp);
                    System.out.println("Ride booked successfully!");
                    System.out.println(
                        "You cannot cancel the ride after OTP sharing.");

                } else {
                    System.out.println("Invalid choice! Booking not confirmed.");
                }

            } else if (choice == 2) {
                System.out.println("Thank you! Goodbye.");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
