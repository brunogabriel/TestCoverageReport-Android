package io.github.brunogabriel.testcoveragekotlin.validator

/**
 * Created by brunogabriel on 2019-10-09.
 */
interface Validator<T> {
    fun validate(entity: T): Boolean
}