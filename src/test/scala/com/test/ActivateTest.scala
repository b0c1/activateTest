package com.test

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorage
import net.fwbrasil.activate.storage.relational.idiom.h2Dialect
import net.fwbrasil.activate.sequence.LongSequenceEntity
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSpec
import net.fwbrasil.activate.entity.id.SequencedIdGenerator

object persistenceContext extends ActivateContext {
  val storage = new PooledJdbcRelationalStorage {
    val jdbcDriver = "org.h2.Driver"
    val user = Some("sa")
    val password = Some("")
    val url = "jdbc:h2:mem:my_database;DB_CLOSE_DELAY=-1"
    val dialect = h2Dialect
  }
}

import persistenceContext._

class SequenceTableMigration extends Migration {
  def timestamp = 20140331001l

  def up = {
    table[LongSequenceEntity].createTable(
      _.column[String]("name"),
      _.column[Long]("value")
    ).ifNotExists
  }
}

class Person(var name: String) extends EntityWithGeneratedID[Long]

class CreatePersonTableMigration extends Migration {
  def timestamp = 20140331002l

  def up = {
    table[Person]
      .createTable(
        _.column[String]("name"))
  }
}

class PersonIdGeerator extends SequencedIdGenerator[Person](LongSequenceEntity("personSequence"))

@RunWith(classOf[JUnitRunner])
class ActivateTest extends FunSpec {

  transactional {}

  describe("Test basic functionality") {
    it("should read/write wprl correctly") {
      transactional {
        new Person("John")
      }

      transactional {
        select[Person].where(_.name :== "John").head
      }

      transactional {
        val john = select[Person].where(_.name :== "John").head
        john.name = "John Doe"
      }

      transactional {
        all[Person].foreach(_.delete)
      }
    }
  }

}