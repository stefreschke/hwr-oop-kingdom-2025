package hwr.oop.projects.kingdom_2025

sealed class Card(
  val purchasePower: Int = 0,
  val points: Int = 0,
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
  
  data object Anwesen : Card(
    points = 1
  )
  
  data object Herzogtum : Card(
    points = 3
  )
  
  data object Provinz : Card(
    points = 6
  )
  
}
