package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class MoneyCardsTest : AnnotationSpec() {
  
  @Test
  fun `kupfer, is money with purchase power 1`() {
    // given
    val kupfer = Card.Kupfer
    // when
    val purchasePowerOfKupfer = kupfer.purchasePower
    // then
    assertThat(purchasePowerOfKupfer).isEqualTo(1)
  }
  
  @Test
  fun `silber, is money with purchase power 2`() {
    // given
    val silber = Card.Silber
    // when
    val purchasePowerOfKupfer = silber.purchasePower
    // then
    assertThat(purchasePowerOfKupfer).isEqualTo(2)
  }
  
  @Test
  fun `gold, is money with purchase power 3`() {
    // given
    val gold = Card.Gold
    // when
    val purchasePowerOfKupfer = gold.purchasePower
    // then
    assertThat(purchasePowerOfKupfer).isEqualTo(3)
  }
  
}