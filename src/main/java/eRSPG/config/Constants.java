package eRSPG.config;

/**
 * Application constants.
 */
public final class Constants {

    private Constants() {
    }

    /*  These Constants Are for use with the application when using Weber's CAS */
//    public static final String APP_SERVER = "http://localhost:8081";
//    public static final String CAS_URL_LOGIN = "https://casdev.weber.edu/login";
//    public static final String CAS_URL_LOGOUT = "https://casdev.weber.edu/logout";
//    public static final String CAS_URL_PREFIX = "https://casdev.weber.edu";
//    public static final String CAS_SERVER = "https://casdev.weber.edu";
//    public static final String CAS_SERVICE_URL = "http://localhost:8081/eRSPG/home";
//    public static final String CAS_URL_LOGOUT_SUCCESS = CAS_URL_LOGOUT+"?service="+APP_SERVER;

    /*  These Constants Are for use with the CAS WAR OVERLAY */
//    public static final String APP_SERVER = "http://localhost:8081";
//    public static final String CAS_SERVER = "http://localhost:8443";
//    public static final String CAS_SERVICE_URL = "http://localhost:8081/eRSPG/home";
//    public static final String CAS_URL_LOGIN = "https://localhost:8443/cas/login";
//    public static final String CAS_URL_LOGOUT = "https://localhost:8443/cas/logout";
//    public static final String CAS_URL_PREFIX = "https://localhost:8443/cas";
//    public static final String CAS_URL_LOGOUT_SUCCESS = CAS_URL_LOGOUT+"?service="+APP_SERVER;

    /*  These Constants Are for use with the CAS-SERVER-WEBAPP-3.5.1 */
    public static final String APP_SERVER = "http://localhost:8081";
    public static final String CAS_SERVICE_URL = "http://localhost:8081/eRSPG/home";
    public static final String CAS_URL_LOGIN = "https://localhost:8443/cas-server-webapp-3.5.1/login";
    public static final String CAS_URL_LOGOUT = "https://localhost:8443/cas-server-webapp-3.5.1/logout";
    public static final String CAS_URL_PREFIX = "https://localhost:8443/cas-server-webapp-3.5.1";
    public static final String CAS_SERVER= "http://localhost:8443";
    public static final String CAS_URL_LOGOUT_SUCCESS = CAS_URL_LOGOUT+"?service="+APP_SERVER;
}