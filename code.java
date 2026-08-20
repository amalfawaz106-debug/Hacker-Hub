import java.util.Scanner;
public class cyberguard{
    public static String checkPasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8)score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()].*")) score++;

        if (score <= 6) return "Weak";
        else if (score <= 8) return "Medium";
        else return "Strong";
    }
    // Phishing Detector
    public static String checkPhishing(String message) {
        int risk = 0;
        message = message.toLowerCase();

        if (message.contains("urgent")) {
            System.out.println("Contains urgency word");
            risk++;
        }
        if (message.contains("click here")) {
            System.out.println("Contains 'click here'");
            risk++;
        }
        if (message.contains("verify")) {
            System.out.println("Contains 'verify'");
            risk++;
        }
        if (message.contains("password")) {
            System.out.println("Mentions password");
            risk++;
        }
        if (message.contains("free") || message.contains("won")) {
            System.out.println("Too good to be true (free/won)");
            risk++;
        }
        if (risk >= 3) return "High Risk Phishing";
        else if (risk == 2) return "Suspicious";
        else return "Likely Safe";
    }
    //  Link Safety Checker
    public static String checkLinkSafety(String url) {
        int risk = 0;
        url = url.toLowerCase();

        if (url.contains("login")) {
            System.out.println("️ Contains 'login'");
            risk++;
        }
        if (url.contains("verify")) {
            System.out.println("️ Contains 'verify'");
            risk++;
        }
        if (url.contains("secure")) {
            System.out.println("️ Contains 'secure'");
            risk++;
        }
        if (url.contains("account")) {
            System.out.println("️ Contains 'account'");
            risk++;
        }

        if (url.length() > 60) {
            System.out.println("️ URL is very long");
            risk++;
        }

        int slashCount = url.length() - url.replace("/", "").length();
        if (slashCount > 5) {
            System.out.println("️ Too many '/' in URL");
            risk++;
        }

        if (url.matches("http[s]?://\\d+\\.\\d+\\.\\d+\\.\\d+.*")) {
            System.out.println("️ Uses IP address instead of domain");
            risk += 2;
        }

        if (risk >= 4) return "️ Dangerous Link";
        else if (risk >= 2) return "️ Suspicious Link";
        else return "Safe Link";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   ️ CYBERGUARD SECURITY TOOL   ");
        System.out.println("=================================");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Password Strength ");
            System.out.println("2. Scan Message for Phishing ");
            System.out.println("3. Check Link Safety ");
            System.out.println("4. Exit ");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("\nEnter password: ");
                String password = scanner.nextLine();

                String result = checkPasswordStrength(password);
                System.out.println("Result: " + result);

            } else if (choice == 2) {
                System.out.print("\nEnter message: ");
                String msg = scanner.nextLine();

                String result = checkPhishing(msg);
                System.out.println("Result: " + result);

            } else if (choice == 3) {
                System.out.print("\nEnter URL: ");
                String url = scanner.nextLine();

                String result = checkLinkSafety(url);
                System.out.println("Result: " + result);

            } else if (choice == 4) {
                System.out.println("\nGoodbye Stay safe!");
                break;

            } else {
                System.out.println("Invalid option");
            }
        }

        scanner.close();
    }
}
