package com.expleo.contactdemo

import com.expleo.contactdemo.model.Contact
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ContactTest {

    private fun getSingleContact() : Contact {

        var contact : Contact? = null
//        contact.name = "Jayant Tiwari"
//        contact.number = "+19867608869"
//        contact.email = "jayjt1@yahoo.in"

      //  contactList.add(contact)
        return contact!!
    }

    private fun getAllContact() : ArrayList<Contact> {

        var contactLists = ArrayList<Contact>()

        var contact1  = Contact()
        contact1.name = "Jayant Tiwari"
        contact1.number = "+19867608869"
        contact1.email = "amitt.jt@gmail.com"

        var contact2  = Contact()
        contact2.name = "Gowtham Nallasivam"
        contact2.number = "+19896797979"
        contact2.email = "amitt.jt@gmail.com"

        contactLists.add(contact1)
        contactLists.add(contact2)

        return contactLists
    }

    @Test
    fun testSingleContact() {

        var contactList = getSingleContact()

        var contactValidator = ContactValidator()
        var validateContact = contactValidator.validateContact(contactList)

        var mobileNumber = contactList.number!!
        var validateMobile = contactValidator.validateMobileNumber(mobileNumber)

        var name = contactList.name!!
        var validateName = contactValidator.validateName(name)

        var email = contactList.email!!
        var validateEmail = contactValidator.validateEmail(email)

       // assertEquals(validateSize, true)
        assertNotNull(validateContact)
        assertEquals(validateMobile, true)
        assertEquals(validateName, true)
        assertEquals(validateEmail, true)
    }

    @Test
    fun testAllContacts() {

        var contactLists = getAllContact()

        var contactValidator = ContactValidator()
        var validateSize = contactValidator.validateAllContactLists(contactLists)

        var mobileNumber = contactLists[1].number!!
        var validateMobile = contactValidator.validateMobileNumber(mobileNumber)

        var name = contactLists[1].name!!
        var validateName = contactValidator.validateName(name)

        var email = contactLists[1].email!!
        var validateEmail = contactValidator.validateEmail(email)

        assertEquals(validateSize, true)
        assertEquals(validateMobile, true)
        assertEquals(validateName, true)
        assertEquals(validateEmail, true)

    }

}