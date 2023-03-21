package edu.uksw.pam.tts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import androidx.activity.compose.setContent
import edu.uksw.pam.tts.Data.AnimeDetail
import edu.uksw.pam.tts.ui.screens.AnimeProfileScreen
import edu.uksw.pam.tts.ui.theme.TTSTheme

class AnimeProfileActivity : AppCompatActivity() {

    private val anime: AnimeDetail by lazy {
        intent?.getSerializableExtra(ANIME_ID) as AnimeDetail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TTSTheme() {
                AnimeProfileScreen(anime = anime)
            }
        }
    }

    companion object {
        private const val ANIME_ID = "anime_id"
        fun newIntent(context: Context, anime: AnimeDetail) =
            Intent(context, AnimeProfileActivity::class.java).apply {
                putExtra(ANIME_ID, anime)
            }
    }
}