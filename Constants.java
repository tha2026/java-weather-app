package weatherapp;

public class Constants {
    public static Pair API_KEY = new Pair("key", "API_KEY");
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

