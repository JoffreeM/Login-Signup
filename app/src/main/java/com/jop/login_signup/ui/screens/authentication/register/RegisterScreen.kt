package com.jop.login_signup.ui.screens.authentication.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jop.login_signup.R
import com.jop.login_signup.ui.composables.BackgroundDesign
import com.jop.login_signup.ui.composables.CustomButton
import com.jop.login_signup.ui.composables.CustomInput
import com.jop.login_signup.ui.composables.CustomSpace
import com.jop.login_signup.ui.composables.CustomToolBar
import com.jop.login_signup.ui.screens.authentication.composable.TitleAuth
import com.jop.login_signup.ui.screens.authentication.composable.TitleButtom

@Composable
fun RegisterScreen(
    navController: NavController
){
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    CustomToolBar(
        navController = navController,
        showToolBar = false,
        backgroundDesign = {
            BackgroundDesign()
        }
    ){
        CustomSpace(height = 230)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center
        ) {
            TitleAuth(title = R.string.title_register)
            CustomInput(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.label_email,
                placeholder = R.string.placeholder_email,
                value = "",
                onValueChange = {

                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_email), contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
            )
            CustomInput(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.label_phone,
                placeholder = R.string.placeholder_phone,
                value = "",
                onValueChange = {

                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_phone), contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Phone
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
            )
            CustomInput(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.label_password,
                placeholder = R.string.placeholder_password,
                value = "",
                onValueChange = {

                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_password), contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(
                                id = if (isPasswordVisible)
                                    R.drawable.ic_visibility_on_pass
                                else
                                    R.drawable.ic_visibility_off_pass
                            ),
                            contentDescription = null
                        )
                    }
                },
                visualTransformation =
                if (isPasswordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
            )
            CustomInput(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.label_password_confirmation,
                placeholder = R.string.placeholder_password_confirmation,
                value = "",
                onValueChange = {

                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_password), contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(
                                id = if (isPasswordVisible)
                                    R.drawable.ic_visibility_on_pass
                                else
                                    R.drawable.ic_visibility_off_pass
                            ),
                            contentDescription = null
                        )
                    }
                },
                visualTransformation =
                if (isPasswordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
            )
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .padding(horizontal = 10.dp),
                onClick = {},
                text = R.string.create_account
            )
            CustomSpace(height = 25)
            TitleButtom(
                text = R.string.have_an_account,
                textClick = R.string.get_into,
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}