package io.github.brunogabriel.testcoveragekotlin

import io.github.brunogabriel.testcoveragekotlin.model.UserLogin
import io.github.brunogabriel.testcoveragekotlin.validator.LoginValidator

/**
 * Created by brunogabriel on 2019-10-09.
 */
class MainPresenter(
    private val view: MainContract.View,
    private val validator: LoginValidator
) : MainContract.Presenter {

    override fun onLoginClicked(username: String, password: String) {
        if (validator.validate(UserLogin(username, password))) {
            view.showLoginSuccess()
        } else {
            view.showLoginFail()
        }
    }
}