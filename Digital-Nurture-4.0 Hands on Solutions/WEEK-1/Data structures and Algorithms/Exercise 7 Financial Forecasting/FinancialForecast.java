public class FinancialForecast {

    // Step 2 & 3: Recursive method to forecast future value
    public static double recursiveForecast(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + growthRate) * recursiveForecast(presentValue, growthRate, years - 1);
    }

    // Step 4: Optimized version using memoization
    public static double memoizedForecast(double presentValue, double growthRate, int years, Double[] memo) {
        if (years == 0)
            return presentValue;
        if (memo[years] != null)
            return memo[years];

        memo[years] = (1 + growthRate) * memoizedForecast(presentValue, growthRate, years - 1, memo);
        return memo[years];
    }

    // Main method to test forecasting
    public static void main(String[] args) {
        double presentValue = 1000.0; 
        double growthRate = 0.05; 
        int years = 10; 

        // Using plain recursion
        double futureValueRecursive = recursiveForecast(presentValue, growthRate, years);
        System.out.println("Future Value (Recursive): $" + futureValueRecursive);

        // Using memoized recursion
        Double[] memo = new Double[years + 1];
        double futureValueMemoized = memoizedForecast(presentValue, growthRate, years, memo);
        System.out.println("Future Value (Memoized): $" + futureValueMemoized);
    }
}
