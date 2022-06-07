public class SinbadValley{
    public static void main(String[] args) {
        Location NY = new Location("New York", "https://w1.weather.gov/xml/current_obs/KNYC.xml");
        System.out.println(NY.name() + "\'s temperature: " + NY.temp() + " celcius.");
        NY.printUsageString();
    }
}