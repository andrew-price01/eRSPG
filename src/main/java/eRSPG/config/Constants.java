package eRSPG.config;

/**
 * Application constants.
 */
public final class Constants {

    private Constants() {
    }

    /* These Constants are for Roles in Spring Security */
    public static final String SPRING_ROLE_USER = "ROLE_USER";
    public static final String SPRING_ROLE_ADMIN = "ROLE_ADMIN";
    public static final String SPRING_ROLE_CHAIRMAN = "ROLE_CHAIRMAN";

    /* This Enum is for User Role Types*/
    public static final int USERROLE_USER = 1;
    public static final int USERROLE_ADMIN = 2;
    public static final int USERROLE_CHAIRMAN = 3;

    /* These Constants are for attribute keys required to get attributes from CAS */
    public static final String CAS_ATTRIBUTE_MEMBEROF = "memberOf";             // affiliation's in cas  NOTE: concern not all staff will have Staff affiliation in memberOf
    public static final String CAS_ATTRIBUTE_DISPLAYNAME = "displayName";       // displayName returned as "FirstName LastName"
    public static final String CAS_ATTRIBUTE_EMAIL = "EMail";                   // email address
    public static final String CAS_ATTRIBUTE_WNUMBER = "WNumber";               // W Number

    /*  These Constants Are for use with the application when using Weber's CAS */
    // These are Webers actual URLS
//    public static final String CAS_URL_LOGIN = "https://cas.weber.edu/login";
//    public static final String CAS_URL_LOGOUT = "https://cas.weber.edu/logout";
//    public static final String CAS_URL_PREFIX = "https://cas.weber.edu";
//    public static final String CAS_SERVER = "https://cas.weber.edu";
    // These are Webers development URLs
    public static final String CAS_URL_LOGIN = "https://casdev.weber.edu/login";
    public static final String CAS_URL_LOGOUT = "https://casdev.weber.edu/logout";
    public static final String CAS_URL_PREFIX = "https://casdev.weber.edu";
    public static final String CAS_SERVER = "https://casdev.weber.edu";
    public static final String CAS_SERVICE_URL = "http://localhost:8081/eRSPG/home";
    public static final String APP_SERVER = "http://localhost:8081";


    /*  These Constants Are for use with the CAS-SERVER-WEBAPP-3.5.1 */
//    public static final String APP_SERVER = "http://localhost:8081";
//    public static final String CAS_SERVICE_URL = "http://localhost:8081/login";
//    public static final String CAS_URL_LOGIN = "https://localhost:8443/cas-server-webapp-3.5.1/login";
//    public static final String CAS_URL_LOGOUT = "https://localhost:8443/cas-server-webapp-3.5.1/logout";
//    public static final String CAS_URL_PREFIX = "https://localhost:8443/cas-server-webapp-3.5.1";
//    public static final String CAS_SERVER= "http://localhost:8443";
}