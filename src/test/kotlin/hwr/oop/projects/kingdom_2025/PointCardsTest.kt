package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class PointCardsTest : AnnotationSpec() {
  @Test
  fun `anwesen, gives single point`() {
    // given
    val anwesen = Card.Anwesen
    // when
    val retrievedPoints = anwesen.points
    // then
    assertThat(retrievedPoints).isEqualTo(1)
  }
  
  @Test
  fun `herzogtum, gives 3 points`() {
    // given
    val herzogtum = Card.Herzogtum
    // when
    val retrievedPoints = herzogtum.points
    // then
    assertThat(retrievedPoints).isEqualTo(3)
  }
  
  @Test
  fun `provinz, gives 6 points`() {
    // given
    val provinz = Card.Provinz
    // when
    val retrievedPoints = provinz.points
    // then
    assertThat(retrievedPoints).isEqualTo(6)
  }
  
}
