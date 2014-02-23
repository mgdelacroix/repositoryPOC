@GrabConfig(systemClassLoader=true)
@Grab('com.h2database:h2:1.3.175')

import Config
import PersonRepository
import Person

import groovy.sql.Sql
import groovy.sql.DataSet

Config config = new Config('conf.groovy')

PersonRepository personRepository = new PersonRepository(config.data.database.name)

personRepository.findAll { it }

/*
def people = db.dataSet('PERSON')

//people.add(firstname: 'John', lastname: 'Doe')

def myPeople = people.findAll { it.lastname == 'Doe' }

myPeople.each {
    db.execute('UPDATE PERSON SET lastname=:lastname WHERE id=:id', lastname: 'pppp', id: it.id)
    println it
}

db.commit()

//myPeople.each { println it }

printPersonTable(db)
*/