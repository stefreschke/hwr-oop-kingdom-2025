package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class PointCardsTest : AnnotationSpec() {
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
  fun `duchy, gives 3 points`() {
    // given
    val duchy = Card.Duchy
    // when
    val retrievedPoints = duchy.points
    // then
    assertThat(retrievedPoints).isEqualTo(3)
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
