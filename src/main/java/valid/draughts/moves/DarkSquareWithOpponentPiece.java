package valid.draughts.moves;

import java.util.List;

class DarkSquareWithOpponentPiece extends DarkSquare {

	DarkSquareWithOpponentPiece(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> jumpOverWithMan(CaptureTurn pathSoFar) {
		return adjacentSquares.get(pathSoFar.getEndDirection()).landCaptureWithMan(pathSoFar);
	}
}