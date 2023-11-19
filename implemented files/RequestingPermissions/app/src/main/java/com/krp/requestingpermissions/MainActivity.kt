package com.krp.requestingpermissions

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.krp.requestingpermissions.databinding.ActivityMainBinding
import io.nlopez.smartlocation.SmartLocation

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    val LOC_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCheckPerm.setOnClickListener {
            if(checkPerm()){
                Toast.makeText(this,"All Permission are Already Granted!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Permission not Granted!",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnReqPerm.setOnClickListener {
            if(!checkPerm()){
                reqPerm()
            }else{
                SmartLocation.with(this).location().continuous().start { loc->

                    Log.d("Current Location", "Lat: ${loc.latitude},long: ${loc.latitude}")

                }
            }
        }
    }
    fun checkPerm() : Boolean {

    val resFineLoc = ContextCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION)

        val resCoarseLoc = ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION)

        return resFineLoc == PackageManager.PERMISSION_GRANTED && resCoarseLoc == PackageManager.PERMISSION_GRANTED
    }
    fun reqPerm(){
        ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION),LOC_PERMISSION_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            LOC_PERMISSION_CODE ->{
                if(permissions.isNotEmpty()){

                    val locAccessAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
                    val locCoarseAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED

                    if(locAccessAccepted && locCoarseAccepted){
                        //Task to be done after permission granted

                        Toast.makeText(this,"This Permission Granted!",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Permissions Denied!",Toast.LENGTH_SHORT).show()

                        AlertDialog.Builder(this@MainActivity)
                            .setTitle("You need to allow access to both permissions")
                            .setPositiveButton("Okay"
                            ) { dialog, which -> reqPerm() }
                            .setNegativeButton("Cancel",null)
                            .create()
                            .show()
                    }

                }
            }
        }

    }
}


