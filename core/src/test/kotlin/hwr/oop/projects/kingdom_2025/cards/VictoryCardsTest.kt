package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class VictoryCardsTest : AnnotationSpec() {
  val estate = Card.Estate
  val duchy = Card.Duchy
  val province = Card.Province
  
  @Test
  fun `estate, costs 2`() {
    val cost = estate.cost
    assertThat(cost).isEqualTo(2)
  }
  
  @Test
  fun `estate, has no purchase power`() {
    val purchasePower = estate.purchasePower
    assertThat(purchasePower).isZero
  }
  
  @Test
  fun `duchy, costs 5`() {
    val cost = duchy.cost
    assertThat(cost).isEqualTo(5)
  }
  
  @Test
  fun `estate, gives single point`() {
    val retrievedPoints = estate.points
    assertThat(retrievedPoints).isEqualTo(1)
  }
  
  @Test
  fun `duchy, has no purchase power`() {
    val purchasePower = duchy.purchasePower
    assertThat(purchasePower).isZero
  }
  
  @Test
  fun `duchy, gives 3 points`() {
    val retrievedPoints = duchy.points
    assertThat(retrievedPoints).isEqualTo(3)
  }
  
  @Test
  fun `province, costs 8`() {
    val cost = province.cost
    assertThat(cost).isEqualTo(8)
  }
  
  @Test
  fun `province, has no purchase power`() {
    val purchasePower = province.purchasePower
    assertThat(purchasePower).isZero
  }
  
  @Test
  fun `province, gives 6 points`() {
    val retrievedPoints = province.points
    assertThat(retrievedPoints).isEqualTo(6)
  }
  
}
