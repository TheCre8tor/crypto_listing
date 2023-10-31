package com.alexander.cryptolisting.presentation.coin_list

import androidx.lifecycle.ViewModel
import com.alexander.cryptolisting.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel()