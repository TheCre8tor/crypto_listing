package com.alexander.cryptolisting.domain.model

import com.alexander.cryptolisting.data.remote.dto.coin_detail_dto.TeamMember

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
