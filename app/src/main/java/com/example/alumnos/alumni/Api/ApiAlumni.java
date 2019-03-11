package com.example.alumnos.alumni.Api;

import com.example.alumnos.alumni.Models.JsonResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiAlumni {

    @FormUrlEncoded

    @POST("login")
    Call<JsonResponse> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<JsonResponse> register(@Field("email") String email, @Field("password") String password);


    @Multipart
    @POST("createevent")
    Call<JsonResponse> createEvent(@Part("title") RequestBody title,
                                   @Part("description") RequestBody description,
                                   @Part("id_type") RequestBody id_type,
                                   @Part("id_group[1]") RequestBody id_group,
                                   @Part("image") RequestBody image,
                                   @Header("Authorization")String authHeader);


    @GET("eventsandroid")
    Call<JsonResponse> getEventsList(@Query("type") Integer type, @Header("Authorization")String authHeader);

    @FormUrlEncoded

    @POST("deleteevent")
    Call<JsonResponse> delete(@Field("id") Integer id, @Header("Authorization")String authHeader);

    @GET("eventdata")
    Call<JsonResponse> getCommentList(@Query("id") Integer id_event, @Header("Authorization")String authHeader);

    @GET("notas")
    Call<JsonResponse> getNotasList(@Header("Authorization")String authHeader);

    @FormUrlEncoded

    @POST("updateuser")
    Call<JsonResponse> updateuser(@Field("id") Integer id, @Field("description") String description,
                                  @Field("name") String name,
                                  @Field("password") String password,
                                  @Field("phone") Integer phone,
                                  @Field("email") String email,
                                  @Header("Authorization")String authHeader);


    @FormUrlEncoded
    @POST("createcomment")
    Call<JsonResponse> createComment(@Field("title") String title, @Field("description") String description, @Field("id_event") int id_event, @Header("Authorization")String authHeader);

    @FormUrlEncoded

    @POST("recover")
    Call<JsonResponse> recover(@Field("email") String email);


    @GET("searcheventandroid")
    Call<JsonResponse> searchEvent(@Query("search") String search, @Query("type") Integer type, @Header("Authorization")String authHeader);
}
