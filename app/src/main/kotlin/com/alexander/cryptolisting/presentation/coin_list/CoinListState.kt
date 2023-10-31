package com.alexander.cryptolisting.presentation.coin_list

import com.alexander.cryptolisting.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
