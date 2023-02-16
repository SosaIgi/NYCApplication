package com.example.20230215-EsosaseheIgiehon-nycSchools.data


import com.example.20230215-EsosaseheIgiehon-nycSchools.model.NYCDetailResponseModel
import com.example.20230215-EsosaseheIgiehon-nycSchools.model.NYCListResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
* Created by sajin Abraham on 01/09/2022 15:39
*/

interface APIDetails {
    @GET("s3k6-pzi2.json")
    suspend fun getNYCSchools(): NYCListResponseModel

    @GET("f9bf-2cp4.json")
    suspend fun getSchoolDetails(
        @Query("dbn") schoolId: String,
    ): Response<NYCDetailResponseModel>
}
