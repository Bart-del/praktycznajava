package swagger_gen_exmpl.impl;

import swagger_gen_exmpl.*;
import swagger_gen_exmpl.dto.*;


import java.util.Map;
import swagger_gen_exmpl.dto.OrderDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public class StoreApiServiceImpl extends StoreApiService {
    @Override
    public Response deleteOrder(Long orderId){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getInventory(){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getOrderById(Long orderId){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response placeOrder(OrderDTO body){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
