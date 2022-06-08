import core.data.*;
public class Location{
    private float temp;
    private String name;
    private DataSource ds;
    private final String TEMP = "temp_c";

    public Location(String name, String link){
        this.name = name;
        ds = DataSource.connect(link);
        ds.load();
        temp = ds.fetchFloat(TEMP);
    }

    public String name(){
        return name;
    }
    
    public double temp(){
        return (double) temp;
    }

    public String toString(){
        return "Temperature in " + name + " is " + temp + " celcius";
    }

    public void printUsageString(){
        ds.printUsageString();
    }
}
