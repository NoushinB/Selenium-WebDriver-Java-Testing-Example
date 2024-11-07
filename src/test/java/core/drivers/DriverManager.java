package core.drivers;


import org.openqa.selenium.WebDriver;

/**
 * Managing web drivers instances for threads
 */
public class DriverManager {
    // ThreadLocal to store WebDriver instances for each thread
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    /*
    Gets the WebDriver instance for the current thread.
     */
    public static WebDriver getDriver() {
        return driverThread.get();
    }

    /*
    Sets the WebDriver instance for the current thread.
     */
    public static void setDriver(WebDriver webDriver) {
        driverThread.set(webDriver);
    }

    /*
     Removes the WebDriver instance for the current thread and quits the browser.
     */
    public static void removeDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit(); // Close the browser
            driverThread.remove(); // Remove the WebDriver instance from the ThreadLocal
        }
    }
}
