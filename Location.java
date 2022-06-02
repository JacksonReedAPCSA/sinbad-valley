import core.data.*;
public class Location {
    private float temp;
    private String name;

    public Location(String name, String link){
        this.name = name;
        DataSource ds = DataSource.connect(link);
        temp = ds.fetchFloat("temp_c");
    }

    public String name(){
        return name;
    }
    
    public float temp(){
        return temp;
    }
}
