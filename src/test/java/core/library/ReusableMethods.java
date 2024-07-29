package core.library;

public class ReusableMethods {
    private static final PropertyLoader properties = PropertyLoader.getInstance();
    public boolean isChrome() {
        return properties.getBrowser().equalsIgnoreCase(Constants.Browser.CHROME);
    }
    public boolean isFirefox() {
        return properties.getBrowser().equalsIgnoreCase(Constants.Browser.FIREFOX);
    }
}
