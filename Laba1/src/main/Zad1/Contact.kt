class Contact(val name: String, val phoneNumber: String) {

    override fun toString(): String {
        return "Имя: " + name + ", Номер:" + phoneNumber
    }
}