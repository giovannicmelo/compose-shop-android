package com.github.giovannicmelo.composeshop.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.components.*
import com.github.giovannicmelo.composeshop.ui.theme.ComposeShopTheme
import com.github.giovannicmelo.composeshop.ui.theme.Primary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterialApi
class LoginActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val emailState by viewModel.email.observeAsState()
            val passwordState by viewModel.password.observeAsState()
            val loginValid by viewModel.loginValid.observeAsState()

            ComposeLoginScreen(
                email = emailState ?: "",
                password = passwordState ?: "",
                isValidLogin = loginValid ?: false,
                onEmailChanged = { viewModel.email.postValue(it) },
                onPasswordChanged = { viewModel.password.postValue(it) }
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ComposeLoginScreen(
    email: String,
    password: String,
    isValidLogin: Boolean,
    onEmailChanged: (String) -> Unit = {},
    onPasswordChanged: (String) -> Unit = {},
) {
    ComposeShopTheme {
        Scaffold(topBar = { TopAppBarSimple() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column {
                    Headline1Text(text = stringResource(R.string.title_activity_login))
                    Spacer(modifier = Modifier.height(73.dp))
                    EmailTextField(email, onEmailChanged)
                    Spacer(modifier = Modifier.height(6.dp))
                    PasswordTextField(password, onPasswordChanged)
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            }
                    ) {
                        DescriptiveText(text = stringResource(R.string.forgot_password))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_round_arrow_right),
                            tint = Primary,
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryButton(label = stringResource(R.string.login), isEnabled = isValidLogin)
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    DescriptiveText(text = stringResource(R.string.login_social_account))
                    Spacer(modifier = Modifier.height(14.dp))
                    Row {
                        GoogleSocialMediaButton()
                        Spacer(modifier = Modifier.width(16.dp))
                        FacebookSocialMediaButton()
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview()
@Composable
fun LoginPreview() {
    ComposeLoginScreen(email = "test@email.com", password = "123456", isValidLogin = true)
}