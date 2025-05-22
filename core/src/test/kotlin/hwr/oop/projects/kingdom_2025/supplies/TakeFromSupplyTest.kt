package hwr.oop.projects.kingdom_2025.supplies

import hwr.oop.projects.kingdom_2025.assertAll
import hwr.oop.projects.kingdom_2025.Card
import hwr.oop.projects.kingdom_2025.Supply
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThatThrownBy

class TakeFromSupplyTest : AnnotationSpec() {
  @Test
  fun `take 7 copper from supply, supply has 53 remaining`() {
    // given
    val supply = Supply()
    // when
    val updatedSupply = supply.remove(7, Card.Copper)
    // then
    assertAll {
      assertThat(updatedSupply.numberOfAvailable(Card.Copper)).isEqualTo(53)
    }
  }
  
  @Test
  fun `exception, take 61 copper from supply, but only 60 available`() {
    // given
    val supply = Supply()
    assertThatThrownBy {
      // when
      supply.remove(61, Card.Copper)
      // then
    }.hasMessageContaining(
      "Not enough Copper in supply",
      "requested: 61",
      "only available: 60"
    )
  }
  
  @Test
  fun `take 60 copper from supply, supply knows copper is empty`() {
    // given
    val supply = Supply()
    // when
    val updatedSupply = supply.remove(60, Card.Copper)
    // then
    assertAll {
      assertThat(updatedSupply.buyableCards).doesNotContain(Card.Copper)
      assertThat(updatedSupply.numberOfAvailable(Card.Copper)).isEqualTo(0)
      assertThat(updatedSupply.pileIsEmpty(Card.Copper)).isTrue
      assertThat(updatedSupply.emptyPiles).contains(Card.Copper)
      assertThat(updatedSupply.numberOfEmptyPiles).isEqualTo(1)
    }
  }
  
  @Test
  fun `exception, take card not in supply, illegal argument`() {
    // given
    val supply = Supply()
    assertThatThrownBy {
      // when
      supply.remove(1, Card.Thief)
    }.hasMessageContaining(
      // then
      "Card Thief is not in supply"
    )
  }
  
  @Test
  fun `exception, check emptiness of pile not in supply, illegal argument`() {
    // given
    val supply = Supply()
    assertThatThrownBy {
      // when
      supply.pileIsEmpty(Card.Thief)
    }.hasMessageContaining(
      // then
      "Card Thief is not in supply"
    )
  }
  
  @Test
  fun `exception, check if card not in supply buyable, illegal argument`() {
    // given
    val supply = Supply()
    assertThatThrownBy {
      // when
      supply.numberOfAvailable(Card.Thief)
    }.hasMessageContaining(
      // then
      "Card Thief is not in supply"
    )
  }
}
