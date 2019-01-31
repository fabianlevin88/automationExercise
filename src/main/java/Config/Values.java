package Config;

public class Values {

    private static final String URL = "https://www.buenasalud.net/indice-masa-corporal/";
    private static final String API = "https://jsonplaceholder.typicode.com/posts";

    public static String getPageURL() {
        return URL;
    }

    public static String getAPI() { return API; }
}
