package checkers;

/**
 * This is an abstract class that represents some common behaviors and methods
 * that a Man class and a King class share.
 */
public abstract class AbstractCheckersPiece implements CheckersPiece {
  protected Color color;
  protected Coordinates coordinates;

  /**
   * Construct a checkers piece and initialize it with initial position as a Coordinate,
   * and a color as an enum Color.
   *
   * @param coordinates consists a row and a column
   * @param color       is either BLACK or WHITE
   * @throws IllegalArgumentException if a null is passed as the color parameter
   */

  public AbstractCheckersPiece(Coordinates coordinates, Color color)
      throws IllegalArgumentException {
    if (color == null) {
      throw new IllegalArgumentException("Color must not be a null!");
    }
    this.color = color;
    this.coordinates = coordinates;

  }

  /**
   * Returns the row number of the piece.
   *
   * @return the row number of the piece
   */
  @Override
  public int getRow() {
    return coordinates.getRow();
  }

  /**
   * Returns the column number of the piece.
   *
   * @return the column number of the piece
   */
  @Override
  public int getColumn() {
    return coordinates.getColumn();
  }

  /**
   * Returns the color of the piece.
   *
   * @return the color of the piece
   */
  @Override
  public Color getColor() {
    return color;
  }

  /* below are four possibilities of pieces moving */

  /**
   * Decide if the piece can move upper left to the target location.
   *
   * @param currentRow    the row number where the piece is currently in
   * @param currentColumn the column number where the piece is currently in
   * @param targetRow     the row number where the target is in
   * @param targetColumn  the column number where the target is in
   * @return true if our piece can move upper left to the target location
   */
  protected boolean canMoveUpperLeft(int currentRow, int currentColumn, int targetRow,
                                     int targetColumn) {
    return (targetRow == currentRow + 1)
        && (targetColumn == currentColumn - 1)
        && Coordinates.isValid(targetRow, targetColumn);
  }

  /**
   * Decide if the piece can move upper right to the target location.
   *
   * @param currentRow    the row number where the piece is currently in
   * @param currentColumn the column number where the piece is currently in
   * @param targetRow     the row number where the target is in
   * @param targetColumn  the column number where the target is in
   * @return true if our piece can move upper right to the target location
   */
  protected boolean canMoveUpperRight(int currentRow, int currentColumn, int targetRow,
                                      int targetColumn) {
    return (targetRow == currentRow + 1)
        && (targetColumn == currentColumn + 1)
        && Coordinates.isValid(targetRow, targetColumn);
  }

  /**
   * Decide if the piece can move lower left to the target location.
   *
   * @param currentRow    the row number where the piece is currently in
   * @param currentColumn the column number where the piece is currently in
   * @param targetRow     the row number where the target is in
   * @param targetColumn  the column number where the target is in
   * @return true if our piece can move lower left to the target location
   */
  protected boolean canMoveLowerLeft(int currentRow, int currentColumn, int targetRow,
                                     int targetColumn) {
    return (targetRow == currentRow - 1)
        && (targetColumn == currentColumn - 1)
        && Coordinates.isValid(targetRow, targetColumn);
  }

  /**
   * Decide if the piece can move lower right to the target location.
   *
   * @param currentRow    the row number where the piece is currently in
   * @param currentColumn the column number where the piece is currently in
   * @param targetRow     the row number where the target is in
   * @param targetColumn  the column number where the target is in
   * @return true if our piece can move lower right to the target location
   */
  protected boolean canMoveLowerRight(int currentRow, int currentColumn, int targetRow,
                                      int targetColumn) {
    return (targetRow == currentRow - 1)
        && (targetColumn == currentColumn + 1)
        && Coordinates.isValid(targetRow, targetColumn);
  }


  /* below are four possibilities of pieces capturing */

  /* According to Lino:
  Imagine that the board only has two pieces: your piece (your object) and
  the one you are entering as a parameter.
  Would it be possible for your piece to capture that second piece?
  Return true if it is possible. False otherwise.*/

  /* I need to make sure :
  1) there is an opponent (check color at the caller function)
  2) the opponent is inside the "capturing range" of our piece
  3) there is a valid space after the capture (assume that cell is empty,
  because we do not consider other pieces)
  */

  /**
   * Decide if the other piece is the opponent's piece to our piece.
   *
   * @param piece another checkers piece
   * @return true if the other piece is the opponent's piece
   */
  protected boolean isOpponent(CheckersPiece piece) {
    return this.color == piece.getColor();
  }

  /**
   * Decide if our piece can capture to the upper left direction.
   *
   * @param currentRow     the row number where the piece is currently in
   * @param currentColumn  the column number where the piece is currently in
   * @param opponentRow    the row number where the opponent piece is currently in
   * @param opponentColumn the column number where the opponent piece is currently in
   * @return true if our piece can capture to the upper left direction
   */

  protected boolean canCaptureUpperLeft(int currentRow, int currentColumn, int opponentRow,
                                        int opponentColumn) {

    //make sure the opponent is in our capture range
    if ((opponentRow != (currentRow + 1)) || (opponentColumn != (currentColumn - 1))) {
      return false;
    }


    // make sure the square we jump to is on the board
    return Coordinates.isValid(currentRow + 2, currentColumn - 2);

  }

  /**
   * Decide if our piece can capture to the upper right direction.
   *
   * @param currentRow     the row number where the piece is currently in
   * @param currentColumn  the column number where the piece is currently in
   * @param opponentRow    the row number where the opponent piece is currently in
   * @param opponentColumn the column number where the opponent piece is currently in
   * @return true if our piece can capture to the upper right direction
   */
  protected boolean canCaptureUpperRight(int currentRow, int currentColumn, int opponentRow,
                                         int opponentColumn) {

    //make sure the opponent is in our capture range
    if ((opponentRow != (currentRow + 1)) || (opponentColumn != (currentColumn + 1))) {
      return false;
    }


    // make sure the square we jump to is on the board
    return Coordinates.isValid(currentRow + 2, currentColumn + 2);

  }

  /**
   * Decide if our piece can capture to the lower left direction.
   *
   * @param currentRow     the row number where the piece is currently in
   * @param currentColumn  the column number where the piece is currently in
   * @param opponentRow    the row number where the opponent piece is currently in
   * @param opponentColumn the column number where the opponent piece is currently in
   * @return true if our piece can capture to the lower left direction
   */
  protected boolean canCaptureLowerLeft(int currentRow, int currentColumn, int opponentRow,
                                        int opponentColumn) {

    //make sure the opponent is in our capture range
    if ((opponentRow != (currentRow - 1)) || (opponentColumn != (currentColumn - 1))) {
      return false;
    }


    // make sure the square we jump to is on the board
    return Coordinates.isValid(currentRow - 2, currentColumn - 2);


  }

  /**
   * Decide if our piece can capture to the upper right direction.
   *
   * @param currentRow     the row number where the piece is currently in
   * @param currentColumn  the column number where the piece is currently in
   * @param opponentRow    the row number where the opponent piece is currently in
   * @param opponentColumn the column number where the opponent piece is currently in
   * @return true if our piece can capture to the upper right direction
   */
  protected boolean canCaptureLowerRight(int currentRow, int currentColumn, int opponentRow,
                                         int opponentColumn) {

    //make sure the opponent is in our capture range
    if ((opponentRow != (currentRow - 1)) || (opponentColumn != (currentColumn + 1))) {
      return false;
    }


    // make sure the square we jump to is on the board
    return Coordinates.isValid(currentRow - 2, currentColumn + 2);

  }


}
