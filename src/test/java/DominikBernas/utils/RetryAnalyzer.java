package DominikBernas.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Maksymalna liczba ponownych uruchomień

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test " + result.getName() + " with status "
                    + result.getStatus() + " for the " + (retryCount + 1) + " time(s).");
            return true;
        }
        return false;
    }
}