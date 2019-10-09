package io.github.brunogabriel.testcoveragekotlin

/**
 * Created by brunogabriel on 2019-10-09.
 */
interface MainContract {
    interface View : BaseView<Presenter> {
        fun showLoginSuccess()
        fun showLoginFail()
    }

    interface Presenter {
        fun onLoginClicked(username: String, password: String)
    }
}