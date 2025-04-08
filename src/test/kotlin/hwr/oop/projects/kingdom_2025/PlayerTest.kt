package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class PlayerTest : AnnotationSpec() {
  @Test
  fun `player Alice, has name Alice`() {
    val name = "Alice"
    val player = Player(name)
    assertThat(player.name).isEqualTo(name)
  }
}
