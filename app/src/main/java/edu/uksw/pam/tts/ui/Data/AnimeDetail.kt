package edu.uksw.pam.tts.ui.Data

import java.io.Serializable
data class AnimeDetail(
    val id: Int,
    val title: String,
    val AnimeImageId: Int = 0,
    val Season: String,
    val Status: String,
    val totalEpisode: String,
    val AnimeDesc: String
):Serializable
