package com.nanx.osm_kotlin_mvvm.view

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.nanx.osm_kotlin_mvvm.R
import com.nanx.osm_kotlin_mvvm.model.Details
import com.nanx.osm_kotlin_mvvm.model.Reverse
import com.nanx.osm_kotlin_mvvm.model.Search
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mMainActivityViewModel: MainActivityViewModel? = null
    internal var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mMainActivityViewModel?.init()

        buttonDetails.setOnClickListener {
            mMainActivityViewModel?.details(
                editTextDetailsType.text.toString(),
                editTextDetailsId.text.toString().toIntOrNull()
            )?.startMyProgress()
        }

        buttonReverse.setOnClickListener {
            mMainActivityViewModel?.reverse(
                editTextReverseLat.text.toString().toDoubleOrNull(),
                editTextReverseLon.text.toString().toDoubleOrNull()
            )?.startMyProgress()
        }

        buttonSearch.setOnClickListener {
            mMainActivityViewModel?.search(
                editTextSearch.text.toString()
            )?.startMyProgress()
        }

        mMainActivityViewModel?.getError()
            ?.observe(this, Observer { error -> showError(error) })

        mMainActivityViewModel?.getDetails()
            ?.observe(this, Observer { details -> myDialog(details, "details") })

        mMainActivityViewModel?.getReverse()
            ?.observe(this, Observer { reverse -> myDialog(reverse, "reverse") })

        mMainActivityViewModel?.getSearch()
            ?.observe(this, Observer { search -> myDialog(search, "search") })
    }

    private fun myDialog(myObject: Any?, title: String?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
        if (myObject != null) {
            when (myObject) {
                is Search -> setMessage(builder, myObject)

                is Details -> builder.setMessage(
                    myObject.category + "\n" + myObject.type + "\n" + myObject.localname
                ).show().endMyProgress()

                is Reverse -> builder.setMessage(
                    myObject.displayName
                ).show().endMyProgress()
            }
        } else {
            builder.setMessage("invalid field!").show().endMyProgress()
        }
    }

    private fun setMessage(builder: AlertDialog.Builder, myObject: Search) {
        myObject.features?.forEach {
            builder.setMessage(it?.properties?.displayName).show()
        }
        endProgress()
    }


    fun startProgress() {
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("loading")
        progressDialog?.show()
    }

    fun endProgress() {
        progressDialog?.dismiss()
    }

    private fun Unit.startMyProgress() {
        startProgress();
    }

    private fun AlertDialog.endMyProgress() {
        endProgress()
    }

    fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        endProgress()
    }

}






