package checkers;

/**
 * Interface for CheckersPiece. Checkers is a popular board game played between two
 * players on a
 * square board divided into 64 squares of alternating colors (usually a light
 * color and a dark
 * color).
 * The objective of the game is to capture or block all of your opponent's pieces,
 * leaving them
 * with no valid moves, or to force your opponent into a position where they cannot
 * make any more
 * moves.
 */
public interface CheckersPiece {
  /**
   * Returns the row where the piece is located.
   *
   * @return the row where the piece is located.
   */
  int getRow();

  /**
   * Returns the column where the piece is located.
   *
   * @return the column where the piece is located.
   */
  int getColumn();

  /**
   * Returns the color of the piece.
   *
   * @return the color of the piece
   */
  Color getColor();

  /**
   * Returns true if the piece can move to the specified row and column, false
   * otherwise.
   *
   * @param row    the row where the piece is to be moved.
   * @param column the column where the piece is to be moved.
   * @return true
   */
  boolean canMove(int row, int column);

  /**
   * Returns true if the piece can capture the specified piece, false otherwise.
   *
   * @param piece the piece to be captured.
   * @return true if the piece can capture the specified piece, false otherwise.
   */
  boolean canCapture(CheckersPiece piece);
}

