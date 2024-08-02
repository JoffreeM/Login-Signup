package com.jop.login_signup.ui.viewmodel

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import com.jop.login_signup.App
import com.jop.login_signup.ui.utils.snackbar.IcoSnackbar
import com.jop.login_signup.ui.utils.snackbar.SnackbarManager
import com.jop.login_signup.ui.viewstate.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var _viewState: MutableStateFlow<ViewState>
    protected lateinit var viewState: StateFlow<ViewState>

    protected fun initViewState(state: ViewState) {
        _viewState = MutableStateFlow(state)
        viewState = _viewState.asStateFlow()
    }

    protected fun updateViewState(newViewState: ViewState) {
        _viewState.update { newViewState }
    }

    protected fun <T> currentViewState(): T = _viewState.value as T

    fun <T> getState() = viewState as StateFlow<T>

    protected fun showSnackbar(icoSnackbar: IcoSnackbar, message: String) {
        SnackbarManager.showSnackbar(icoSnackbar,message)
    }

    protected fun getString(@StringRes resId: Int): String {
        return App.appContext.getString(resId)
    }
}