// Dicionario de Dados

case class Restaurant(id: String, name: String, features: Array[String], city: String)
case class SessionData(datetime: String, ip: String,
                       entryPoint: String, navigations: Array[String], endPoint: String)

trait Constants {
  val locations = Array(
    "atlanta.txt",
    "boston.txt",
    "chicago.txt",
    "los_angeles.txt",
    "new_orleans.txt",
    "new_york.txt",
    "san_francisco.txt",
    "washington_dc.txt" //
  )

  val cityCodes = Map(
    "A" -> "Atlanta",
    "B" -> "Boston",
    "C" -> "Chicago",
    "D" -> "Los Angeles",
    "E" -> "New Orleans",
    "F" -> "New York",
    "G" -> "San Francisco",
    "H" -> "Washington DC" //
  )

  val navigationOperationCodes = Map(
    "L" -> "browse (mover a partir de um restaurante para outri na lista de recomendações)",
    "M" -> "cheaper (buscar por um restaurante como esse, porém mais barato)",
    "N" -> "nicer   (buscar por um restaurante como esse, porém mais agradável)",
    "O" -> "closer  (não usado na versão de produção)",
    "P" -> "more traditional (buscar por um restaurante como esse, porém com cozinha tradicional)",
    "Q" -> "more creative (buscar por um restaurante com cozinha tradicional)",
    "R" -> "more lively (buscar por um restaurante com atmosfera vibrante)",
    "S" -> "quieter (buscar por um restaurante com atmosfera calma)",
    "T" -> """change cuisine (buscar por um restaurante como esse, porém mais diferente tipo de comida)""")
}

case class DataConfig(datasetPath: String) extends Constants {
  val dataPath = s"$datasetPath/data"
  val sessionPath = s"$datasetPath/session"
  val featuresFile = s"$dataPath/features.txt"
}
