package com.example.producto

import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {

    fun addUser(userData: ProductsInfo, onResult: (ProductsInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<ProductsInfo> {
                override fun onFailure(call: Call<ProductsInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<ProductsInfo>, response: Response<ProductsInfo>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }


}