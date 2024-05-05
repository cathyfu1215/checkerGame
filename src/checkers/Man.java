package checkers;

/**
 * This represents the Man checkers piece.
 */
public class Man extends AbstractCheckersPiece {

  /**
   * Constructs a Man object and initializes it
   * to its initial row, initial column and color.
   *
   * @param row    the initial row of the piece
   * @param column the initial column of the piece
   * @param color  the color of the piece
   */
  public Man(int row, int column, Color color) {
    super(new Coordinates(row, column), color);
  }

  /**
   * Decide if the checkers piece Man can move to the given location.
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
    if (this.color == Color.BLACK) { // Black Man only moves down the rows
      return canMoveLowerLeft(this.getRow(), this.getColumn(), row, column)
          || canMoveLowerRight(this.getRow(), this.getColumn(), row, column);

    } else { // White Man only moves up the rows
      return canMoveUpperLeft(this.getRow(), this.getColumn(), row, column)
          || canMoveUpperRight(this.getRow(), this.getColumn(), row, column);
    }
  }

  /**
   * Decides if the checkers piece Man can capture the given piece.
   *
   * @param piece the piece to be captured.
   * @return true if the checkers piece Man can capture the given piece.
   */

  @Override
  public boolean canCapture(CheckersPiece piece) {
    //if the piece is of same color, it cannot capture
    if (isOpponent(piece)) {
      return false;
    }

    if (this.color == Color.BLACK) { //Black Man only capture down the rows
      return canCaptureLowerLeft(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn())
          ||
          canCaptureLowerRight(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn());

    } else { //White Man only capture up the rows
      return canCaptureUpperLeft(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn())
          ||
          canCaptureUpperRight(this.getRow(), this.getColumn(), piece.getRow(), piece.getColumn());

    }

  }
}
