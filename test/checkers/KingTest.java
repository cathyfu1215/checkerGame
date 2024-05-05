package checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the King class.
 */
public class KingTest {
  private King justCrownedBlackKing;

  private King justCrownedWhiteKing;
  private King centerWhiteKing;
  private Man capturableBlackPiece1;
  private Man capturableBlackPiece2;
  private Man capturableBlackPiece3;
  private Man capturableBlackPiece4;

  private Man capturableWhitePiece;
  private King friendWhitePiece;
  private King whiteKingNearCorner;

  private King cornerBlackPiece;
  private Man blackPieceFarAway;

  /**
   * Set up some objects. Assume good input in the constructors.
   */
  @Before
  public void setUp() {
    this.justCrownedBlackKing = new King(0, 0, Color.BLACK);
    this.justCrownedWhiteKing = new King(7, 7, Color.WHITE);

    this.centerWhiteKing = new King(2, 4, Color.WHITE);
    this.capturableBlackPiece1 = new Man(3, 5, Color.BLACK);
    this.capturableBlackPiece2 = new Man(3, 3, Color.BLACK);
    this.capturableBlackPiece3 = new Man(1, 3, Color.BLACK);
    this.capturableBlackPiece4 = new Man(1, 5, Color.BLACK);
    this.capturableWhitePiece = new Man(1, 1, Color.WHITE);

    this.friendWhitePiece = new King(3, 3, Color.WHITE);
    this.whiteKingNearCorner = new King(2, 6, Color.WHITE);
    this.cornerBlackPiece = new King(3, 7, Color.BLACK);
    this.blackPieceFarAway = new Man(4, 2, Color.BLACK);
  }

  /**
   * Test that an exception is thrown when an illegal row value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRowTooLow() {
    King data = new King(-1, 7, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal row value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRowTooHigh() {
    King data = new King(9, 7, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal column value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumnTooLow() {
    King data = new King(1, -7, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal column value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumnTooHigh() {
    King data = new King(1, 9, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal combination of row and column is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalLightColorCell() {
    King data = new King(0, 1, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when a null is
   * passed into the constructor as a color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullColor() {
    King data = new King(1, 1, null);
  }

  /**
   * Test the getRow method.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, this.justCrownedBlackKing.getRow());
    assertEquals(7, this.justCrownedWhiteKing.getRow());
  }

  /**
   * Test the getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, this.justCrownedBlackKing.getColumn());
    assertEquals(7, this.justCrownedWhiteKing.getColumn());
  }

  /**
   * Test the getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, this.justCrownedBlackKing.getColor());
    assertEquals(Color.WHITE, this.justCrownedWhiteKing.getColor());
  }

  /**
   * Test the canMove method.
   */
  @Test
  public void testCanMove() {
    // center king can move to 4 directions, no matter what color it is
    assertTrue(this.centerWhiteKing.canMove(3, 3));
    assertTrue(this.centerWhiteKing.canMove(3, 5));
    assertTrue(this.centerWhiteKing.canMove(1, 3));
    assertTrue(this.centerWhiteKing.canMove(1, 5));

    // king cannot move more than one step
    assertFalse(this.centerWhiteKing.canMove(4, 4));

    //cornered king cannot move to illegal squares
    assertFalse(this.justCrownedBlackKing.canMove(-1, -1));
    assertFalse(this.justCrownedBlackKing.canMove(-1, 1));
    assertFalse(this.justCrownedWhiteKing.canMove(8, 8));

  }

  /**
   * Test the canCapture method.
   */
  @Test
  public void testCanCapture() {

    /*When we test King's movement, it doesn't matter which color is it, as long as
     * we want to capture an enemy.
     * Also, it does not matter if the enemy is a King or a Man.
     */

    // white king can capture a black piece in 4 directions
    assertTrue(this.centerWhiteKing.canCapture(this.capturableBlackPiece1));
    assertTrue(this.centerWhiteKing.canCapture(this.capturableBlackPiece2));
    assertTrue(this.centerWhiteKing.canCapture(this.capturableBlackPiece3));
    assertTrue(this.centerWhiteKing.canCapture(this.capturableBlackPiece4));

    // white king cannot capture a white piece
    assertFalse(this.centerWhiteKing.canCapture(this.friendWhitePiece));
    // white king cannot capture an enemy when the landing square is invalid
    assertFalse(this.whiteKingNearCorner.canCapture(this.cornerBlackPiece));
    // white king cannot capture an enemy that is out of its capture range
    assertFalse(this.centerWhiteKing.canCapture(blackPieceFarAway));

    //simply test black king can capture a white piece
    assertTrue(this.justCrownedBlackKing.canCapture(capturableWhitePiece));

  }
}