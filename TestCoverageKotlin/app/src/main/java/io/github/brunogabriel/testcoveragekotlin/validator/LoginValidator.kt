package io.github.brunogabriel.testcoveragekotlin.validator

import io.github.brunogabriel.testcoveragekotlin.model.UserLogin

/**
 * Created by brunogabriel on 2019-10-09.
 */
class LoginValidator : Validator<UserLogin> {
    companion object {
        private const val MIN_SIZE = 6
    }

    override fun validate(entity: UserLogin): Boolean {
        return entity.username.length >= MIN_SIZE && entity.password.length >= MIN_SIZE
    }
}