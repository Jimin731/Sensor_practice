package com.example.sensor_practice

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count : Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        count = deviceSensors.size
        tv1.text = "전체 센서 수:$count"
        var sensorList = ArrayList<String>()

        for(i in 0 .. deviceSensors.size-1){
            var buf = deviceSensors[i].name + "/" + deviceSensors[i].power + "/" + deviceSensors[i].resolution + "/" +deviceSensors[i].maximumRange
            sensorList.add(buf)
        }

        var list = findViewById<View>(R.id.listView1) as ListView
        var adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, sensorList)

        list.adapter=adapter


    }
}