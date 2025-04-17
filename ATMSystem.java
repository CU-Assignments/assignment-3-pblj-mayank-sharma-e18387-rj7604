import java.util.*;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        final int correctPin = 1234;
        double balance = 3000.0;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin != correctPin) {
                throw new InvalidPinException("Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = sc.nextDouble();

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful! Amount withdrawn: " + amount);
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numbers only.");
        } finally {
            System.out.println("Current Balance: " + balance);
        }
    }
}
