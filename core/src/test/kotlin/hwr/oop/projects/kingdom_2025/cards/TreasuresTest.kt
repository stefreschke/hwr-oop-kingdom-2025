package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class TreasuresTest : AnnotationSpec() {
  
  val gold = Card.Gold
  val silver = Card.Silver
  val copper = Card.Copper
  
  @Test
  fun `copper, provides 0 points`() {
    val points = copper.points
    assertThat(points).isEqualTo(0)
  }
  
  @Test
  fun `copper, is money with purchase power 1`() {
    val purchasePowerOfCopper = copper.purchasePower
    assertThat(purchasePowerOfCopper).isEqualTo(1)
  }
  
  @Test
  fun `copper, costs nothing`() {
    val cost = copper.cost
    assertThat(cost).isEqualTo(0)
  }
  
  @Test
  fun `silver, provides 0 points`() {
    val points = silver.points
    assertThat(points).isEqualTo(0)
  }
  
  @Test
  fun `silver, is money with purchase power 2`() {
    val purchasePowerOfCopper = silver.purchasePower
    assertThat(purchasePowerOfCopper).isEqualTo(2)
  }
  
  @Test
  fun `silver, costs 3`() {
    val cost = silver.cost
    assertThat(cost).isEqualTo(3)
  }
  
  @Test
  fun `gold, provides 0 points`() {
    val points = gold.points
    assertThat(points).isEqualTo(0)
  }
  
  @Test
  fun `gold, is money with purchase power 3`() {
    val purchasePowerOfCopper = gold.purchasePower
    assertThat(purchasePowerOfCopper).isEqualTo(3)
  }
  
  @Test
  fun `gold, costs 6`() {
    val cost = gold.cost
    assertThat(cost).isEqualTo(6)
  }
}
