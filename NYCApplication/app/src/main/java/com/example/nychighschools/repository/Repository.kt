package com.example.20230215-EsosaseheIgiehon-nycSchools.repository


import com.example.20230215-EsosaseheIgiehon-nycSchools.model.NYCDetailResponseModel
import com.example.20230215-EsosaseheIgiehon-nycSchools.model.NYCListResponseModel
import retrofit2.Response

interface Repository {
    suspend fun getNYCSchools(): NYCListResponseModel

    suspend fun getSchoolDetails(schoolId: String): Response<NYCDetailResponseModel>
}