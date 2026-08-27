import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;
        boolean exit = false;

        do {
            System.out.println("\n===== Currency Converter =====");
            System.out.println("1. USD to INR");
            System.out.println("2. INR to GBP");
            System.out.println("3. JPY to AUD");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter amount in USD: ");

                        try {
                            BigDecimal amount = scanner.nextBigDecimal();

                            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                                System.out.println("Please enter a valid amount.");
                                break;
                            }

                            BigDecimal exchangeRate = new BigDecimal("83.50");

                            BigDecimal convertedAmount =
                                    amount.multiply(exchangeRate);

                            convertedAmount = convertedAmount.setScale(
                                    2, RoundingMode.HALF_EVEN);

                            System.out.printf(
                                    "Converted Amount: %,.2f INR%n",
                                    convertedAmount);

                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid number.");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        System.out.print("Enter amount in INR: ");

                        try {
                            BigDecimal amount = scanner.nextBigDecimal();

                            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                                System.out.println("Please enter a valid amount.");
                                break;
                            }

                            BigDecimal exchangeRate = new BigDecimal("0.0095");

                            BigDecimal convertedAmount =
                                    amount.multiply(exchangeRate);

                            convertedAmount = convertedAmount.setScale(
                                    2, RoundingMode.HALF_EVEN);

                            System.out.printf(
                                    "Converted Amount: %,.2f GBP%n",
                                    convertedAmount);

                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid number.");
                            scanner.nextLine();
                        }
                        break;

                    case 3:
                        System.out.print("Enter amount in JPY: ");

                        try {
                            BigDecimal amount = scanner.nextBigDecimal();

                            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                                System.out.println("Please enter a valid amount.");
                                break;
                            }

                            BigDecimal exchangeRate = new BigDecimal("0.010");

                            BigDecimal convertedAmount =
                                    amount.multiply(exchangeRate);

                            convertedAmount = convertedAmount.setScale(
                                    2, RoundingMode.HALF_EVEN);

                            System.out.printf(
                                    "Converted Amount: %,.2f AUD%n",
                                    convertedAmount);

                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid number.");
                            scanner.nextLine();
                        }
                        break;

                    case 4:
                        exit = true;
                        System.out.println("Thank you for using Currency Converter.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                choice = 0;
            }

        } while (!exit);

        scanner.close();
    }
}