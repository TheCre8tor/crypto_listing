package com.alexander.cryptolisting.data.repository

import com.alexander.cryptolisting.data.remote.dto.CoinDTO
import com.alexander.cryptolisting.data.remote.dto.coin_detail_dto.CoinDetailDTO
import com.alexander.cryptolisting.data.remote.https.CoinPaprikaAPI
import com.alexander.cryptolisting.domain.repository.CoinRepository

import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}