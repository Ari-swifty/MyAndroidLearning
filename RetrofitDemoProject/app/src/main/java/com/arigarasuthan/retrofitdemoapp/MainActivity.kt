package com.arigarasuthan.retrofitdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.arigarasuthan.retrofitdemoapp.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        //getRequestWithQueryParameters()
        //getRequestWithPathParameters()
        uploadAlbum()
    }

    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
//            val response = retService.getAlbums()
            val response = retService.getSortedAlbums(3)
            emit(response)
        }

        responseLiveData.observe(this) { res ->
            val albumList = res.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumsItem = albumList.next()
                    val result =
                        " Album Title : ${albumsItem.title}\n Album ID : ${albumsItem.id}\n User ID : ${albumsItem.userId}\n\n\n"
                    binding.albumTitle.append(result)
                    Log.d("MyTAG", albumsItem.title)
                }
            }
        }
    }

    private fun getRequestWithPathParameters() {
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this) { res ->
            val title = res.body()?.title
            Toast.makeText(this, title, Toast.LENGTH_LONG).show()
        }
    }

    private fun uploadAlbum() {
        val album = AlbumsItem(0,"Beast Mode",3)

        val postReponse : LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postReponse.observe(this) {res->
            val receivedItem =res.body()
            val result =
                " Album Title : ${receivedItem?.title}\n Album ID : ${receivedItem?.id}\n User ID : ${receivedItem?.userId}\n\n\n"
            binding.albumTitle.text = result

        }
    }
}