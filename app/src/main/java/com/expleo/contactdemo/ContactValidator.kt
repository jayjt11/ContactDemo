package com.expleo.contactdemo

import android.util.Patterns
import com.expleo.contactdemo.model.Contact
import java.util.regex.Pattern


class ContactValidator {

    fun validateSingleContactList(arrayContact: ArrayList<Contact>) : Boolean {
        return (arrayContact.size == 1)
    }
    fun validateAllContactLists(arrayContact: ArrayList<Contact>) : Boolean {
        return (arrayContact.size > 0)
    }

    fun validateMobileNumber(number : String) : Boolean {
        return ((number.length > 9 && number.length <= 15) && number.startsWith("+1"))
    }

    fun validateName(name : String) : Boolean {
        return ((!name.isEmpty() ||  name != null))
    }

    fun validateEmail(email : String) : Boolean {
        var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return (email.matches(emailPattern.toRegex()))
    }

}