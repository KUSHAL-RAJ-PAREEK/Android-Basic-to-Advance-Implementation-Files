package com.krp.mapexample

import android.graphics.Color
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.location.Geocoder
import android.location.Geocoder.GeocodeListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions
import com.krp.mapexample.databinding.ActivityMapsApiBinding
import java.util.Locale

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { map ->

            val ametLoc = LatLng(25.3015, 73.9280)
            map.apply {
                addMarker(
                    MarkerOptions().position(ametLoc).title("Amet")
                        .snippet("JAI SINGH SYAM JI (Narayan's place)")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                )
                moveCamera(CameraUpdateFactory.newLatLng(ametLoc))
                animateCamera(CameraUpdateFactory.newLatLngZoom(ametLoc, 20f))


                addCircle(
                    CircleOptions().center(ametLoc).radius(500.0).fillColor(Color.CYAN)
                        .strokeColor(Color.GRAY)
                )

                addPolygon(
                    PolygonOptions().add(
                        LatLng(25.3015, 73.9280),
                        LatLng(25.3015, 73.9280),
                        LatLng(25.3015, 74.9280),
                        LatLng(27.3015, 74.9280),
                        LatLng(25.3015, 73.9280)
                    )
                        .fillColor(Color.BLUE).strokeColor(Color.MAGENTA)
                )

                setOnMapClickListener { latlng ->

                    val geoCoder = Geocoder(this@MapsActivity, Locale.getDefault())
                    val arrAddr = geoCoder.getFromLocation(latlng.latitude, latlng.longitude, 1)
                    var addr = ""
                    for(i in 0 until (arrAddr?.get(0)?.maxAddressLineIndex ?: 0)){
                     addr += arrAddr?.get(0)?.getAddressLine(i) ?: 0
                    }

                    addMarker(
                        MarkerOptions()
                            .position(latlng)
                            .title(addr)
                    )

                }
            }


        }

    }

    override fun onMapReady(p0: GoogleMap) {
        TODO("Not yet implemented")
    }

}