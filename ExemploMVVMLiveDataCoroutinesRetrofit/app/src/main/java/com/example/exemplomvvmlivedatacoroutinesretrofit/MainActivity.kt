package com.example.exemplomvvmlivedatacoroutinesretrofit

import android.os.Bundle
import android.widget.AdapterView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.exemplomvvmlivedatacoroutinesretrofit.data.Episode
import com.example.exemplomvvmlivedatacoroutinesretrofit.data.seriesService
import com.example.exemplomvvmlivedatacoroutinesretrofit.ui.theme.ExemploMVVMLiveDataCoroutinesRetrofitTheme
import com.example.exemplomvvmlivedatacoroutinesretrofit.ui.theme.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainViewModel(seriesService) as T
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        println("entrouaquiiiii0000000000000000000")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExemploMVVMLiveDataCoroutinesRetrofitTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                println("entrouaquiiiii "+viewModel.episodesData.value.toString())
                    Episodes(episodeData = viewModel.episodesData)
                //}
            }
           // Episodes(episodeData = viewModel.episodesData)

        }
        viewModel.getSeries()
    }
}

@Composable
fun Episodes(episodeData: LiveData<List<Episode>>){
    val episodes by episodeData.observeAsState(emptyList())
    //AdapterList(data = episodes)

    LazyColumn {
        items(episodes){
            episode -> EpisodeItem(episode = episode)

        }
    }
    /*LazyColumn(

    ) {
        items(episodes) { item ->

        }*/
}

@Composable
fun EpisodeItem(episode:Episode){
    Row {
        Text(text = episode.title)
        /*Column (
            modifier = Modifier.padding(16.dp, 8.dp)
        ){
            val imageModifier = Modifier
                //.preferredHeightIn(maxHeight = 60.dp)
                .clip(shape = RoundedCornerShape(4.dp))

            //TODO utilizar o Coil depois
           // GlideImage(url = episode.posterUrl, imageModifier = imageModifier)
        }
        Column (
            modifier = Modifier.padding(0.dp, 8.dp)
        ){
            Text(text = episode.title)

        }*/
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExemploMVVMLiveDataCoroutinesRetrofitTheme {
        Greeting("Android")
    }
}