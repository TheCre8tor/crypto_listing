package com.alexander.cryptolisting.presentation.coin_detail

import com.alexander.cryptolisting.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
