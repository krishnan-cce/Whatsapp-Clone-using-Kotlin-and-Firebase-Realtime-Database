package com.example.mybook.Notifications

import android.content.ContentValues
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseInstanceId : FirebaseMessagingService()
{

    override fun onNewToken(p0: String)
    {
        super.onNewToken(p0)

        val firebaseUser = FirebaseAuth.getInstance().currentUser
        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener {
                    task ->
                if(!task.isSuccessful)
                {
                    Log.w(ContentValues.TAG,"Fetching FCM Token Failed", task.exception)
                    return@OnCompleteListener
                }
                val refreshToken = task.result
                if (firebaseUser!= null)
                {
                    updateToken(refreshToken)
                }
            })


    }



    private fun updateToken(refreshToken: String?)
    {
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val ref = FirebaseDatabase.getInstance().getReference().child("Tokens")
        val token = Token(refreshToken!!)
        ref.child(firebaseUser!!.uid).setValue(token)
    }
}
