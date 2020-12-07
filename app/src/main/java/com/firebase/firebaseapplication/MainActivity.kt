package com.firebase.firebaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* btnReciveToken.setOnClickListener {
            FirebaseInstanceId.getInstance().instanceId
                    .addOnCompleteListener(OnCompleteListener { task ->
                        // 2
                        if (!task.isSuccessful) {
                            Log.w(TAG, "getInstanceId failed", task.exception)
                            return@OnCompleteListener
                        }
                        // 3
                        val token = task.result?.token

                        // 4
                        val msg = getString(R.string.token_prefix, token)
                        Log.d("TAG", msg)
                        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
                    })
        }*/
        }
    }