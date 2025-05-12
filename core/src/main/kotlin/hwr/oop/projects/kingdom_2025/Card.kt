package hwr.oop.projects.kingdom_2025

sealed class Card(
  val purchasePower: Int = 0,
  val points: Int = 0,
  val cost: Int = 0,
) {
  
  data object Gold : Card(
    purchasePower = 3,
    cost = 6
  )
  
  data object Silver : Card(
    purchasePower = 2,
    cost = 3
  )
  
  data object Copper : Card(
    purchasePower = 1
  )
  
  object Curse : Card(
    points = -1,
  )
  
  data object Estate : Card(
    points = 1,
    cost = 2
  )
  
  data object Duchy : Card(
    points = 3,
    cost = 5
  )
  
  data object Province : Card(
    points = 6,
    cost = 8
  )
  
  data object Thief : Card(
    purchasePower = 0,
    points = 0,
    cost = 4,
  )
  
  data object DummyCard1 : Card()
  
  data object DummyCard2 : Card()
  
  data object DummyCard3 : Card()
  
  data object DummyCard4 : Card()
  
  data object DummyCard5 : Card()
  
  data object DummyCard6 : Card()
  
  data object DummyCard7 : Card()
  
  data object DummyCard8 : Card()
  
  data object DummyCard9 : Card()
  
  data object DummyCard10 : Card()
  
}
