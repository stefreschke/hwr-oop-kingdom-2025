package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class VictoryCardsTest : AnnotationSpec() {
  
  @Test
  fun `estate, costs 2`() {
    // given
    val estate = Card.Estate
    // when
    val cost = estate.cost
    // then
    assertThat(cost).isEqualTo(2)
  }
  
  @Test
  fun `estate, has no purchase power`() {
    // given
    val estate = Card.Estate
    // when
    val purchasePower = estate.purchasePower
    // then
    assertThat(purchasePower).isZero
  }
  
  @Test
  fun `duchy, costs 5`() {
    // given
    val duchy = Card.Duchy
    // when
    val cost = duchy.cost
    // then
    assertThat(cost).isEqualTo(5)
  }
  
  @Test
  fun `estate, gives single point`() {
    // given
    val estate = Card.Estate
    // when
    val retrievedPoints = estate.points
    // then
    assertThat(retrievedPoints).isEqualTo(1)
  }
  
  @Test
  fun `duchy, has no purchase power`() {
    // given
    val duchy = Card.Duchy
    // when
    val purchasePower = duchy.purchasePower
    // then
    assertThat(purchasePower).isZero
  }
  
  @Test
  fun `duchy, gives 3 points`() {
    // given
    val duchy = Card.Duchy
    // when
    val retrievedPoints = duchy.points
    // then
    assertThat(retrievedPoints).isEqualTo(3)
  }
  
  @Test
  fun `province, costs 8`() {
    // given
    val province = Card.Province
    // when
    val cost = province.cost
    // then
    assertThat(cost).isEqualTo(8)
  }
  
  @Test
  fun `province, has no purchase power`() {
    // given
    val province = Card.Province
    // when
    val purchasePower = province.purchasePower
    // then
    assertThat(purchasePower).isZero
  }
  
  @Test
  fun `province, gives 6 points`() {
    // given
    val province = Card.Province
    // when
    val retrievedPoints = province.points
    // then
    assertThat(retrievedPoints).isEqualTo(6)
  }
  
}
