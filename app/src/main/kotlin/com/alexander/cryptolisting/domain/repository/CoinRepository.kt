package com.alexander.cryptolisting.domain.repository

import com.alexander.cryptolisting.data.remote.dto.CoinDTO
import com.alexander.cryptolisting.data.remote.dto.coin_detail_dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinDTO>
    suspend fun getCoinById(): CoinDetailDTO
}