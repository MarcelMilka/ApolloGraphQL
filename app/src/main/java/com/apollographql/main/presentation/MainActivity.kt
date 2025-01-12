package com.apollographql.main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apollographql.main.buisness.PreviewedCountry
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val data by viewModel.data.collectAsState()

            Column(

                modifier = Modifier,

                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,

                content = {

                    if (data != null) {

                        LazyColumn(

                            modifier = Modifier.fillMaxSize(),

                            content = {

                                this.items(data as List<PreviewedCountry>) {

                                    Button(

                                        onClick = {},

                                        content = {

                                            Text(it.name)
                                        }
                                    )

                                    Spacer(Modifier.height(10.dp))
                                }
                            }
                        )
                    }

                    else {

                        Text("Loading")
                    }
                }
            )
        }
    }
}