package edu.uksw.pam.tts.Data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.pam.tts.R

@Composable
fun AnimeSearchItem(anime: AnimeDetail)
{
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)
            .height(150.dp)
            .width(110.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(11, 175, 198).copy(alpha = 0.4f))
    ) {
        AnimeImage(anime = anime)
        Text(
            text = anime.title,
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}



@Composable
private fun AnimeImage (anime: AnimeDetail)
{
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(5.dp)),
        painter = painterResource(id = anime.AnimeImageId),
        contentDescription = "On Going",
        contentScale = ContentScale.Crop)
}