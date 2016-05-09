/**
 * Created by НОЗДОРМУ on 09.05.2016.
 */

import org.junit.BeforeClass;

public abstract class TestSetup {

    protected static String appURL;
    protected static String fromFlightName;
    protected static String toFlightName;
    protected static String flightDeparting;
    protected static String flightReturning;
    protected static String numberOfAdults;
    protected static String numberOfChildren;
    protected static String valueOfPreferredClass;
    protected static boolean oneWayDirection;

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
        flightDeparting = "01/02/2017";
        System.out.println(flightDeparting);
        flightReturning = "01/02/2017";
        System.out.println(flightReturning);
        oneWayDirection = false;
        System.out.println("oneWayDirection "+Boolean.toString(oneWayDirection));
        numberOfAdults = "2";
        System.out.println(numberOfAdults);
        numberOfChildren = "0";
        System.out.println(numberOfChildren);
        valueOfPreferredClass = "Business";
        System.out.println(valueOfPreferredClass);

    }

}