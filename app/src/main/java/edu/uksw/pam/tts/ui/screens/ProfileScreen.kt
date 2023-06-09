package edu.uksw.pam.tts.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
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
import edu.uksw.pam.tts.R
import edu.uksw.pam.tts.models.AnimeTrendModel
import edu.uksw.pam.tts.models.AnimeTrendViewModel
import edu.uksw.pam.tts.ui.Data.storedUsename
import edu.uksw.pam.tts.ui.theme.TTSTheme


@Composable
fun ProfileScreen(
    avm: AnimeTrendViewModel,
    navController: NavController
){
    val context = LocalContext.current
    val dataStore = storedUsename(context)
    val savedFirstname = dataStore.getFirstName.collectAsState(initial = "")
    val savedLastname = dataStore.getLastName.collectAsState(initial="")
    LaunchedEffect(
        Unit,
        block = {
            avm.getAnimeTrendList()
        }
    )
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Profile",
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp
        )
        Image(
            painter = painterResource(id = R.drawable.kuroko) ,
            contentDescription = "Photo Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 50.dp)
                .size(140.dp)
                .clip(CircleShape)
        )
        Text(
            text = savedFirstname.value!! + " " + savedLastname.value!!,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 15.dp)
        )
        Text(
            text = "Wibu",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.LightGray,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 2.dp)
        )

    }

    Column(
        modifier = Modifier
            .padding(top = 315.dp)
            .height(800.dp)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .background(Color(192, 222, 228))
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 15.dp),
        ) {
            Text(
                text = "Overviews",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
//            Text(
//                text = "Anime List",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.SemiBold,
//                fontFamily = FontFamily.SansSerif,
//                color = Color.DarkGray.copy(0.7f),
//                modifier = Modifier.padding(start = 50.dp)
//            )
//            Text(
//                text = "Following",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.SemiBold,
//                fontFamily = FontFamily.SansSerif,
//                color = Color.DarkGray.copy(0.7f),
//                modifier = Modifier.padding(start = 56.dp)
//            )
        }

        Column {

            when {
                avm.errorMessage.isEmpty() -> {
                    AvmList(avl = avm.animeTrendList) { animeId, animeTitle, animeImgUrl, animeGenre, animeDeskripsi ->
                        Log.d("ClickItem", "this is anime id: $animeId")
                        navController.navigate("Detail?id=$animeId?title=$animeTitle?imgUrl=$animeImgUrl?genre=$animeGenre?Deskripsi=$animeDeskripsi")
                    }
                }
                else -> Log.e("AVM", "Something happened")
            }
        }
    }
}

@Composable
fun AvmProfileList(avl: List<AnimeTrendModel>,itemClick: (index: Int, title: String, imgUrl: String, genre: String, Deskripsi:String)-> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth(),
            state = rememberLazyListState()
        ) {
            itemsIndexed(avl) {index, item ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(5.dp)
                    .clickable {
                        itemClick(item.id, item.title, item.imgUrl, item.genre, item.Deskripsi)
                    },
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = item.imgUrl,
                                builder = {
//                                    scale(Scale.FILL)
//                                    placeholder(R.drawable.notification_action_background)
//                                    transformations(CircleCropTransformation())
                                }
                            ),
                            contentDescription = item.Deskripsi
                            ,
                            modifier = Modifier
                                .fillMaxHeight()
//                                .weight(0.2f)
                        )
                        Column(modifier = Modifier
                            .padding(4.dp)
                            .fillMaxHeight(),
//                            .weight(0.8f),
                            verticalArrangement = Arrangement.Center
                        ) {
//                            Text(text = item.title)
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = item.genre,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .background(
                                        Color.LightGray
                                    )
                                    .padding(4.dp)
                            )
                            Text(
                                text = item.Deskripsi,
                                style = MaterialTheme.typography.body1,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}


//@Composable
//@Preview
//fun ProfileScreenPreview() {
//    val avm = AnimeTrendViewModel()
//    TTSTheme() {
//        ProfileScreen(avm)
//
//    }
//}