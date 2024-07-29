package core.library;

public class PropertyLoader {

    private static volatile PropertyLoader instance;

    public static PropertyLoader getInstance() {
        if (instance == null) {
            synchronized (PropertyLoader.class) {
                if (instance == null) {
                    instance = new PropertyLoader();
                }
            }
        }
        return instance;
    }

    /*
    Property to save the browser type
     */
    private String browser;

    /*
    Property to save the base URL
     */
    private String baseUrl;

    /**
      Browser property getter
      @return the browser value
     */
    public String getBrowser() {
        return browser;
    }

    /*
    Browser property setter

     @param browser new value for browser
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    /*
     Base URL property getter

     @return the baseUrl value
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /*Base URL property setter

      @param baseUrl new value for baseUrl
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}

