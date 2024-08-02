package com.jop.login_signup.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jop.login_signup.ui.utils.snackbar.SnackbarAlign

@Composable
fun CustomToolBar(
    navController: NavController,
    showToolBar: Boolean = true,
    title: String = "",
    snackbarAlign: SnackbarAlign = SnackbarAlign.TOP_CENTER,
    backgroundDesign: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {}
){
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold (
        topBar = {
            if (showToolBar){
                TopBar(
                    navController = navController,
                    title = title
                )
            }
        },
        snackbarHost = {
            CustomSnackbar(snackbarHostState = snackbarHostState, snackbarAlign = snackbarAlign)
        }
    ){
        Box {
            backgroundDesign()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
            ) {
                content()
            }
        }
    }
}

@Composable
private fun TopBar(
    navController: NavController,
    title: String,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

    }
}