//package edu.uksw.pam.tts
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.activity.compose.setContent
//import androidx.compose.material.Surface
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import edu.uksw.pam.tts.models.AnimeTrendViewModel
//import edu.uksw.pam.tts.ui.screens.BottomNavigationMainScreenView
//import edu.uksw.pam.tts.ui.screens.ProfileScreen
////import edu.uksw.pam.tts.ui.screens.ProfileScreenPreview
//import edu.uksw.pam.tts.ui.theme.TTSTheme
//
//class ProfileActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            TTSTheme {
//                val avm = AnimeTrendViewModel()
//
//                val navController = BottomNavigationMainScreenView()
//
//                // A surface container using the 'background' color from the theme
//                Surface(
//                ) {
//                    ProfileScreen(avm, NavController())
//                }
//            }
//        }
//    }
//}