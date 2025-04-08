package hwr.oop.projects.kingdom_2025

sealed class Card(
  val purchasePower: Int
) {
  
  data object Gold : Card(
    purchasePower = 3
  )
  
  data object Silber : Card(
    purchasePower = 2
  )
  
  data object Kupfer : Card(
    purchasePower = 1
  )
  
}
