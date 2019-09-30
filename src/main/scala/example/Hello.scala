package example

import scala.io.Source

object Hello extends App {
  def getFileContent(filePath: String): String = {
    val is = this.getClass.getClassLoader.getResourceAsStream(filePath)
    Source.fromInputStream(is).getLines().mkString("\n")
  }

  def replaceInString(string: String, gmtEndDate: String, gmtStartDate: String): String = {
    string
      .replaceFirst("""\{\{\s*GMT_END_DATE\s*\}\}""", gmtEndDate)
      .replaceFirst("""\{\{\s*GMT_START_DATE\s*\}\}""", gmtStartDate)
  }
}
