package Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tpettry
 * Date: 8/11/13
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Resturants implements IResturants {

    private List<Resturant> resturants;

    public Resturants(){

    }

    @Override
    public List<Resturant> getResturants() {
        return resturants;
    }

    @Override
    public void setResturants(List<Resturant> resturants) {
        this.resturants = resturants;
    }
}
