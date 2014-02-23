class Person {

    Long id
    String firstname
    String lastname

    Person(Long id, String firstname, String lastname) {
        this.id = id
        this.firstname = firstname
        this.lastname = lastname
    }

    String toString() {
        "[$id] Me llamo $firstname y me apellido $lastname"
    }

}