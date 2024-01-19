package bean;

// Public class to retrieve different geographic area data from census DB
public class GeographicArea {

    // Setter method for geographicAreaID field
    public Integer getGeographicAreaID() {
        return geographicAreaID;
    }

    // Setter method for geographicAreaID field
    public void setGeographicAreaID(Integer geographicAreaID) {
        this.geographicAreaID = geographicAreaID;
    }

    // Getter method for area code field
    public Integer getCode() {
        return code;
    }

    // Setter method for area code field
    public void setCode(Integer code) {
        this.code = code;
    }

    // Getter method for level
    public Integer getLevel() {
        return level;
    }

    // Setter method for level
    public void setLevel(Integer level) {
        this.level = level;
    }

    // Getter method for name field
    public String getName() {
        return name;
    }

    // Setter method for name field
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for alternative code
    public Integer getAlternativeCode() {
        return alternativeCode;
    }

    // Setter method for alternative code
    public void setAlternativeCode(Integer alternativeCode) {
        this.alternativeCode = alternativeCode;
    }

    // Getter method for total population field
    public Integer getTotalPopulation() {
        return totalPopulation;
    }

    // Setter method for total population value
    public void setTotalPopulation(Integer totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    // Private fields for geographic area
    private Integer geographicAreaID;
    private Integer totalPopulation;
    private Integer code;
    private Integer level;
    private String name;
    private Integer alternativeCode;
}
