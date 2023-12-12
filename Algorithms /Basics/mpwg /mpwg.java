import java.util.Random;

public class pw {

    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

    private static String generatePassword(int length) {
    
        Random random = new Random();
        
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; ++i) {
        
            int index = random.nextInt(CHARSET.length());
            
            password.append(CHARSET.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
    
        int length = 12; // Default password length

        // Parse command line arguments
        if (args.length > 0) {
        
            if (args[0].equals("-h") || args[0].equals("--help")) {
            
                System.out.println("Usage: java PasswordGenerator [options]");
                System.out.println("Options:");
                System.out.println("  -l, --length  Length of the password (default: 12)");
                
                return;
                
            } else if (args[0].equals("-l") || args[0].equals("--length")) {
            
                if (args.length > 1) {
                
                    length = Integer.parseInt(args[1]);
                    
                } else {
                
                    System.err.println("Error: Missing argument for password length.");
                    System.exit(1);
                }
                
            } else {
            
                System.err.println("Error: Invalid command-line argument.");
                System.err.println("Use 'java PasswordGenerator --help' for usage.");
                System.exit(1);
            }
        }

        // Generate password
        String password = generatePassword(length);

        // Print the generated password
        System.out.println("Generated Password: " + password);
    }
}
