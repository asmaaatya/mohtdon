package com.example.data.dataSource.local
import com.example.domain.models.quran.PageData
import com.example.domain.models.quran.Aya
import com.example.domain.repo.QuranRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val quranDao: QuranDao
) : QuranRepository {

    override suspend fun getAyaBySubText(subAya: String): List<Aya> {
        return withContext(Dispatchers.IO) {
            quranDao.getAyaBySubText(subAya)
        }
    }

    override suspend fun getAyaId(ayaId: Int): String {
        return withContext(Dispatchers.IO){
            quranDao.getAyaById(ayaId)
        }
    }
   override suspend fun getSoraName(pageNum: Int): PageData {
        return withContext(Dispatchers.IO){
             quranDao.getSoraNameByPage(pageNum)
        }

    }
}