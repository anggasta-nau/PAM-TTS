package edu.uksw.pam.tts

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.pam.tts.SignUpActivity
//import edu.uksw.pam.tts.ui.screens.DefaultPreview
//import edu.uksw.pam.tts.ui.screens.HomeScreenPreview
import edu.uksw.pam.tts.ui.screens.LoginScreen
import edu.uksw.pam.tts.ui.screens.ProfileScreen
import edu.uksw.pam.tts.ui.theme.TTSTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContent {
            TTSTheme {
                // A surface container using the 'background' color from the theme
                Surface {
//                    ProfileScreen()
                    LoginScreen()
//                    DefaultPreview()
                }
            }
        }
    }
}
