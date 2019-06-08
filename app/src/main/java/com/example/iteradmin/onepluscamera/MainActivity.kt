package com.example.iteradmin.onepluscamera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE = 100
    var image:ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         image = findViewById<ImageView>(R.id.image)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            val bitmap:Bitmap = data?.extras?.get("data") as Bitmap
            image?.setImageBitmap(bitmap)


        }
    }
}
