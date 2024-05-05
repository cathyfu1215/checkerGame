package checkers;

/**
 * Represents the coordinates of a checker piece.
 * The range of both rows and columns are [0,7]
 * They are 0-indexed.
 */
public class Coordinates {

  // I do not use "final" here because the coordinates will change during the game
  private final int row;
  private final int column;

  /**
   * Constructor of a coordinate object.
   *
   * @param row    the row of the coordinate
   * @param column the column of the coordinate
   * @throws IllegalArgumentException if row and/or column value is out of bound, or
   *                                  the coordinates is not a dark square
   */
  public Coordinates(int row, int column) throws IllegalArgumentException {
    if (row > 7 || row < 0) {
      throw new IllegalArgumentException("Row must be in the range of [0,7]!");
    }
    if (column > 7 || column < 0) {
      throw new IllegalArgumentException("Column must be in the range of [0,7]!");
    }
    if ((row + column) % 2 == 1) {
      throw new IllegalArgumentException("Checkers piece should be on a dark square!");
    }
    this.row = row;
    this.column = column;

  }

  /**
   * Return the row number in the coordinates.
   *
   * @return the row number in the coordinates.
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Return the column number in the coordinates.
   *
   * @return the column number in the coordinates.
   */
  public int getColumn() {
    return this.column;
  }


  /**
   * A static method that can tell if a given coordinate is on the checkers board,
   * and on a dark square.
   *
   * @param row    the row number of the given location
   * @param column the column number of the given location
   * @return true if the coordinate is on the checkers board.
   */
  public static boolean isValid(int row, int column) {
    return (row > -1 && row < 8) && (column > -1 && column < 8) && ((row + column) % 2 == 0);
  }
}
