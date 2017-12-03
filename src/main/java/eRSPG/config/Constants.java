package eRSPG.config;

/**
 * Application constants.
 */
public final class Constants {

    private Constants() {
    }

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_FAST = "fast";
    public static final String SPRING_PROFILE_CLOUD = "cloud";
    public static final String SYSTEM_ACCOUNT = "system";

//    public static final String CAS_URL_LOGIN = "https://casdev.weber.edu/login";
//    public static final String CAS_URL_LOGOUT = "https://casdev.weber.edu/logout";
//    public static final String CAS_URL_PREFIX = "https://casdev.weber.edu";
//    public static final String CAS_SERVICE_URL = "https://cas.weber.edu/p3/serviceValidate";
    public static final String APP_SERVER = "http://localhost:8080";
    public static final String CAS_SERVICE_URL = "http://localhost:8080/eRSPG/home";
    public static final String CAS_URL_LOGIN = "https://localhost:8443/cas/login";
    public static final String CAS_URL_LOGOUT = "https://localhost:8443/cas/logout";
    public static final String CAS_URL_PREFIX = "https://localhost:8443/cas";

}