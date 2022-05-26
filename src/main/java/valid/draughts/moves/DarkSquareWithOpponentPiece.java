package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.List;

class DarkSquareWithOpponentPiece extends DarkSquare {

	DarkSquareWithOpponentPiece(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> jumpOverWithMan(CaptureTurn turnSoFar) {
		if (turnSoFar.isCaptured(this)) {
			return emptyList();
		} else {
			return getAdjacentSquare(turnSoFar.getDirection())
					.landCaptureWithMan(turnSoFar.addCapture(this));
		}
	}

	@Override
	public List<Turn> jumpOverWithKing(CaptureTurn turnSoFar) {
		if (turnSoFar.isCaptured(this)) {
			return emptyList();
		} else {
			return getAdjacentSquare(turnSoFar.getDirection())
					.landCaptureWithKing(turnSoFar.addCapture(this));
		}
	}
}