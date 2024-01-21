package br.fakebank.api.mainframe.service

import org.bson.json.JsonObject
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Defina a interface da API
interface MainframeApi {
    @GET("/mainframe")
    fun getSomeData(): Call<JsonObject>
}

@Service
class MainframeService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://mainframe-api.com") // Substitua pela URL base da API mainframeApi
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: MainframeApi = retrofit.create(MainframeApi::class.java)

    fun sendMainframeRequest(): JsonObject? {
        val response = api.getSomeData().execute()
        return if (response.isSuccessful) response.body() else null
    }
}