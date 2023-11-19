package com.krp.sensorsexample

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.getSystemService
import com.krp.sensorsexample.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

        val sm = getSystemService(SENSOR_SERVICE) as SensorManager

        val acceleroMeter = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        val proxiMeter = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        val lightMeter = sm.getDefaultSensor(Sensor.TYPE_LIGHT)

        sm.registerListener(this,acceleroMeter,SensorManager.SENSOR_DELAY_NORMAL)
        sm.registerListener(this,proxiMeter,SensorManager.SENSOR_DELAY_NORMAL)
        sm.registerListener(this,lightMeter,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val values = event!!.values

        val sensorType = event.sensor.type
        if( sensorType == Sensor.TYPE_PROXIMITY){
            binding.txtProxi.text = "${values[0]}"
        }else if(sensorType == Sensor.TYPE_LIGHT){
            binding.txtLight.text = "${values[0]}"
        }
        else{
            binding.txtValues.text = "X: ${values[0]}, Y: ${values[1]}, Z: ${values[2]}"

        }



    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}