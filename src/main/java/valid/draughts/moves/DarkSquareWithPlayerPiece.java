package valid.draughts.moves;

import java.util.List;

abstract class DarkSquareWithPlayerPiece extends DarkSquare {

	DarkSquareWithPlayerPiece(int x, int y) {
		super(x, y);
	}

	EmptyDarkSquare asEmptySquare() {
		return new EmptyDarkSquare(getX(), getY(), getAdjacentSquares());
	}

	abstract List<Turn> getPlayerTurns();
}