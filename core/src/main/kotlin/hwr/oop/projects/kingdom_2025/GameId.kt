package hwr.oop.projects.kingdom_2025

import java.util.*

data class GameId(val value: String) {
  companion object {
    fun random(): GameId {
      val randomUUID = UUID.randomUUID()
      return GameId(randomUUID.toString())
    }
  }
}
