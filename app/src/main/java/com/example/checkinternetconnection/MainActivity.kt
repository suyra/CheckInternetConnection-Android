package com.example.checkinternetconnection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkConnection.setOnClickListener {
            if (isConnected()){
                result.text = "Connected"
            }else{
                result.text = "no network connection available"
            }
        }
    }
    fun isConnected() : Boolean{
        //get connectivity manager to manage network connectivity
        val connectivityManager : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        //to get wifi information from connectivity manager
        val wifiConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        // to get mobile data information from connectivity manager
        val mobileData = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

        return wifiConnection!=null && wifiConnection.isConnectedOrConnecting || mobileData!=null && mobileData.isConnectedOrConnecting
    }
}