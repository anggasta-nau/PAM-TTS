package edu.uksw.pam.tts.ui.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import edu.uksw.pam.tts.models.AnimeViewModel
//import edu.uksw.pam.tts.ProfileActivity
import edu.uksw.pam.tts.R
import edu.uksw.pam.tts.models.AnimeModel
import edu.uksw.pam.tts.models.AnimeTrendModel
import edu.uksw.pam.tts.models.AnimeTrendViewModel
import edu.uksw.pam.tts.ui.theme.TTSTheme
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    val avm = AnimeViewModel()
//    TTSTheme {
//        MainScreenView(avm)
//    }
//}

@Composable
fun MainScreenView(
    avm: AnimeViewModel,
    avm2: AnimeTrendViewModel,
    navController: NavController
) {
//    val context = LocalContext.current
//    val scrollState = rememberScrollState()
    LaunchedEffect(
        Unit,
        block = {
            avm.getAnimeList()
            avm2.getAnimeTrendList()
        }
    )
    Column(
        modifier = Modifier
            .verticalScroll((rememberScrollState()))
            .height(1050.dp)) {
        Column{
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
            ){
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "N G A N I M E K",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(20.dp),
            ) {
                Card(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bofuri),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Bofuri: I Don't Want to Get Hurt",
                        fontWeight = FontWeight.W500,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(width = 30.dp, height = 30.dp)
                    )
                }
                Text(
                    text = "Fantasy / Action / Comedy",
                    fontWeight = FontWeight.W500,
                    color = Color.Gray,
                    fontFamily = FontFamily.SansSerif,
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                LazyVerticalGrid(columns = GridCells.Adaptive(90.dp),
                    content = {
                        items(1) {
                            Box(
                                modifier = Modifier
                                    .size(width = 30.dp, height = 50.dp)
                                    .padding(start = 10.dp)
                            )
                            {
                                Image(
                                    painterResource(id = R.drawable.square), "title",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)

                                )
                                Text(
                                    text = "Category", modifier = Modifier
                                        .padding(top = 30.dp)
                                        .padding(start = 20.dp), fontSize = 12.sp, color = Color.Gray
                                )
                            }
                        }
                        items(1) {
                            Box(
                                modifier = Modifier
                                    .size(width = 30.dp, height = 50.dp)
                                    .padding(start = 5.dp)
                            )
                            {
                                Image(
                                    painterResource(id = R.drawable.time), "title",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)
                                )
                                Text(
                                    text = "Release", modifier = Modifier
                                        .padding(top = 30.dp)
                                        .padding(start = 30.dp), fontSize = 12.sp, color = Color.Gray
                                )
                            }
                        }
                        items(1) {
                            Box(
                                modifier = Modifier
                                    .size(width = 30.dp, height = 50.dp)
                                    .padding(start = 5.dp)
                            )
                            {
                                Image(
                                    painterResource(id = R.drawable.medal), "title",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)
                                )
                                Text(
                                    text = "Top Hits", modifier = Modifier
                                        .padding(top = 30.dp)
                                        .padding(start = 27.dp), fontSize = 12.sp, color = Color.Gray
                                )
                            }
                        }
                        items(1) {
                            Box(
                                modifier = Modifier
                                    .size(width = 30.dp, height = 50.dp)
                                    .padding(start = 10.dp)
                            )
                            {
                                Image(
                                    painterResource(id = R.drawable.diamonds), "title",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)
                                )
                                Text(
                                    text = "Premium", modifier = Modifier
                                        .padding(top = 30.dp)
                                        .padding(start = 27.dp), fontSize = 12.sp, color = Color.Gray
                                )
                            }
                        }
                    })
            }
            Column() {
                Text(
                    text = "For You",
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 10.dp),
                    fontWeight = FontWeight.W500,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                )
                when {
                    avm.errorMessage.isEmpty() -> {
                        AvmList(avl = avm.animeList) {animeId,animeTitle,animeImgUrl, animeGenre, animeDeskripsi ->
                            Log.d("ClickItem", "this is anime id: $animeId")
                            navController.navigate("Detail?id=$animeId?title=$animeTitle?imgUrl=$animeImgUrl?genre=$animeGenre?Deskripsi=$animeDeskripsi")
                        }
                    }
                    else -> Log.e("AVM", "Something happened")
                }

                Text(
                    text = "Trend",
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 10.dp),
                    fontWeight = FontWeight.W500,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                )
                when {
                    avm.errorMessage.isEmpty() -> {
                        AvmTrendsList(avl = avm2.animeTrendList) { animeId, animeTitle, animeImgUrl, animeGenre, animeDeskripsi ->
                            Log.d("ClickItem", "this is anime id: $animeId")
                            navController.navigate("Detail?id=$animeId?title=$animeTitle?imgUrl=$animeImgUrl?genre=$animeGenre?Deskripsi=$animeDeskripsi")
                        }
                    }
                    else -> Log.e("AVM", "Something happened")
                }
            }
        }
    }
}

@Composable
fun AvmList(avl: List<AnimeModel>,itemClick: (index: Int, title: String, imgUrl: String, genre: String, Deskripsi:String)-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)


    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            state = rememberLazyListState()
        ) {
            itemsIndexed(avl) { index, item ->
                Card(
                    modifier = Modifier
                        .width(250.dp)
                        .height(150.dp)
                        .padding(5.dp)
                        .clickable {
                            itemClick(item.id, item.title, item.imgUrl, item.genre, item.Deskripsi)
                        },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(11, 175, 198).copy(alpha = 0.4f))
                            .padding(5.dp),

//                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = item.imgUrl,
                                builder = {
                                    scale(Scale.FILL)
//                                    placeholder(coil.base.R.drawable.notification_action_background)
//                                    transformations(CircleCropTransformation())
                                }
                            ),
                            contentDescription = item.Deskripsi,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                        )

                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxHeight()
                                //.background(Color(7, 133, 151, 255).copy(alpha = 0.4f))
                                .weight(0.8f),
                            verticalArrangement = Arrangement.Center
                        ) {
//                            Text(text = item.title)
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(4.dp)

                            )
                            Text(
                                text = item.genre,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .padding(4.dp)
                            )
                            Text(
                                text = item.Deskripsi,
                                style = MaterialTheme.typography.body1,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AvmTrendsList(avl: List<AnimeTrendModel>, itemClick: (index: Int, title: String, imgUrl: String, genre: String, Deskripsi:String)-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)


    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            state = rememberLazyListState()
        ) {
            itemsIndexed(avl) { index, item ->
                Card(
                    modifier = Modifier
                        .width(250.dp)
                        .height(150.dp)
                        .padding(5.dp)
                        .clickable {
                            itemClick(item.id, item.title, item.imgUrl, item.genre, item.Deskripsi)
                        },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(11, 175, 198).copy(alpha = 0.4f))
                            .padding(5.dp),

//                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = item.imgUrl,
                                builder = {
                                    scale(Scale.FILL)
//                                    placeholder(coil.base.R.drawable.notification_action_background)
//                                    transformations(CircleCropTransformation())
                                }
                            ),
                            contentDescription = item.Deskripsi,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                        )

                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxHeight()
                                //.background(Color(7, 133, 151, 255).copy(alpha = 0.4f))
                                .weight(0.8f),
                            verticalArrangement = Arrangement.Center
                        ) {
//                            Text(text = item.title)
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(4.dp)

                            )
                            Text(
                                text = item.genre,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .padding(4.dp)
                            )
                            Text(
                                text = item.Deskripsi,
                                style = MaterialTheme.typography.body1,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}