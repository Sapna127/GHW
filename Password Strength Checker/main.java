import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int score = calculatePasswordStrength(password);
        String strength = determinePasswordStrength(score);

        System.out.println("Password strength: " + strength);
    }

    public static int calculatePasswordStrength(String password) {
        int score = 0;

        // Add points based on password length
        int length = password.length();
        score += Math.min(10, length) * 2;

        // Add points for including a mix of uppercase and lowercase letters
        if (password.matches("(?=.*[a-z])(?=.*[A-Z]).*")) {
            score += 10;
        }

        // Add points for including digits
        if (password.matches(".*\\d+.*")) {
            score += 5;
        }

        // Add points for including special characters
        if (password.matches(".*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?]+.*")) {
            score += 10;
        }

        return score;
    }

    public static String determinePasswordStrength(int score) {
        if (score >= 30) {
            return "Strong";
        } else if (score >= 20) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}
