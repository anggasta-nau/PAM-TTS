package edu.uksw.pam.tts.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.pam.tts.HomeActivity
import edu.uksw.pam.tts.MainActivity
import edu.uksw.pam.tts.R
import edu.uksw.pam.tts.SignUpActivity
import edu.uksw.pam.tts.ui.Data.storedUsename
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen( btnOnClickAction: (String?) -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = storedUsename(context)
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(29, 196, 206)
            )
    ) {
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        ) {
            Text(
                text = "N G A N I M E K",
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
            )
        }
        Card(
            modifier = Modifier
                .padding(top = 200.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .fillMaxWidth()
                .height(900.dp)
                .align(Alignment.Center),
            backgroundColor = MaterialTheme.colors.surface,
        ) {
            Column() {
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = "REGISTER",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(29, 196, 206),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                    OutlinedTextField(
                        value = firstName.toString(),
                        onValueChange = { firstName = it },
                        label = { Text(text = stringResource(R.string.FName)) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(29, 196, 206),
                            unfocusedBorderColor = Color.Black,
                            focusedLabelColor = Color(29, 196, 206)
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "First Name",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )
                    OutlinedTextField(
                        value = lastName.toString(),
                        onValueChange = { lastName = it },
                        label = { Text(text = stringResource(R.string.LName)) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(29, 196, 206),
                            unfocusedBorderColor = Color.Black,
                            focusedLabelColor = Color(29, 196, 206)
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    )
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)) {
                    OutlinedTextField(
                        value = emailInput.toString(),
                        onValueChange = { emailInput = it },
                        label = { Text(text = "Email") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(29, 196, 206),
                            unfocusedBorderColor = Color.Black,
                            focusedLabelColor = Color(29, 196, 206)
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = passwordInput.toString(),
                        onValueChange = { passwordInput = it },
                        label = { Text(text = stringResource(R.string.Password)) },
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
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = confirmPassword.toString(),
                        onValueChange = { confirmPassword = it },
                        label = { Text(text = stringResource(R.string.CPaswoord)) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(29, 196, 206),
                            unfocusedBorderColor = Color.Black,
                            focusedLabelColor = Color(29, 196, 206)
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Confirm Password"
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 15.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Button(
                    onClick = {
                        scope.launch {
                            dataStore.saveFirstName(firstName)
                            dataStore.saveLastName(lastName)
                        }
                        btnOnClickAction(emailInput)
                    },
                    modifier = Modifier
                        .width(140.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(29, 196, 206)),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = stringResource(R.string.SignUp),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

                }
                TextButton(
                    onClick = {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.alrdyhvacc),
                        color = Color(29, 196, 206),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SignUpScreenPreview() {
//    SignUpScreen()
//}