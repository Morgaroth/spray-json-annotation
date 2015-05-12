package us.bleibinha.spray.json.macros.lazyy

import org.specs2.mutable.Specification
import spray.json._

@json case class City(name: String)
@json case class Person(name: String, age: Int)

class LazyJsonFormatAnnotationTest extends Specification {

  "@json annotation" should {

    "create correct formatter for case class with 1 field" in {

      val city = City("San Francisco")
      val json = city.toJson
      json === JsObject(
        "name" -> JsString("San Francisco")
      )
      Option(json.convertTo[City]) must beSome(city)
    }

    "create correct formatter for case class with >= 2 fields" in {

      val person = Person("Victor Hugo", 46)
      val json = person.toJson
      json === JsObject(
        "name" -> JsString("Victor Hugo"),
        "age" -> JsNumber(46)
      )
      Option(json.convertTo[Person]) must beSome(person)
    }
  }
}
