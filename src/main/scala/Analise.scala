// Analisando os dados

import java.io.File

object Analise {
  def main(args: Array[String]) {
    val entreeDataPath = "/home/robson/Projects/dsa-scala-projeto-final/restaurantes/entree_data/entree"
    val config = DataConfig(entreeDataPath)
    val featuresMap = Utilitarios.loadFeaturesMap(config.featuresFile)
    val restaurants = config.locations.flatMap { location =>
      Utilitarios.loadLocationData(new File(s"${config.dataPath}/" + location))
    }
    println("Total de Restaurantes Por Cidade")
    println("-" * 50)
    val grouped = restaurants.groupBy(_.city).map { case (k, v) => k -> v.size }
    val citiesSorted = grouped.keys.toArray.sorted
    citiesSorted foreach { city =>
      val count = grouped(city)
      println(f"$city%20s tem $count%6d restaurantes")
    }
    println()

    // Top 5 caracteristicas em cada cidade
    val cityAndTop5 = restaurants.groupBy(_.city).map { r =>
      val (city, restaurantList) = r
      val partialSum = restaurantList.flatMap(_.features).map(_ -> 1)
      val allsum = partialSum.groupBy(_._1).map {
        case (k, v) => k -> v.map(_._2).sum
      }.toSeq.sortBy(_._2).reverse
      val top5 = allsum.take(5)
      city -> top5
    }

    citiesSorted.foreach { city =>
      val top5 = cityAndTop5(city)
      println(s"City: $city")
      println("-" * 50)
      top5 foreach { entry =>
        val (f, count) = entry
        println(f"${featuresMap(f)}%25s em $count%6d restaurantes")
      }
      println()
    }
  }
}