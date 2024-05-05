package checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Coordinates class.
 */
public class CoordinatesTest {

  private Coordinates sampleCoordinates1;
  private Coordinates sampleCoordinates2;


  /**
   * Set up some objects. Assume good input in the constructors.
   */
  @Before
  public void setUp() {
    this.sampleCoordinates1 = new Coordinates(6, 0);
    this.sampleCoordinates2 = new Coordinates(1, 7);
  }

  /**
   * Test that an exception is thrown when an illegal row value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRowTooLow() {
    Coordinates data = new Coordinates(-1, 7);
  }

  /**
   * Test that an exception is thrown when an illegal row value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRowTooHigh() {
    Coordinates data = new Coordinates(9, 7);
  }

  /**
   * Test that an exception is thrown when an illegal column value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumnTooLow() {
    Coordinates data = new Coordinates(1, -1);
  }

  /**
   * Test that an exception is thrown when an illegal row value is
   * passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumnTooHigh() {
    Coordinates data = new Coordinates(5, 9);
  }

  /**
   * Test that an exception is thrown when an illegal coordinates
   * (not a dark square) is passed into the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCoordinates() {
    Coordinates data = new Coordinates(5, 6);
  }


  /**
   * Test the getRow method.
   */
  @Test
  public void getRow() {
    assertEquals(6, this.sampleCoordinates1.getRow());
    assertEquals(1, this.sampleCoordinates2.getRow());
  }

  /**
   * Test the getColumn method.
   */
  @Test
  public void getColumn() {
    assertEquals(0, this.sampleCoordinates1.getColumn());
    assertEquals(7, this.sampleCoordinates2.getColumn());
  }

  /**
   * Test the isValid method.
   */
  @Test
  public void isValid() {
    assertTrue(Coordinates.isValid(5, 3)); // on board, dark square
    assertFalse(Coordinates.isValid(-1, 1)); //out of bound
    assertFalse(Coordinates.isValid(1, -1)); //out of bound
    assertFalse(Coordinates.isValid(9, 7)); //out of bound
    assertFalse(Coordinates.isValid(7, 9)); //out of bound
    assertFalse(Coordinates.isValid(7, 6)); //on board, but is a light square
    assertFalse(Coordinates.isValid(4, 5)); //on board, but is also a light square

  }
}