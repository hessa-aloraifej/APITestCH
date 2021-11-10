package com.example.apitestch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.apitestch.API.APIClient
import com.example.apitestch.API.APIInterface
import com.example.apitestch.JSON.DICDetailsItem
import com.example.apitestch.JSON.Def
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyVM(application: Application): AndroidViewModel(application) {
    private var contents: MutableLiveData<List<MyDic>> = MutableLiveData()
    var list:ArrayList<MyDic> = arrayListOf()
    val difList:ArrayList<Def> = arrayListOf()



    var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    fun getContents() = contents


    fun getData(word:String){
        apiInterface?.getPhoto(word)?.enqueue(object: Callback<List<DICDetailsItem?>> {
            override fun onResponse(call: Call<List<DICDetailsItem?>>, response: Response<List<DICDetailsItem?>>) {

                if(response.isSuccessful) {
                    val resposeList = response.body()!!



                    for(i in resposeList){
                        var word= i!!.word
                        var meaning=i!!.meanings

                        for(i in meaning )
                        {
                            var dif=i!!.definitions
                            for (i in dif){
                                var diffinintion=i!!.definition
                                difList.add(Def(diffinintion))
                                println(diffinintion)
                            }

                        }

                        list.add(MyDic(word,difList))
                    }

               contents.postValue(list)


                }

            }

            override fun onFailure(call: Call<List<DICDetailsItem?>>, t: Throwable) {
                println(t.message)
            }
        })

    }



}