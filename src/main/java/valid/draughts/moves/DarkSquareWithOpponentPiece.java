package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.function.BiFunction;

class DarkSquareWithOpponentPiece extends DarkSquare {

	DarkSquareWithOpponentPiece(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> jumpOverWithMan(CaptureTurn turnSoFar) {
		return jumpOverWithPiece(turnSoFar, AdjacentSquare::landCaptureWithMan);
	}

	@Override
	public List<Turn> jumpOverWithKing(CaptureTurn turnSoFar) {
		return jumpOverWithPiece(turnSoFar, AdjacentSquare::landCaptureWithKing);
	}

	private List<Turn> jumpOverWithPiece(
			CaptureTurn turnSoFar,
			BiFunction<AdjacentSquare, CaptureTurn, List<Turn>> landingType
	) {
		if (turnSoFar.isCaptured(this)) {
			return emptyList();
		} else {
			return landingType.apply(
					getAdjacentSquare(turnSoFar.getDirection()),
					turnSoFar.addCapture(this));
		}
	}
}