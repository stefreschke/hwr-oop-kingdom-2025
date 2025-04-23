package hwr.oop.projects.kingdom_2025

sealed class Card(
  val purchasePower: Int = 0,
  val points: Int = 0,
) {
  
  data object Gold : Card(
    purchasePower = 3
  )
  
  data object Silver : Card(
    purchasePower = 2
  )
  
  data object Copper : Card(
    purchasePower = 1
  )
  
  data object Estate : Card(
    points = 1
  )
  
  data object Duchy : Card(
    points = 3
  )
  
  data object Province : Card(
    points = 6
  )
  
}
