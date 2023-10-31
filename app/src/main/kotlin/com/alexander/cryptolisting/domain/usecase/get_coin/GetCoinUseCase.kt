package com.alexander.cryptolisting.domain.usecase.get_coin

import com.alexander.cryptolisting.common.Resource
import com.alexander.cryptolisting.data.remote.dto.toCoin
import com.alexander.cryptolisting.domain.model.Coin
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
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coins = repository.getCoins().map { it.toCoin() }
                emit(Resource.Success(coins))
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