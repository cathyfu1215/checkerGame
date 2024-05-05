package checkers;

/**
 * This represents the King checkers piece.
 */
public class King extends AbstractCheckersPiece {

  /**
   * Constructs a King object and initializes it
   * to its initial row, initial column and color.
   *
   * @param row    the initial row of the piece
   * @param column the initial column of the piece
   * @param color  the color of the piece
   */
  public King(int row, int column, Color color) throws IllegalArgumentException {
    super(new Coordinates(row, column), color);
  }

  /**
   * Decide if the checkers piece King can move to the given location.
   *
   * @param row    the row where the piece is to be moved.
   * @param column the column where the piece is to be moved.
   * @return true if the checkers piece can be moved to the given location
   */
  @Override
  public boolean canMove(int row, int column) {
    if (!Coordinates.isValid(row, column)) { //illegal position to move
      return false;
    }
    return canMoveUpperLeft(this.getRow(), this.getColumn(), row, column)
        || canMoveUpperRight(this.getRow(), this.getColumn(), row, column)
        || canMoveLowerLeft(this.getRow(), this.getColumn(), row, column)
        || canMoveLowerRight(this.getRow(), this.getColumn(), row, column);
  }


  /**
   * Decides if the checkers piece Man can capture the given piece.
   *
   * @param piece the piece to be captured.
   * @return true if the checkers piece Man can capture the given piece.
   */
  @Override
  public boolean canCapture(CheckersPiece piece) {
    //check if the piece is opponent
    if (isOpponent(piece)) {
      return false;
    }

    //king can capture in 4 directions
    return canCaptureLowerLeft(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn())
        || canCaptureLowerRight(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn())
        || canCaptureUpperLeft(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn())
        || canCaptureUpperRight(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn());

  }
}
