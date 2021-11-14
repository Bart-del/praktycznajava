package swagger_gen_exmpl.factories;

import swagger_gen_exmpl.StoreApiService;
import swagger_gen_exmpl.impl.StoreApiServiceImpl;

public class StoreApiServiceFactory {

   private final static StoreApiService service = new StoreApiServiceImpl();

   public static StoreApiService getStoreApi()
   {
      return service;
   }
}
