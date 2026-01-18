package com.anurag.apicalling

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anurag.apicalling.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        binding.btnRef.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        RetrofitClient.api.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(
                p0: Call<List<User>?>,
                p1: Response<List<User>?>
            ) {
                val random = p1.body()?.random()
                binding.etName.text = random?.name
                binding.etEmail.text = random?.email
            }

            override fun onFailure(
                p0: Call<List<User>?>,
                p1: Throwable
            ) {
                Toast.makeText(this@MainActivity, "Error while calling api ...", Toast.LENGTH_SHORT).show()
            }
        })
            }
        }



