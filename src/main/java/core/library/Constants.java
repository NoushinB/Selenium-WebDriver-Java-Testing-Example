package core.library;

import java.time.Duration;

public class Constants {
    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);

    public static final class Browser {
        public static final String CHROME = "chrome";
        public static final String FIREFOX = "firefox";
        // Add other browsers if needed, e.g., Edge, Safari, etc.
    }

    public static final class Urls {
        public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
        // Add other URLs if needed
    }
}
