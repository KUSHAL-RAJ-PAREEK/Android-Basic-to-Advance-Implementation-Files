package com.krp.dynamicappexample

import android.app.Application
import android.media.tv.AdResponse
import android.renderscript.RenderScript.Priority
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Error
import java.util.PriorityQueue


class MyActivityViewModel(application: Application) : AndroidViewModel(application) {

    @OptIn(DelicateCoroutinesApi::class)
    fun getPosts(){

        GlobalScope.launch(Dispatchers.IO) {
            AndroidNetworking.initilize(getApplication<Application>().applicationContext)
            AndroidNetworking.get("https://jsonplaceholder.typicode.com/posts")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(object : JSONArrayRequestListner{
                    override fun onResponse(response: JSONArray?){

                        Log.d("Res",response.toString())

                        response!!.let {
                            for (i in 0 until response.length()){
                            val objResult = response.getJSONObject(i)
                            val  title = objResult.getString("tittle")

                            Log.d("Tittle of post",title)
                        }


                        }

                    }
                    override fun onError(anError: AnError?){

                    }
                })
        }
    }

    fun Login(){

        GlobalScope.launch (Dispatchers.IO){
            AndroidNetworking.initilize(getApplication<Application>().applicationContext)
            AndroidNetworking.post("URL of Post API")
                .addBodyParameter("email","EMAIL_HERE@gimail.com")
                .addBodyParameter("password","PASSWORD_HERE")
                .setPriority(PriorityQueue.HIGH)
                .build()
                .getAsJSONObject(object: JSONObjectRequestListner{
                    override fun onResponse(response: JSONObject?){

                        val msg = response!!.getString("message")
                        Log.d("Message",msg)

                    }

                    override fun onError(anError: ANError?){
                        Log.e("NetworkError", anError.toString())
                    }
                })
        }
    }

}


