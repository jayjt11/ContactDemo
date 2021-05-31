package com.expleo.contactdemo

object Validator {

    fun validateInput(number:Int) : Boolean {

        if (number >= 0) {
            return true
        } else {
            return false
        }
    }
}