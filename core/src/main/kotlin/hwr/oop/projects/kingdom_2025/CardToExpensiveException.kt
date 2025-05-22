package hwr.oop.projects.kingdom_2025

class CardToExpensiveException(
  cardToBeBought: Card,
  hand: Hand,
) : Exception(
  "Not enough purchase power to buy $cardToBeBought," +
      " expected at least ${cardToBeBought.cost}," +
      " got ${hand.purchasePower()}"
)