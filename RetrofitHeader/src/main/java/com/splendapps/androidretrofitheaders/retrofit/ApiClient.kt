package com.splendapps.androidretrofitheaders.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


    companion object {

        private var retrofit: Retrofit? = null

        fun init(): ApiService {

            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl("https://www.universal-tutorial.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(ApiService::class.java)

        }


        fun getHeaderMap(): MutableMap<String, String> {
            return mutableMapOf(
                "Accept" to "application/json",
                "Authorization" to "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJuaWdhbWFiY0BnbWFpbC5jb20iLCJhcGlfdG9rZW4iOiIzSXpBeEZzUl83VV9fMWdqZlk1d2pyLWUwRWVXbDVFY0tqZThxMmVhMTFIdEpsMkR2OHV0elZiNC10bTVRSTZhWUV3In0sImV4cCI6MTY4MjgzNjA1Mn0.7EVASVHz61MGnzM-4N7_YhzSKrrF5yZu_skEWzBHRaM"
            )
        }

    }

}