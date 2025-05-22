package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class PlayerTest : AnnotationSpec() {
  @Test
  fun `player, has name`() {
    val dieter = Player("Dieter")
    assertThat(dieter.name).isEqualTo("Dieter")
  }
  
  @Test
  fun `player Bob, has name Bob`() {
    val bob = Player("Bob")
    assertThat(bob.name).isEqualTo("Bob")
  }
}