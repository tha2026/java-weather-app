package weatherapp;

public class Constants {
    public static Pair API_KEY = new Pair("key", "2313c9f01c4a4ea39b8214515230908");
    public static Pair LOCATION_IDENTIFIER = new Pair("q", "02067");

    public static class Pair {
        public String name;
        public String value;

        Pair(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }
}

