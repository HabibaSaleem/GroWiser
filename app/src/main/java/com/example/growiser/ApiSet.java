package com.example.growiser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//this class is used for declaration of apis attributes
public interface ApiSet {

    @FormUrlEncoded
     @POST("registeration")       //name of api in bracket
      Call<responsemodel> getregister(
              //these are the fields which are mentioned in registeration api
              @Field("name") String name,
              @Field("email") String email,
              @Field("password") String password,
              @Field("confirm_password") String confirm_password

    );

    @FormUrlEncoded
    @POST("login1")       //name of api in bracket
    Call<responsemodel> getlogin(
            //these are the fields which are mentioned in login1 api
            @Field("email") String email,
            @Field("password") String password


    );

}
