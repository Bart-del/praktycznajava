package swagger_gen_exmpl;

import swagger_gen_exmpl.dto.*;
import swagger_gen_exmpl.StoreApiService;
import swagger_gen_exmpl.factories.StoreApiServiceFactory;

import io.swagger.annotations.ApiParam;

import java.util.Map;
import swagger_gen_exmpl.dto.OrderDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/store")


@io.swagger.annotations.Api(value = "/store", description = "the store API")
public class StoreApi  {

   private final StoreApiService delegate = StoreApiServiceFactory.getStoreApi();

    @DELETE
    @Path("/order/{orderId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete purchase order by ID", notes = "For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found") })

    public Response deleteOrder(@ApiParam(value = "ID of the order that needs to be deleted",required=true ) @PathParam("orderId")  Long orderId)
    {
    return delegate.deleteOrder(orderId);
    }
    @GET
    @Path("/inventory")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns pet inventories by status", notes = "Returns a map of status codes to quantities", response = Integer.class, responseContainer = "Map")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation") })

    public Response getInventory()
    {
    return delegate.getInventory();
    }
    @GET
    @Path("/order/{orderId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find purchase order by ID", notes = "For valid response try integer IDs with value >= 1 and <= 10.         Other values will generated exceptions", response = OrderDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found") })

    public Response getOrderById(@ApiParam(value = "ID of pet that needs to be fetched",required=true ) @PathParam("orderId")  Long orderId)
    {
    return delegate.getOrderById(orderId);
    }
    @POST
    @Path("/order")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Place an order for a pet", notes = "", response = OrderDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Order") })

    public Response placeOrder(@ApiParam(value = "order placed for purchasing the pet" ,required=true ) OrderDTO body)
    {
    return delegate.placeOrder(body);
    }
}

