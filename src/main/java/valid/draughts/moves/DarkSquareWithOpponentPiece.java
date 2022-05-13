package valid.draughts.moves;

import java.util.List;

class DarkSquareWithOpponentPiece extends DarkSquare {

	DarkSquareWithOpponentPiece(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> jumpOverWithMan(CapturePath pathSoFar) {
		return adjacentSquares.get(pathSoFar.getDirection()).landCaptureWithMan(pathSoFar);
	}
}