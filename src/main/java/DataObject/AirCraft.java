package DataObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AirCraft implements Serializable{
    int id;

    public int getId() {
        return id;
    }

    int year;
    public int getYear() {
        return year;
    }

    String name;
    public String getName() {
        return name;
    }

    String Country;
    public String getCountry() {
        return Country;
    }
/*
    {
        'id':1,
         'year':1997,
    }

 */
    //If we want to convert a JSON to AirCraft, the following cont. should be used.
    @JsonCreator
    public AirCraft(@JsonProperty("id") int id,
                    @JsonProperty("Year") int year,
                    @JsonProperty("name") String name,
                    @JsonProperty("country") String Country) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.Country = Country;
    }
}
