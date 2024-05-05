package checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * A JUnit test class for the Man class.
 */
public class ManTest {

  private Man frontBlackMan;
  private Man frontWhiteMan;
  private Man capturableBlackMan;
  private CheckersPiece friendWhitePiece;
  private Man cornerBlackMan;
  private Man whiteManAroundCorner;
  private Man blackManAtTheBack;
  private Man blackManFarAway;
  private Man capturableWhiteMan;
  private Man cornerWhiteMan;

  /**
   * Set up some objects. Assume good input in the constructors.
   */
  @org.junit.Before
  public void setUp() {
    this.frontBlackMan = new Man(5, 1, Color.BLACK);
    this.frontWhiteMan = new Man(2, 2, Color.WHITE);

    this.capturableBlackMan = new Man(3, 1, Color.BLACK);
    this.friendWhitePiece = new Man(3, 1, Color.WHITE);
    this.whiteManAroundCorner = new Man(4, 6, Color.WHITE);
    this.cornerBlackMan = new Man(5, 7, Color.BLACK);
    this.blackManAtTheBack = new Man(3, 5, Color.BLACK);
    this.blackManFarAway = new Man(4, 4, Color.BLACK);

    this.capturableWhiteMan = new Man(4, 2, Color.WHITE);
    this.cornerWhiteMan = new Man(4, 0, Color.WHITE);

  }

  /**
   * Test that an exception is thrown when an illegal row value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRowTooLow() {
    Man data = new Man(-1, 7, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal row value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRowTooHigh() {
    Man data = new Man(9, 7, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal column value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumnTooLow() {
    Man data = new Man(1, -7, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal column value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumnTooHigh() {
    Man data = new Man(1, 9, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when an illegal combination of row and column is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalLightColorCell() {
    Man data = new Man(0, 1, Color.WHITE);
  }

  /**
   * Test that an exception is thrown when a null is
   * passed into the constructor as a color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullColor() {
    Man data = new Man(1, 1, null);
  }

  /**
   * Test the getRow method.
   */
  @org.junit.Test
  public void testGetRow() {
    assertEquals(5, this.frontBlackMan.getRow());
    assertEquals(2, this.frontWhiteMan.getRow());
  }

  /**
   * Test the getColumn method.
   */
  @org.junit.Test
  public void testGetColumn() {
    assertEquals(1, this.frontBlackMan.getColumn());
    assertEquals(2, this.frontWhiteMan.getColumn());
  }

  /**
   * Test the getColor method.
   */
  @org.junit.Test
  public void testGetColor() {
    assertEquals(Color.BLACK, this.frontBlackMan.getColor());
    assertEquals(Color.WHITE, this.frontWhiteMan.getColor());
  }

  /**
   * Test the canMove method.
   */
  @org.junit.Test
  public void testCanMove() {
    assertTrue(this.frontBlackMan.canMove(4, 0));
    assertTrue(this.frontBlackMan.canMove(4, 2));
    assertFalse(this.frontBlackMan.canMove(4, -1)); //cannot move to an illegal coordinate
    assertFalse(this.frontBlackMan.canMove(4, 1)); //cannot move to a light color square
    assertFalse(this.frontBlackMan.canMove(6, 0)); //cannot move backward
    assertFalse(this.frontBlackMan.canMove(3, 3)); //cannot move more than one step

    assertTrue(this.frontWhiteMan.canMove(3, 1));
    assertTrue(this.frontWhiteMan.canMove(3, 3));
    assertFalse(this.frontWhiteMan.canMove(3, -1)); //cannot move to an illegal coordinate
    assertFalse(this.frontWhiteMan.canMove(3, 2)); //cannot move to a light color square
    assertFalse(this.frontWhiteMan.canMove(1, 1)); //cannot move backward
    assertFalse(this.frontWhiteMan.canMove(4, 4)); //cannot move more than one step
  }

  /**
   * Test the canCapture method.
   */
  @org.junit.Test
  public void testCanCapture() {

    /*
     * When we are capturing, it doesn't matter if the opponent is a Man or a King.
     * I use Man as examples.
     */

    // white pieces capture black piece
    assertTrue(this.frontWhiteMan.canCapture(capturableBlackMan));
    // white man cannot capture another white piece
    assertFalse(this.frontWhiteMan.canCapture(friendWhitePiece));
    // white man cannot capture an enemy when the landing square is invalid
    assertFalse(this.whiteManAroundCorner.canCapture(cornerBlackMan));
    // white man cannot capture an enemy when the enemy is at the back
    assertFalse(this.whiteManAroundCorner.canCapture(blackManAtTheBack));
    // white man cannot capture an enemy that is out of its capture range
    assertFalse(this.frontWhiteMan.canCapture(blackManFarAway));

    // black piece capture white piece
    assertTrue(this.frontBlackMan.canCapture(capturableWhiteMan));
    // black man cannot capture an enemy when the landing square is invalid
    assertFalse(this.frontBlackMan.canCapture(cornerWhiteMan));


    // I believe the other logics are symmetric, so there is no need to write more tests
    // My test coverage is 100% for this class, 100% for the Abstract class,
    // and 100% for the interface

  }
}