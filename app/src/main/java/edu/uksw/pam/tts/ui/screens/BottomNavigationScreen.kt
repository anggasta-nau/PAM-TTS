package edu.uksw.pam.tts.ui.screens
import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.uksw.pam.tts.AnimeProfileActivity
import edu.uksw.pam.tts.models.AnimeActionViewModel
import edu.uksw.pam.tts.models.AnimeTrendViewModel
import edu.uksw.pam.tts.models.AnimeViewModel
import edu.uksw.pam.tts.ui.ButtonNavItem

@Composable
fun NavigationGraph(
    navController: NavHostController,
    vm1: AnimeViewModel = AnimeViewModel(),
    vm2: AnimeTrendViewModel = AnimeTrendViewModel(),
    vm3: AnimeActionViewModel = AnimeActionViewModel()
) {
    val lContext = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = ButtonNavItem.Home.screen_route
    ) {
        composable(ButtonNavItem.Home.screen_route) {
//            DefaultPreview()
//            LandingPage(avm = vm1)
            MainScreenView(avm = vm1, avm2 = vm2, navController = navController)
        }
        composable(ButtonNavItem.Search.screen_route) {
            MainScreenView(avm = vm1,avm2 = vm2, avm3 = vm3, navController = navController)
//            SearchScreen()
        }
        composable(ButtonNavItem.Trend.screen_route) {
            MainScreenView(avm = vm2, navController = navController)
//            TrendScreenPreview() {
//                    lContext.startActivity(AnimeProfileActivity.newIntent(lContext, it))
//            }
        }
        composable(ButtonNavItem.Profile.screen_route) {
            ProfileScreen(avm = vm2, navController = navController)
        }
        composable(
            route = "Detail" + "?id={id}?title={title}?imgUrl={imgUrl}?genre={genre}?Deskripsi={Deskripsi}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                    defaultValue = "Anime"
                    nullable = true
                },
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Anime"
                    nullable = true
                }
                ,
                navArgument("imgUrl") {
                    type = NavType.StringType
                    defaultValue = "Anime"
                    nullable = true
                },
                navArgument("genre") {
                    type = NavType.StringType
                    defaultValue = "Anime"
                    nullable = true
                },
                navArgument("Deskripsi") {
                    type = NavType.StringType
                    defaultValue = "Anime"
                    nullable = true
                }
            )
        ) { navBackStackEntry: NavBackStackEntry ->
            DetailScreen(
                id=navBackStackEntry.arguments?.getString("id") ,
                title = navBackStackEntry.arguments?.getString("title") ,
                imgUrl = navBackStackEntry.arguments?.getString("imgUrl") ,
                genre = navBackStackEntry.arguments?.getString("genre") ,
                Deskripsi = navBackStackEntry.arguments?.getString("Deskripsi")
            )
        }
    }
}

@Composable
fun BottomNavigation(
    navController: NavController
){
    val items = listOf(
        ButtonNavItem.Home,
        ButtonNavItem.Search,
        ButtonNavItem.Trend,
        ButtonNavItem.Profile
    )
    androidx.compose.material.BottomNavigation(
        //backgroundColor = colorResource(id = R.color.teal_200),
        backgroundColor = Color.White,
        contentColor = Color(3, 15, 40)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(
                    imageVector = item.icon,
                    contentDescription = "${item.title} icon")
                },
                label = {
                    Text(text = item.title,
                        fontSize = 9.sp)
                },
                selectedContentColor = Color.Blue.copy(0.7f),
                unselectedContentColor = Color.Blue.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationMainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {
        NavigationGraph(navController = navController)
    }
}