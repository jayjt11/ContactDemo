package com.expleo.contactdemo

import com.expleo.contactdemo.model.Contact
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest {

    @Test
    fun getAllContactList() {

        var dummyArrayList = ArrayList<Contact>()

        var contact1 = Contact()
        contact1.name = "Senthil"
        contact1.number = "9878787878"
        dummyArrayList.add(contact1)

        var contact2 = Contact()
        contact2.name = "Dhayalu"
        contact2.number = "9878787878"
        dummyArrayList.add(contact2)

        var contact3 = Contact()
        contact3.name = "Gowtham"
        contact3.number = "9878787878"
        dummyArrayList.add(contact3)

        var dummyArrayList1 = dummyArrayList

        var activtiy = MainActivity()
        var resultLists = activtiy.getAllContactsList()

        assertTrue(resultLists.size > 0)
        assertEquals(dummyArrayList1,dummyArrayList)
       // assertArrayEquals(resultLists, dummyArrayList)

    }

    @Test
    fun getSingleContactList() {

        var activtiy = MainActivity()
        var resultLists = activtiy.getSingleContactList()

        var number = resultLists[0].number

        assertTrue(resultLists.size > 0)
        assertEquals(number!!.length , 10)


    }

}