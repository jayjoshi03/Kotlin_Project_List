package com.splendapps.androidretrofitheaders

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.splendapps.androidretrofitheaders.databinding.ActivityMainBinding
import com.splendapps.androidretrofitheaders.model.Country
import com.splendapps.androidretrofitheaders.model.State
import com.splendapps.androidretrofitheaders.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadCountry()

    }

    private fun loadCountry() {

        ApiClient.init().getCountry(ApiClient.getHeaderMap())
            .enqueue(object : Callback<List<Country>> {
                override fun onResponse(
                    call: Call<List<Country>>,
                    response: Response<List<Country>>
                ) {
                    // success

                    if (response.isSuccessful) {
                        var res = response.body()

                        res?.let {
                            var adapter = ArrayAdapter(
                                applicationContext,
                                android.R.layout.simple_spinner_dropdown_item,
                                it
                            )

                            binding.autoCountry.setAdapter(adapter)

                            binding.autoCountry.setOnItemClickListener { adapterView, view, pos, l ->

                                var country = it[pos].name
                                loadState(country)
                                //Toast.makeText(applicationContext, "${it[pos]}", Toast.LENGTH_SHORT).show()

                            }


                        }

                    }

                }

                override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                    // failed
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }

            })

    }

    private fun loadState(country: String) {


        ApiClient.init().getState(ApiClient.getHeaderMap(), country)
            .enqueue(object : Callback<List<State>> {
                override fun onResponse(call: Call<List<State>>, response: Response<List<State>>) {

                    if (response.isSuccessful) {
                        var res = response.body()

                        res?.let {
                            var adapter = ArrayAdapter(
                                applicationContext,
                                android.R.layout.simple_spinner_dropdown_item,
                                it
                            )

                            binding.autoState.setAdapter(adapter)

                            binding.autoState.setOnItemClickListener { adapterView, view, pos, l ->

                                var state = it[pos].name
                                // load city

                            }


                        }

                    }

                }

                override fun onFailure(call: Call<List<State>>, t: Throwable) {

                }

            })

    }
}