package com.alexander.cryptolisting.domain.usecase.get_coins

import com.alexander.cryptolisting.common.Resource
import com.alexander.cryptolisting.data.remote.dto.coin_detail_dto.toCoinDetail
import com.alexander.cryptolisting.domain.model.CoinDetail
import com.alexander.cryptolisting.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    @Override
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coin = repository.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success(coin))
            } catch (error: HttpException) {
                val message = error.localizedMessage ?: "An unexpected error occurred."
                emit(Resource.Error(message))
            } catch (error: IOException) {
                val message = "Couldn't reach server. Check your internet connection."
                emit(Resource.Error(message))
            }
        }
    }
}