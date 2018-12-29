package reflection;

public class Robot {
    @Save(name = "ID", order = 1 )
    private int id;
    @Save(name = "MODEL", order = 2)
    private String model;
    @Save(name = "PRICE", order = 3)
    private double price;

    public Robot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
