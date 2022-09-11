# FT Teknoloji Java Spring Practicum First Case

### Entity Sınıflarımız



* [User]
* [Product]
* [ProductComment]

### Dto Sınıflarımız

* [UserRequest]
* [ProductRequest]
* [ProductCommentRequest]
* [ProductCommentUpdateRequest]



### End Pointler

     Version değerimiz
     VERSION = "/v1";


     Her bir entitye ait url  
     
     USER = "/user";
     PRODUCT = "/product";
     COMMENT = "/comment";

   
     * GENEL olarak tanımlanan isteklerin burada tanımlayalım
   
     SAVE= "/save";
     UPDATE= "/update/{id}";
     DELETE= "/delete/{id}";
     FINDALL= "/findAll";
     FINDBYID= "/findbyId/{id}";




     * CONTROLLER için özel olarak tanımladığınız end pointler
    

     *PoductController

     GETBYEXPIRATIONDATEBEFORE= "/expirationDateBefore"; ( son kullanma tarihi geçmiş ürünler)
     GETBYEXPIRATIONDATEAFTERORNULL= "/expirationDateAfter"( son kullanma tarihi geçmemiş ve null olan ürünler);

    
     * PoductCommentController
      
     GETBYPRODUCTID= "/getbyProductId/{productId}";
     GETBYUSERID= "/getByUserId/{userid}";
     GETBYCOMMENTDATE= "/getByCommentDate/{start}/{finish}";
     GETBYCOMMENTDATEANDUSERID= "/getByCommentDateAndUserId/{start}/{finish}/{userid}";
     
     
     
     
     ![usercontroller](usercontroller.png)

     
     ![productcontroller](https://user-images.githubusercontent.com/64216822/189535532-4d6ac037-4b9f-4f94-a105-5e7afe8d4320.png)

     
     ![productCommentcontroller](https://user-images.githubusercontent.com/64216822/189535536-041f4ac3-4f83-4aca-95ba-6a1568c5a316.png)

