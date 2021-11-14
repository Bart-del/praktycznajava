package swagger_gen_exmpl;

import swagger_gen_exmpl.*;
import swagger_gen_exmpl.dto.*;

import java.util.Map;
import swagger_gen_exmpl.dto.OrderDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class StoreApiService {
    public abstract Response deleteOrder(Long orderId);
    public abstract Response getInventory();
    public abstract Response getOrderById(Long orderId);
    public abstract Response placeOrder(OrderDTO body);
}

