package com.pbilbd.constants;

public class BaseConstants {

    /**
     * Base
     * URL
     * For
     * Connecting
     * Server
     */
    public static String DEV_BASE_URL = "http://pvely.com/api/v1/";

    public static String DEV_IMAGE_FETCH_URL = "http://pvely.com/";


    /**
     * Errors
     * Message
     * */
    public static int FAILURE_ERROR = 500;

    public static String ERROR_FAILURE = "Internal server connection failed!";

    public static int UNKNOWN_ERROR = 501;

    public static String ERROR_UNKNOWN = "Please try again later";

    public static String ERROR_UNAUTHORIZED = "Your session has expired, please login again";

    /**
     * Access
     * Stuff
     * */
    public static String ACCESS_TOKEN = "ACCESS_TOKEN";

    public static String PREFF_ERROR = "NOT_FOUND";

    /**
     * Default
     * Values
     * */
    public static String TRANSACTION_ZERO = "Pending";

    public static String TRANSACTION_ONE = "Paid";

}
