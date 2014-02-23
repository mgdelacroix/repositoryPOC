import groovy.sql.Sql
import groovy.sql.DataSet

import Person

class PersonRepository {

    Sql db

    PersonRepository(String databaseName) {
        this.db = Sql.newInstance("jdbc:h2:$databaseName", 'sa', '')
    }

    void createPersonTable() {
        db.execute('''create table PERSON (
        id integer not null primary key auto_increment,
        firstname varchar(20),
        lastname varchar(20)
        )''')
    }

    void printPersonTable() {
        db.eachRow('select * from PERSON') { row ->
            Person person = new Person(id: row.id, firstname: row.firstname, lastname: row.lastname)
            println person
        }
    }

    Person createPerson(Sql row) {
        println row.firstname
        //new Person(row.id, row.firstname, row.lastname)
new Person()
    }

    Boolean save(Person person) {
        person.with {
            db.executeUpdate(
                'UPDATE PERSON SET firstname=:firstname, lastname=:lastname WHERE id=:id',
                firstname: firstname,
                lastname: lastname,
                id: id
            )
        }
    }

    List<Person> findAll(Closure c) {
        List<Person> persons
        def results = db.findAll c

        for (result in results) {
            persons << createPerson(result)
        }

        return persons
    }

}