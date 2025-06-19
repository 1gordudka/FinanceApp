package com.finance.brief.data.remote.repository

import com.finance.brief.data.remote.results.ObtainRemoteAccountInfo

interface RemoteBriefFeatureRepository {

    suspend fun getAccountInfo(id: Int): ObtainRemoteAccountInfo
}