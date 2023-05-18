fun main(args: Array<String>) {
    val myPhone = MobilePhone("1234")
    val contact1 = Contact("Вася", "123456789")
    val contact2 = Contact("Петя", "987654321")
    myPhone.addNewContact(contact1)
    myPhone.addNewContact(contact2)
    myPhone.updateContact(contact2, Contact("Коля", "77777777"))
    myPhone.printContacts()
    myPhone.removeContact(contact1)
    myPhone.printContacts()
}