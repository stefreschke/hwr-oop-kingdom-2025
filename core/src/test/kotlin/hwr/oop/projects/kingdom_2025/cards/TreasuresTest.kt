package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class TreasuresTest : AnnotationSpec() {
  
  @Test
  fun `copper provides 0 points`() {
    // given
    val copper = Card.Copper
    // when
    val points = copper.points
    // then
    assertThat(points).isEqualTo(0)
  }
  
  @Test
  fun `copper, is money with purchase power 1`() {
    // given
    val copper = Card.Copper
    // when
    val purchasePowerOfCopper = copper.purchasePower
    // then
    assertThat(purchasePowerOfCopper).isEqualTo(1)
  }
  
  @Test
  fun `copper costs nothing`() {
    // given
    val copper = Card.Copper
    // when
    val cost = copper.cost
    // then
    assertThat(cost).isEqualTo(0)
  }
  
  @Test
  fun `silver provides 0 points`() {
    // given
    val silver = Card.Silver
    // when
    val points = silver.points
    // then
    assertThat(points).isEqualTo(0)
  }
  
  @Test
  fun `silver, is money with purchase power 2`() {
    // given
    val silver = Card.Silver
    // when
    val purchasePowerOfCopper = silver.purchasePower
    // then
    assertThat(purchasePowerOfCopper).isEqualTo(2)
  }
  
  @Test
  fun `silver costs 3`() {
    // given
    val silver = Card.Silver
    // when
    val cost = silver.cost
    // then
    assertThat(cost).isEqualTo(3)
  }
  
  @Test
  fun `gold provides 0 points`() {
    // given
    val gold = Card.Gold
    // when
    val points = gold.points
    // then
    assertThat(points).isEqualTo(0)
  }
  
  @Test
  fun `gold, is money with purchase power 3`() {
    // given
    val gold = Card.Gold
    // when
    val purchasePowerOfCopper = gold.purchasePower
    // then
    assertThat(purchasePowerOfCopper).isEqualTo(3)
  }
  
  @Test
  fun `gold costs 6`() {
    // given
    val gold = Card.Gold
    // when
    val cost = gold.cost
    // then
    assertThat(cost).isEqualTo(6)
  }
}
