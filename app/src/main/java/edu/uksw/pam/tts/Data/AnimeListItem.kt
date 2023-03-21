package edu.uksw.pam.tts.Data

import androidx.compose.ui.Modifier
//import edu.uksw.pam.tts.ui.screens.Card
import android.security.identity.AccessControlProfile
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.Card
import androidx.compose.ui.graphics.Color


@Composable
fun AnimeListItem(anime: AnimeDetail, navigateToProfile: (AnimeDetail) -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 5.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = Color(11, 175, 198).copy(alpha = 0.4f)
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row( Modifier.clickable { navigateToProfile(anime) }) {
                AnimeImage(anime = anime)
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = anime.title, modifier = Modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.h6
                    )
                    Text(text = "Rate 4/5", style = MaterialTheme.typography.caption)
                }
            }
        }


    }
}

@Composable
private fun AnimeImage (anime: AnimeDetail)
{
    Image(
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(16.dp)),
        painter = painterResource(id = anime.AnimeImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop)
}