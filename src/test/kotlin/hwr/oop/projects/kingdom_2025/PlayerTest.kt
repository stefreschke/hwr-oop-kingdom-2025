package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class PlayerTest : AnnotationSpec() {
  @Test
  fun `player, has name`() {
    val name = "Dieter"
    val player = Player(name)
    assertThat(player.name).isEqualTo(name)
  }
  
  @Test
  fun `player Bob, has name Bob`() {
    val player = Player("Bob")
    assertThat(player.name).isEqualTo("Bob")
  }
}
