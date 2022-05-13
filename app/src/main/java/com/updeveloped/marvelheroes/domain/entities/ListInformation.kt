package com.updeveloped.marvelheroes.domain.entities

data class ListInformation(
    var count: Int? = null,
    var limit: Int? = null,
    var offset: Int? = null,
    var results: List<CharacterDetail>? = null,
    var total: Int? = null
)
