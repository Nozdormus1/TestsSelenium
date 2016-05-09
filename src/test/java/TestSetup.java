/**
 * Created by НОЗДОРМУ on 09.05.2016.
 */

import org.junit.BeforeClass;

public abstract class TestSetup {

    protected static String appURL;
    protected static String fromFlightName;
    protected static String toFlightName;

    @BeforeClass
    public static void setUpTest() {
        String baseUrl = System.getProperty("baseUrl", "https://www.expedia.com");
        String appName = System.getProperty("appName", "");
        //System.out.println(appName);
        appURL = baseUrl + "/" + appName;
        System.out.println(appURL);
        fromFlightName = "Kiev";
        System.out.println(fromFlightName);
        toFlightName = "Lviv";
        System.out.println(toFlightName);
    }

}