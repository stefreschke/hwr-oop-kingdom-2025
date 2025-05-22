package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import hwr.oop.projects.kingdom_2025.Hand
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class PurchasePowerOfHandsTest : AnnotationSpec() {
  
  @Test
  fun `1 copper, 1 purchase power`() {
    val sut = Hand(listOf(Card.Copper))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(1)
  }
  
  @Test
  fun `1 silver, 2 purchase power`() {
    val sut = Hand(listOf(Card.Silver))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(2)
  }
  
  @Test
  fun `1 silver, 1 copper, 3 purchase power`() {
    val sut = Hand(listOf(Card.Silver, Card.Copper))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(3)
  }
  
  @Test
  fun `2 silver, 4 purchase power`() {
    val sut = Hand(listOf(Card.Silver, Card.Silver))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(4)
  }
  
  @Test
  fun `2 silver, 1 copper, 5 purchase power`() {
    val sut = Hand(listOf(Card.Silver, Card.Silver, Card.Copper))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(5)
  }
  
  @Test
  fun `1 gold, 3 purchase power`() {
    val sut = Hand(listOf(Card.Gold))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(3)
  }
  
  @Test
  fun `1 gold, 1 copper, 4 purchase power`() {
    val sut = Hand(listOf(Card.Gold, Card.Copper))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(4)
  }
  
  @Test
  fun `1 gold, 1 silver, 5 purchase power`() {
    val sut = Hand(listOf(Card.Gold, Card.Silver))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(5)
  }
  
  @Test
  fun `1 gold, 1 silver, 1 copper, 6 purchase power`() {
    val sut = Hand(listOf(Card.Gold, Card.Silver, Card.Copper))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(6)
  }
  
  @Test
  fun `2 gold, 6 purchase power`() {
    val sut = Hand(listOf(Card.Gold, Card.Gold))
    val purchasePower = sut.purchasePower()
    assertThat(purchasePower).isEqualTo(6)
  }
}