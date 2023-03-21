package edu.uksw.pam.tts.ui.screens

import android.content.Context
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.pam.tts.HomeActivity
import edu.uksw.pam.tts.R
import edu.uksw.pam.tts.SignUpActivity
import edu.uksw.pam.tts.contract.SignUpContract

internal fun doAuth(
    email: String,
    password: String,
): Boolean {
    return (password.equals("admin"))
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    val getEmailFromSignUpForm = rememberLauncherForActivityResult(
        contract = SignUpContract(),
        onResult = { emailInput = it!! }
    )



    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) { //untuk menyesuaikan thema yang dipakai di hp
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(29, 196, 206).copy(alpha = 1f))
        ) {
            Column(
                modifier = Modifier
                    //.align(Alignment.Center)
                    //.padding(horizontal = 32.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "N G A N I M E K",
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 15.dp, top = 80.dp)
                )
                Image(painter = painterResource(id = R.drawable.iconn), contentDescription ="", modifier = Modifier
                    .size(180.dp)
                    .padding(bottom = 10.dp))

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .fillMaxWidth()
                        .height(700.dp)
                        .background(Color.White),
                    //backgroundColor = MaterialTheme.colors.surface,
                    //elevation = 4.dp
                ) {
                    Row(horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 20.dp)
                    ) {
                        Text(
                            text = "LOGIN",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(29, 196, 206),
                            modifier = Modifier.padding(top = 15.dp)
                        )
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        OutlinedTextField( // untuk membuat outline
                            value = emailInput.toString(),
                            onValueChange = { emailInput = it },
                            label = { Text(text = stringResource(R.string.Email)) },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(29, 196, 206),
                                unfocusedBorderColor = Color.Black,
                                focusedLabelColor = Color(29, 196, 206)
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email, //untuk menampilkan icon email yang berada dalam textfield
                                    contentDescription = "Email address"
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),//untuk menunjukkan jenis keyboard yang digunakan user
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = passwordInput.toString(),
                            onValueChange = { passwordInput = it },
                            label = { Text(text = stringResource(R.string.Passwords)) },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(29, 196, 206),
                                unfocusedBorderColor = Color.Black,
                                focusedLabelColor = Color(29, 196, 206)
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = "Password"
                                )
                            },
                            //membuat inputan password tersembunyi
                            visualTransformation = PasswordVisualTransformation(),
                            //membuat inputan keyboard menjadi inputan password
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            modifier = Modifier.fillMaxWidth(),
                        )

                        Column(
                            modifier = Modifier
                                .padding(top = 20.dp, bottom = 5.dp)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Button(
                                onClick = {
                                    val isAuthenticated = doAuth(emailInput, passwordInput)
                                    if (isAuthenticated) {
                                        context.startActivity(
                                            Intent(context, HomeActivity::class.java)
                                                .apply {
                                                    putExtra("email", emailInput)
                                                }
                                        )
                                    }
                                },
                                modifier = Modifier
                                    .width(140.dp),
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(29, 196, 206)
                                ),
                            ) {
                                Text(
                                    text = stringResource(R.string.Login),
                                    color = Color.White,
                                    fontSize = 20.sp
                                )
                            }
                        }
                        Row(horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            TextButton(
                                onClick = {
                                    getEmailFromSignUpForm.launch("")
                                },
                            ) {
                                Text(text = stringResource(R.string.dnthvacc), color = Color(29, 196, 206))
                            }

                        }

                    }
                }
            }
            }
        }
}


//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}