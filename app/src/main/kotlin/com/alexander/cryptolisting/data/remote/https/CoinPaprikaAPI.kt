package com.alexander.cryptolisting.data.remote.https

import retrofit2.http.GET
import retrofit2.http.Path

import com.alexander.cryptolisting.data.remote.dto.CoinDTO
import com.alexander.cryptolisting.data.remote.dto.coin_detail_dto.CoinDetailDTO

interface CoinPaprikaAPI {
    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDTO
}