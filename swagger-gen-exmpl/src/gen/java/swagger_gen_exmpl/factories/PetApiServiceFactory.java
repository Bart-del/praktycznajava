package swagger_gen_exmpl.factories;

import swagger_gen_exmpl.PetApiService;
import swagger_gen_exmpl.impl.PetApiServiceImpl;

public class PetApiServiceFactory {

   private final static PetApiService service = new PetApiServiceImpl();

   public static PetApiService getPetApi()
   {
      return service;
   }
}
