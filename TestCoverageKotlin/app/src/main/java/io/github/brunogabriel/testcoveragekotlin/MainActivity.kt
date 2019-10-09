package io.github.brunogabriel.testcoveragekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import io.github.brunogabriel.testcoveragekotlin.validator.LoginValidator
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by brunogabriel on 2019-10-09.
 */
class MainActivity : AppCompatActivity(), MainContract.View {
    override lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this, LoginValidator())
        setupView()
    }

    override fun showLoginSuccess() {
        showMessage(R.string.login_success)
    }

    override fun showLoginFail() {
        showMessage(R.string.login_fail)
    }

    private fun showMessage(@StringRes messageRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(messageRes)
            .setPositiveButton(android.R.string.ok, null)
            .show()
    }

    private fun setupView() {
        setSupportActionBar(toolbar)
        login_button.setOnClickListener {
            presenter.onLoginClicked(
                username_edit_text.text.toString(),
                password_edit_text.text.toString()
            )
        }
    }
}
