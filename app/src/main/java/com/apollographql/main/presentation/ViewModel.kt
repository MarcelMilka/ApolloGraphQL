package com.apollographql.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.main.buisness.PreviewedCountry
import com.apollographql.main.data.CountriesAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(client: CountriesAPI): ViewModel() {

    private var _data = MutableStateFlow<List<PreviewedCountry>?>(null)
    val data = _data.asStateFlow()

    init {

        viewModelScope.launch {

            _data.emit(

                value = client.getPreviewsOfCountries()
            )
        }
    }
}