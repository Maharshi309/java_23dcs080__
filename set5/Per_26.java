class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Per_26 {
        public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is less than 18. Not eligible to vote.");
        } else {
            System.out.println("You are eligible to vote.");
        }
    }

    public static void main(String[] args) {
        try {
            
            checkAge(16);
        } 
        catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
System.out.println("23DCS080 Maharshi Patel ");

    }
}
