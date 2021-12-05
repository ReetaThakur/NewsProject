package com.example.newsproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsproject.R
import com.example.newsproject.response.Article
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),NewsListner {

    private lateinit var newsAdapter: NewAdapter
    private var list=ArrayList<Article>()
    private lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel=ViewModelProvider(this).get(NewsViewModel::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.callApi()
        }
        viewModel.liveData.observe(this,{
            when(it){
                is MainUiModel.onSuccess ->{
                    list=it.responseDTO.articles as ArrayList<Article>
                    setRecycelerView()
                }
                is MainUiModel.onFailure ->{
                    Toast.makeText(this,it.error,Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

    private fun setRecycelerView() {
        newsAdapter= NewAdapter(list,this)
        val linearLayoutManager=LinearLayoutManager(this)
        recylcerview.apply {
            adapter=newsAdapter
            layoutManager=linearLayoutManager
        }
    }

    override fun newsClick(article: Article) {
        var image=article.urlToImage
        var title=article.title
        var time=article.publishedAt
        var description=article.description
        Log.d("activity",image)
        val intent=Intent(this,NewsShowActivity::class.java)
        intent.putExtra("image",image)
        intent.putExtra("title",title)
        intent.putExtra("time",time)
        intent.putExtra("description",description)
        startActivity(intent)
    }
}