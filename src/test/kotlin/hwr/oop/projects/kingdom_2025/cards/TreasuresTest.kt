package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class TreasuresTest : AnnotationSpec() {
  
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
  fun `silver, is money with purchase power 2`() {
    // given
    val silver = Card.Silver
    // when
    val purchasePowerOfCopper = silver.purchasePower
    // then
    assertThat(purchasePowerOfCopper).isEqualTo(2)
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
  
}