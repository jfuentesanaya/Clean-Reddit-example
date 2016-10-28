package com.example.data.net;

import android.content.Context;

import com.example.data.entity.ListEntity;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public interface RestApi {

    String BASE_URL = "https://api.reddit.com/r/programming/";

    class Creator {
        public static RestApi restApiImpl(Context context) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15,TimeUnit.SECONDS)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();

//            Gson gson = new GsonBuilder()
//                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(RestApi.class);
        }
    }

    @GET("new.json")
    Call<ListEntity> getPostList();
}
