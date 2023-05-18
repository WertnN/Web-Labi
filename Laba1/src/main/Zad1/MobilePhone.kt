import kotlin.collections.ArrayList
import kotlin.collections.Iterator

class MobilePhone(private val myNumber: String) {
    private val myContacts: ArrayList<Contact>

    init {
        myContacts = ArrayList<Contact>()
    }

    fun addNewContact(contact: Contact): Boolean {
        if (findContact(contact) >= 0) {
            kotlin.io.println("Контакт уже существует")
            return false
        }
        myContacts.add(contact)
        kotlin.io.println("Контакт успешно создан")
        return true
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val foundPosition: Int = findContact(oldContact)
        if (foundPosition < 0) {
            println(oldContact.toString() + ", такой контакт не существует")
            return false
        }
        myContacts[foundPosition] = newContact
        println(oldContact.toString() + " был успешно обновлен на " + newContact.toString())
        return true
    }

    fun removeContact(contact: Contact): Boolean {
        val foundPosition: Int = findContact(contact)
        if (foundPosition < 0) {
            kotlin.io.println(contact.toString() + ", такой контакт не существует")
            return false
        }
        myContacts.removeAt(foundPosition)
        kotlin.io.println(contact.toString() + " был успешно удален")
        return true
    }

    private fun findContact(contact: Contact): Int {
        return myContacts.indexOf(contact)
    }

    private fun findContact(contactName: String): Int {
        for (i in myContacts.indices) {
            val contact: Contact = myContacts[i]
            if (contact.toString().equals(contactName)) {
                return i
            }
        }
        return -1
    }

    fun queryContact(name: String?): Contact? {
        val position = findContact(name.toString())
        return if (position >= 0) {
            myContacts[position]
        } else null
    }

    fun printContacts() {
        kotlin.io.println("Список контактов: ")
        val iterator: Iterator<Contact> = myContacts.iterator()
        while (iterator.hasNext()) {
            System.out.println(iterator.next())
        }
    }
}