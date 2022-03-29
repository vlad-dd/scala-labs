trait Book {
  val title: String
  val author: String
}

case class Nonfinction(title: String, author: String, topic: String) extends Book
case class Novel(title: String, author: String, genre: String) extends Book
case class Biography(title: String, author: String, aboutPerson: String)  extends Book


object Main extends App {
  def content(book: Book): String = {
    book match {
      case Nonfinction(title, _, topic) => s"$title - $topic"
      case Novel(_,_, genre) => s"$genre"
      case Biography(title,_, aboutPerson) if aboutPerson.toLowerCase.contains("random_person") => s"$title - $aboutPerson"
      case _ => "unknown content"
    }
  }

  println(content(Nonfinction("RANDOM_TITLE", "RANDOM_AUTHOR", "RANDOM_TOPIC")))
  println(content(Novel("RANDOM_TITLE", "RANDOM_AUTHOR", "RANDOM_GENRE")))
  println(content(Biography("RANDOM_TITLE", "RANDOM_AUTHOR", "RANDOM_PERSON")))
}
