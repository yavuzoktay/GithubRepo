package com.yavuzoktay.GithubUser.api.service;

import com.yavuzoktay.GithubUser.api.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Yavuz on 6.7.2017.
 */

public interface GithubClient {

    @GET("users/{user}/repos")
     Call<List<GithubRepo>> repoForUser(@Path("user") String user);

}
