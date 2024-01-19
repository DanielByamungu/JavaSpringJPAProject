package bean;

// Public class to help retrieve different age data from census DB
public class AgeRecord {
    // Getter method for description field
    public String getDescription() {
        return description;
    }

    // Setter method for description field
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method for male2021
    public Integer getMale2021() {
        return male2021;
    }

    //Setter method for male2021
    public void setMale2021(Integer male2021) {
        this.male2021 = male2021;
    }

    // Getter method for female2021
    public Integer getFemale2021() {
        return female2021;
    }

    //Setter method for female2021
    public void setFemale2021(Integer female2021) {
        this.female2021 = female2021;
    }

    // Getter method for male2016
    public Integer getMale2016() {
        return male2016;
    }

    //Setter method for male2016
    public void setMale2016(Integer male2016) {
        this.male2016 = male2016;
    }

    // Getter method for female2016
    public Integer getFemale2016() {
        return female2016;
    }

    //Setter method for female2016
    public void setFemale2016(Integer female2016) {
        this.female2016 = female2016;
    }

    // Private properties to use in AgeRecord
    private String description;
    private Integer male2021;
    private Integer female2021;
    private Integer male2016;
    private Integer female2016;
}
