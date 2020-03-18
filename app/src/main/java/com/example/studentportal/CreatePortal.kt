package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_create_portal.*
import kotlinx.android.synthetic.main.content_create_portal.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class CreatePortal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }

    private fun initViews() {
        btnAdd.setOnClickListener { onAddClick() }
    }

    private fun onAddClick() {
        if (etTitle.text.toString().isNotBlank() && etTitle.text.toString().isNotBlank()) {
            val portal = Portal(
                etTitle.text.toString(),
                etUrl.text.toString()
            )
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(
                this, "The reminder cannot be empty"
                , Toast.LENGTH_SHORT
            ).show()
        }

    }

}
