package com.jerimkaura.got.domain.usecase

import com.jerimkaura.got.data.local.entities.Continent
import com.jerimkaura.got.domain.repository.ContinentsRepository
import com.jerimkaura.got.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContinentsUseCase @Inject constructor(private val repository: ContinentsRepository){

}