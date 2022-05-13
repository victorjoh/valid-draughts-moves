package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

class DarkSquareWithOpponentPiece implements DarkSquare {
	private final Map<Direction, Square> adjacentSquares = new EnumMap<>(Direction.class);
	private final int x;
	private final int y;

	public DarkSquareWithOpponentPiece(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setAdjacentSquare(Direction fromThisSquare, Square adjecentSquare) {
		adjacentSquares.put(fromThisSquare, adjecentSquare);
	}

	@Override
	public List<Turn> endManMove(MovePath pathSoFar) {
		return emptyList();
	}

	@Override
	public List<Turn> jumpOverWithMan(CapturePath pathSoFar) {
		return adjacentSquares.get(pathSoFar.getDirection()).landCaptureWithMan(pathSoFar);
	}

	@Override
	public List<Turn> landCaptureWithMan(CapturePath pathSoFar) {
		return emptyList();
	}

	@Override
	public List<Turn> endKingMove(MovePath movePath) {
		return emptyList();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}