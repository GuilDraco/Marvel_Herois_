package com.updeveloped.marvelheroes.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.updeveloped.marvelheroes.core.API_KEY_PUBLICA
import com.updeveloped.marvelheroes.core.HASH
import com.updeveloped.marvelheroes.helper.getMd5Digest
import com.updeveloped.marvelheroes.domain.entities.CharacterDetail
import com.updeveloped.marvelheroes.data.service.MarvelService

class PageDataSource(private val marvelService: MarvelService) : PagingSource<Int, CharacterDetail>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDetail> {
        try {
            val timestamp = System.currentTimeMillis().toInt()
            val md5Hash = "$timestamp$HASH$API_KEY_PUBLICA".getMd5Digest()

            val currentLoadingPageKey = params.key ?: 5
            val response = marvelService.getCharacters(timeStamp = timestamp, hashMd5 = md5Hash,
                offset = currentLoadingPageKey, limit = 20).toEntity()

            val responseData = mutableListOf<CharacterDetail>()

            val data = response.results ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == ITEM_PER_PAGE) null else currentLoadingPageKey - ITEM_PER_PAGE

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(ITEM_PER_PAGE)
            )
        }catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDetail>): Int? {
        TODO("Not yet implemented")
    }

    companion object{
        private const val ITEM_PER_PAGE = 20
    }
}