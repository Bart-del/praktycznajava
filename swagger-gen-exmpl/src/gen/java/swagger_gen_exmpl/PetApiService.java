package swagger_gen_exmpl;

import swagger_gen_exmpl.*;
import swagger_gen_exmpl.dto.*;

import swagger_gen_exmpl.dto.PetDTO;
import swagger_gen_exmpl.dto.ApiResponseDTO;
import java.io.File;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class PetApiService {
    public abstract Response addPet(PetDTO body);
    public abstract Response deletePet(Long petId,String apiKey);
    public abstract Response findPetsByStatus(List<String> status);
    public abstract Response findPetsByTags(List<String> tags);
    public abstract Response getPetById(Long petId);
    public abstract Response updatePet(PetDTO body);
    public abstract Response updatePetWithForm(Long petId,String name,String status);
    public abstract Response uploadFile(Long petId,String additionalMetadata,InputStream fileInputStream,Attachment fileDetail);
}

