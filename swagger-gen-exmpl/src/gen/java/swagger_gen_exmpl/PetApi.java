package swagger_gen_exmpl;

import swagger_gen_exmpl.dto.*;
import swagger_gen_exmpl.PetApiService;
import swagger_gen_exmpl.factories.PetApiServiceFactory;

import io.swagger.annotations.ApiParam;

import swagger_gen_exmpl.dto.PetDTO;
import swagger_gen_exmpl.dto.ApiResponseDTO;
import java.io.File;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/pet")


@io.swagger.annotations.Api(value = "/pet", description = "the pet API")
public class PetApi  {

   private final PetApiService delegate = PetApiServiceFactory.getPetApi();

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new pet to the store", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response addPet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) PetDTO body)
    {
    return delegate.addPet(body);
    }
    @DELETE
    @Path("/{petId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a pet", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Pet not found") })

    public Response deletePet(@ApiParam(value = "Pet id to delete",required=true ) @PathParam("petId")  Long petId,
    @ApiParam(value = ""  )@HeaderParam("api_key") String apiKey)
    {
    return delegate.deletePet(petId,apiKey);
    }
    @GET
    @Path("/findByStatus")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Finds Pets by status", notes = "Multiple status values can be provided with comma separated strings", response = PetDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid status value") })

    public Response findPetsByStatus(@ApiParam(value = "Status values that need to be considered for filter",required=true) @QueryParam("status")  List<String> status)
    {
    return delegate.findPetsByStatus(status);
    }
    @GET
    @Path("/findByTags")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Finds Pets by tags", notes = "Muliple tags can be provided with comma separated strings. Use         tag1, tag2, tag3 for testing.", response = PetDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid tag value") })

    public Response findPetsByTags(@ApiParam(value = "Tags to filter by",required=true) @QueryParam("tags")  List<String> tags)
    {
    return delegate.findPetsByTags(tags);
    }
    @GET
    @Path("/{petId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find pet by ID", notes = "Returns a single pet", response = PetDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Pet not found") })

    public Response getPetById(@ApiParam(value = "ID of pet to return",required=true ) @PathParam("petId")  Long petId)
    {
    return delegate.getPetById(petId);
    }
    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update an existing pet", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Pet not found"),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception") })

    public Response updatePet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) PetDTO body)
    {
    return delegate.updatePet(body);
    }
    @POST
    @Path("/{petId}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates a pet in the store with form data", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response updatePetWithForm(@ApiParam(value = "ID of pet that needs to be updated",required=true ) @PathParam("petId")  Long petId,
    @ApiParam(value = "Updated name of the pet" )@Multipart(value = "name", required = false)  String name,
    @ApiParam(value = "Updated status of the pet" )@Multipart(value = "status", required = false)  String status)
    {
    return delegate.updatePetWithForm(petId,name,status);
    }
    @POST
    @Path("/{petId}/uploadImage")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "uploads an image", notes = "", response = ApiResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation") })

    public Response uploadFile(@ApiParam(value = "ID of pet to update",required=true ) @PathParam("petId")  Long petId,
    @ApiParam(value = "Additional data to pass to server" )@Multipart(value = "additionalMetadata", required = false)  String additionalMetadata,
    @ApiParam(value = "file to upload") @Multipart(value = "file", required = false) InputStream fileInputStream,
    @ApiParam(value = "file to upload : details") @Multipart(value = "file" , required = false) Attachment fileDetail)
    {
    return delegate.uploadFile(petId,additionalMetadata,fileInputStream,fileDetail);
    }
}

