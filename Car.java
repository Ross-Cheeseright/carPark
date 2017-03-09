package carpark;

public class Car {
    // Attributes //
    private String regNo;
    private String colour;
    private String make;
    private String model;
    
    // Construct // 
    public Car(String regNo, String colour, String make, String model)
    {
        this.regNo = regNo;
        this.colour = colour;
        this.make = make;
        this.model = model;
    }
    
    // Getting //
    public String getColour() {
        return colour;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
    
    public String getRegNo()
    {
        return this.regNo;
    }

}
