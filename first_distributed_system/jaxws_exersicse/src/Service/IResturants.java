package Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tpettry
 * Date: 8/11/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(name="IResturants", targetNamespace = "http://localhost/IResturants")
public interface IResturants {

    @WebMethod(operationName="getResturants")
    public @WebResult(name="Resturnats")List<Resturant> getResturants();

    @WebMethod(operationName = "setResturants")
    public @WebResult(name="setResturnats")void setResturants(@WebParam(name="rest")List<Resturant> resturants);


}
