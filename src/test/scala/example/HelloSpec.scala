package example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  it should "return content of the test file" in {
    Hello.getFileContent("fixtures/simple_file.txt") should be ("content of the test file")
  }

  it should "return string with replaced placeholders" in {
    val initTemplateString = "A1 '{{GMT_END_DATE}}' B1 AND '{{GMT_START_DATE}}'"
    val expectedResult = "A1 '01-02-2019' B1 AND '02-02-2019'"

    val res = Hello.replaceInString(initTemplateString,"01-02-2019","02-02-2019")
    res should be (expectedResult)
  }

  it should "read file and replace it's temple placeholders" in {
    val content = Hello.getFileContent("fixtures/sql_query.sql")
    val expected = Hello.getFileContent("fixtures/expected_sql_query.sql")
    val res = Hello.replaceInString(content, "01-02-2019","02-02-2019")

    res should be (expected)
  }
}
