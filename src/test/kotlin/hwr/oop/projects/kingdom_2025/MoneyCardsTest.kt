package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class MoneyCardsTest : AnnotationSpec() {
  
  @Test
  fun `three kinds of money cards possible`() {
    // given
    val kupfer = Card.Kupfer
    val silber = Card.Silber
    val gold = Card.Gold
    // when
    val purchasePowerOfKupfer: Int = kupfer.purchasePower
    val purchasePowerOfSilber: Int = silber.purchasePower
    val purchasePowerOfGold: Int = gold.purchasePower
    // then
    assertThat(purchasePowerOfKupfer).isEqualTo(1)
    assertThat(purchasePowerOfSilber).isEqualTo(2)
    assertThat(purchasePowerOfGold).isEqualTo(3)
  }
  
}