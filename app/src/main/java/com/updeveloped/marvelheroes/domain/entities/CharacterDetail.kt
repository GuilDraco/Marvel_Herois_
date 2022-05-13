package com.updeveloped.marvelheroes.domain.entities

data class CharacterDetail(
    var id: Int? = null,
    var name: String? = null,
    var description: String? = null,
    var modified: String? = null,
    var thumbnail: Thumbnail? = null
)
