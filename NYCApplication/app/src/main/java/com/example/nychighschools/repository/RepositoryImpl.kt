package com.example.20230215-EsosaseheIgiehon-nycSchools.repository


import com.example.20230215-EsosaseheIgiehon-nycSchools.data.APIDetails
import com.example.20230215-EsosaseheIgiehon-nycSchools.model.NYCDetailResponseModel
import com.example.20230215-EsosaseheIgiehon-nycSchools.model.NYCListResponseModel
import com.example.20230215-EsosaseheIgiehon-nycSchools.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val fetchAPI: APIDetails) : Repository {
    override suspend fun getNYCSchools(): NYCListResponseModel =
        fetchAPI.getNYCSchools()

    override suspend fun getSchoolDetails(schoolId: String): Response<NYCDetailResponseModel> =
        fetchAPI.getSchoolDetails(schoolId)
}