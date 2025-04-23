package hwr.oop.projects.kingdom_2025.supplies

import assertAll
import hwr.oop.projects.kingdom_2025.Card
import hwr.oop.projects.kingdom_2025.Supply
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class DefaultSupplyTest : AnnotationSpec() {
  @Test
  fun `default supply, contains all three money cards`() {
    // given
    val supply = Supply()
    // when
    val buyableCards = supply.buyableCards
    // then
    Assertions.assertThat(buyableCards)
      .contains(Card.Silver, Card.Gold, Card.Copper)
  }
  
  @Test
  fun `default supply, contains 60 copper`() {
    // given
    val supply = Supply()
    // when
    val buyableCards = supply.buyableCards
    val availableCoppers: Int = supply.numberOfAvailable(Card.Copper)
    // then
    assertAll {
      assertThat(buyableCards).contains(Card.Copper)
      assertThat(availableCoppers).isEqualTo(60)
    }
  }
  
  @Test
  fun `default supply, contains 40 silver`() {
    // given
    val supply = Supply()
    // when
    val buyableCards = supply.buyableCards
    val availableSilvers: Int = supply.numberOfAvailable(Card.Silver)
    // then
    assertAll {
      assertThat(buyableCards).contains(Card.Silver)
      assertThat(availableSilvers).isEqualTo(40)
    }
  }
  
  @Test
  fun `default supply, contains 30 gold`() {
    // given
    val supply = Supply()
    // when
    val buyableCards = supply.buyableCards
    val availableGold: Int = supply.numberOfAvailable(Card.Gold)
    // then
    assertAll {
      assertThat(buyableCards).contains(Card.Gold)
      assertThat(availableGold).isEqualTo(30)
    }
  }
  
  @Test
  fun `default supply, contains 24 estates`() {
    // given
    val supply = Supply()
    // when
    val buyableCards = supply.buyableCards
    val availableEstates: Int = supply.numberOfAvailable(Card.Estate)
    // then
    assertAll {
      assertThat(buyableCards).contains(Card.Estate)
      assertThat(availableEstates).isEqualTo(24)
    }
  }
  
  @Test
  fun `default supply, contains 12 duchys`() {
    // given
    val supply = Supply()
    // when
    val buyableCards = supply.buyableCards
    val availableDuchys: Int = supply.numberOfAvailable(Card.Duchy)
    // then
    assertAll {
      assertThat(buyableCards).contains(Card.Duchy)
      assertThat(availableDuchys).isEqualTo(12)
    }
  }
  
  @Test
  fun `default supply, contains 12 provinces`() {
    // given
    val supply = Supply()
    // when
    val buyableCards = supply.buyableCards
    val availableProvinces: Int = supply.numberOfAvailable(Card.Province)
    // then
    assertAll {
      assertThat(buyableCards).contains(Card.Province)
      assertThat(availableProvinces).isEqualTo(12)
    }
  }
}