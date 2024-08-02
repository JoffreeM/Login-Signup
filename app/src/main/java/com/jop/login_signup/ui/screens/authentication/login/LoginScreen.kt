package com.jop.login_signup.ui.screens.authentication.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jop.login_signup.R
import com.jop.login_signup.ui.composables.BackgroundDesign
import com.jop.login_signup.ui.composables.CustomButton
import com.jop.login_signup.ui.composables.CustomInput
import com.jop.login_signup.ui.composables.CustomSpace
import com.jop.login_signup.ui.composables.CustomText
import com.jop.login_signup.ui.composables.CustomToolBar
import com.jop.login_signup.ui.navigation.Screens
import com.jop.login_signup.ui.screens.authentication.composable.TitleAuth
import com.jop.login_signup.ui.screens.authentication.composable.TitleButtom
import com.jop.login_signup.ui.screens.authentication.login.view.event.LoginViewEvent
import com.jop.login_signup.ui.screens.authentication.login.view.model.LoginViewModel
import com.jop.login_signup.ui.screens.authentication.login.view.state.LoginViewState

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
){
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val state by viewModel.getState<LoginViewState>().collectAsState()
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(key1 = state.isSuccess) {
        if (state.isSuccess) {
            viewModel.updateSuccessClean()
            navController.navigate(Screens.REGISTER)
        }
    }
    CustomToolBar(
        navController = navController,
        showToolBar = false,
        backgroundDesign = {
            BackgroundDesign()
        }
    ){
        CustomSpace(height = 130)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center
        ) {
            TitleAuth(title = R.string.title_login)
            CustomInput(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.label_email,
                placeholder = R.string.placeholder_email,
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(LoginViewEvent.OnEmail(it))
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
                supportingText = state.emailError,
                isError = state.emailError != null
            )
            CustomInput(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.label_password,
                placeholder = R.string.placeholder_password,
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(LoginViewEvent.OnPassword(it))
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
                supportingText = state.passwordError,
                isError = state.passwordError != null
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(
                        checked = state.remember,
                        onCheckedChange = {
                            viewModel.onEvent(LoginViewEvent.OnRemember(it))
                        }
                    )
                    CustomText(text = R.string.remember)
                }
                CustomText(
                    modifier = Modifier.clickable {
                        viewModel.onEvent(LoginViewEvent.ForgotPassword)
                    },
                    text = R.string.forgotten_password,
                    textColor = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                )
            }
            CustomSpace(height = 25)
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .padding(horizontal = 10.dp),
                onClick = {
                    viewModel.onEvent(LoginViewEvent.Login)
                },
                text = R.string.get_into
            )
            CustomSpace(height = 25)
            TitleButtom(
                text = R.string.not_account,
                textClick = R.string.register,
                onClick = {
                    navController.navigate(Screens.REGISTER)
                }
            )
        }
    }
}