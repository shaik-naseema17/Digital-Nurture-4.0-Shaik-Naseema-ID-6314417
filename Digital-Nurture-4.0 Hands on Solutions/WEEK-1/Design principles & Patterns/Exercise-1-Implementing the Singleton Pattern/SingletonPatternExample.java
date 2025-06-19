public class SingletonPatternExample {
    static class Logger {
        // Step 1: Private static instance
        private static Logger instance;

        // Step 2: Private constructor to prevent instantiation
        private Logger() {
            System.out.println("Logger initialized");
        }

        // Step 3: Public static method to return the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Method to log messages
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");
        // Confirm both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances! Singleton failed.");
        }
    }
}
