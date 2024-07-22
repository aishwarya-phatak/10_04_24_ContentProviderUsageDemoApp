package com.bitcode.a10_04_24_contentproviderusagedemoapp

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
       val values = ContentValues()
        values.put("id",90032)
        values.put("title","Android Phone")
        values.put("price",45000)

        var newUri = contentResolver.insert(
            Uri.withAppendedPath(
                    Uri.parse(
                        "content://in.bitcode.products"),
                        "products"),
            values
        )

        Log.e("tag","$newUri")

        if(newUri != null){
            var cursor = contentResolver.query(
                newUri,
                null,
                null,
                null
                ,null
            )

            while (cursor!!.moveToNext() == true){
                    Log.e("tag","id -- ${cursor.getInt(0)}" +
                            "title -- ${cursor.getString(1)}" +
                            "price -- ${cursor.getInt(2)}")
            }

            cursor.close()
        }
    }
}