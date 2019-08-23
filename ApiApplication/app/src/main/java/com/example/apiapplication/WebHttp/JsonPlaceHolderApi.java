package com.example.apiapplication.WebHttp;

import com.example.apiapplication.Model.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("Posts")
    Call<ResponseBody> getPosts();

    @GET("Posts")
    Call<ResponseBody> getPost(@Query("id") int id);
}
