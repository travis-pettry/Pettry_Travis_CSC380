package Service;

/**
 * Created with IntelliJ IDEA.
 * User: tpettry
 * Date: 8/11/13
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuItem {

    private String name;
    private String description;
    private double price;


    public MenuItem(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
