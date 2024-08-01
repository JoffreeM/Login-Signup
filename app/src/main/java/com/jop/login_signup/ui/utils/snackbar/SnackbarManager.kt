package com.jop.login_signup.ui.utils.snackbar

import com.jop.login_signup.App
import com.jop.login_signup.R
import com.jop.login_signup.ui.navigation.Params
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object SnackbarManager {
    private val snackbarChannel = Channel<String>()
    val snackbarEvents = snackbarChannel.receiveAsFlow()

    fun showSnackbar(ico:IcoSnackbar, message: String) {
        snackbarChannel.trySend(message).isSuccess
        App.navigation[Params.ICO_SNACKBAR]=ico
    }

    fun getIco(icoSnackbar: IcoSnackbar): Int {
        return when (icoSnackbar) {
            IcoSnackbar.CORRECT -> R.drawable.ic_correct_toast
            IcoSnackbar.WARNING -> R.drawable.ic_warning_toast
            IcoSnackbar.ERROR -> R.drawable.ic_error_toast
        }
    }
}