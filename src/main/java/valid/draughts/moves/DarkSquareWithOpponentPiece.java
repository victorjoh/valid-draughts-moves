package valid.draughts.moves;

import java.util.List;

class DarkSquareWithOpponentPiece extends DarkSquare {

	DarkSquareWithOpponentPiece(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> jumpOverWithMan(CaptureTurn turnSoFar) {
		return adjacentSquares.get(turnSoFar.getEndDirection()).landCaptureWithMan(turnSoFar);
	}

	@Override
	public List<Turn> jumpOverWithKing(CaptureTurn turnSoFar) {
		return adjacentSquares.get(turnSoFar.getEndDirection()).landCaptureWithKing(turnSoFar);
	}
}