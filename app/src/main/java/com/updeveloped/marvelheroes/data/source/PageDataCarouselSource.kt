package com.updeveloped.marvelheroes.data.source

import com.updeveloped.marvelheroes.core.API_KEY_PUBLICA
import com.updeveloped.marvelheroes.core.HASH
import com.updeveloped.marvelheroes.helper.getMd5Digest
import com.updeveloped.marvelheroes.domain.entities.CharacterDetail
import com.updeveloped.marvelheroes.data.service.MarvelService

class PageDataCarouselSource(private val marvelService: MarvelService) {
    suspend fun load(): List<CharacterDetail> {
        val timestamp = System.currentTimeMillis().toInt()
        val md5Hash = "$timestamp$HASH$API_KEY_PUBLICA".getMd5Digest()

        val response = marvelService.getCharacters(timeStamp = timestamp, hashMd5 = md5Hash, limit = 5).toEntity()
        return response.results!!
    }
}
