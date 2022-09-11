package com.example.practicumfirstcase.utility;

public class RestApiUrl {


    public static final String VERSION = "/v1";

    /**
     * CONTOLLER kısımlarında ki map listesini ayrıca burada yazalım
     */
    public static final String USER = "/user";
    public static final String PRODUCT = "/product";
    public static final String COMMENT = "/comment";

    /**
     * GENEL olarak tanımlanan isteklerin burada tanımlayalım
     */
    public static final String SAVE= "/save";
    public static final String UPDATE= "/update/{id}";
    public static final String DELETE= "/delete/{id}";
    public static final String FINDALL= "/findAll";

    public static final String FINDBYID= "/findbyId/{id}";



    /**
     * CONTROLLER için özel olarak tanımladığınız istek url lerini burada tanımlayalım ayrıştırabilirsiniz.
     */
 /**
  * PoductController
  *
  */
    public static final String GETBYEXPIRATIONDATEBEFORE= "/expirationDateBefore";
    public static final String GETBYEXPIRATIONDATEAFTERORNULL= "/expirationDateAfter";

    /**
     * PoductCommentController
     *
      */
    public static final String GETBYPRODUCTID= "/getbyProductId/{productId}";
    public static final String GETBYUSERID= "/getByUserId/{userid}";
    public static final String GETBYCOMMENTDATE= "/getByCommentDate/{start}/{finish}";
    public static final String GETBYCOMMENTDATEANDUSERID= "/getByCommentDateAndUserId/{start}/{finish}/{userid}";
}
