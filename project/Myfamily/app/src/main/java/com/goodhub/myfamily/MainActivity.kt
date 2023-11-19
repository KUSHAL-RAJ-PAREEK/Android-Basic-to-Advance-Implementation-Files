package com.goodhub.myfamily

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.location.LocationRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.location.LocationManagerCompat.isLocationEnabled
import androidx.fragment.app.Fragment
import com.d4d5.myfamily.GuardFragment
import com.goodhub.myfamily.databinding.ActivityMainBinding
import com.goodhub.myfamily.databinding.FragmentHomeBinding
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    private val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.CAMERA,
        Manifest.permission.READ_CONTACTS
    )
    val permissionCode = 78
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (isAllPermissionsGranted()) {
            if (isLocationEnabled(this)) {
                setUpLocationListener()
            } else {
                showGPSNotEnabledDialog(this)
            }
        } else {
            askForPermission()
        }

        binding.bottomBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_guard -> {
                    inflateFragment(GuardFragment.newInstance())
                }

                R.id.nav_home -> {
                    inflateFragment(HomeFragment.newInstance())
                }

                R.id.nav_profile -> {
                    inflateFragment(UserFragment.newInstance())
                }

                R.id.nav_dashboard -> {
                    inflateFragment(MapsFragment())
                }
            }

            true
        }
        binding.bottomBar.selectedItemId = R.id.nav_home

        val currentUser = FirebaseAuth.getInstance().currentUser
        val name = currentUser?.displayName.toString()
        val mail = currentUser?.email.toString()
        val phoneNumber = currentUser?.phoneNumber.toString()
        val imageUrl = currentUser?.photoUrl.toString()


        val db = Firebase.firestore
        // Create a new user with a first and last name
        val user = hashMapOf(
            "first_name" to name,
            "mail" to mail,
            "phoneNumber" to phoneNumber,
            "imageUrl" to imageUrl
        )

        db.collection("users").document(mail).set(user).addOnSuccessListener { }
            .addOnFailureListener { }

    }

    private fun isAllPermissionsGranted(): Boolean {
        for (item in permissions) {
            if (ContextCompat
                    .checkSelfPermission(
                        this,
                        item
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }

    private fun setUpLocationListener() {
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        val locationRequest = com.google.android.gms.location.LocationRequest().setInterval(2000).setFastestInterval(2000)
            .setPriority(com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY)


        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }

        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    super.onLocationResult(locationResult)
                    for (location in locationResult.locations) {
                        Log.d("Location89", "onLocationResult: latitude ${location.latitude}")
                        Log.d("Location89", "onLocationResult: longitude ${location.longitude}")


                        val currentUser = FirebaseAuth.getInstance().currentUser
                        val mail = currentUser?.email.toString()

                        val db = Firebase.firestore

                        val locationData = mutableMapOf<String,Any>(
                            "lat" to location.latitude.toString(),
                            "long" to location.longitude.toString(),
                        )


                        db.collection("users").document(mail).update(locationData)
                            .addOnSuccessListener {

                            }.addOnFailureListener {

                            }


                    }
                }
            },
            Looper.myLooper()
        )
    }




private fun askForPermission() {
    ActivityCompat.requestPermissions(this, permissions, permissionCode)
}

private fun inflateFragment(newInstance: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container, newInstance)
    transaction.commit()
}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == permissionCode) {

            if (allPermissionGranted()) {
                setUpLocationListener()
            } else {

            }
        }
    }

    private fun openCamera() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }

    fun isLocationEnabled(context: Context): Boolean {
        val locationManager: LocationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    /**
     * Function to show the "enable GPS" Dialog box
     */
    fun showGPSNotEnabledDialog(context: Context) {
        AlertDialog.Builder(context)
            .setTitle("Enable GPS")
            .setMessage("required_for_this_app")
            .setCancelable(false)
            .setPositiveButton("enable_now") { _, _ ->
                context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            }
            .show()
    }
    private fun allPermissionGranted(): Boolean {
        for (item in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    item
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }
}