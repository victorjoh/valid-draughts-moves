package valid.draughts.moves;

import static java.util.Collections.emptyList;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

class DarkSquareWithMyMan implements DarkSquareWithMyPiece {
	private final Map<Direction, Square> adjacentSquares = new EnumMap<>(Direction.class);
	private final int x;
	private final int y;

	public DarkSquareWithMyMan(int x, int y) {
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
		return emptyList();
	}

	@Override
	public List<Turn> landCaptureWithMan(CapturePath pathSoFar) {
		return emptyList();
	}

	@Override
	public List<Turn> getTurns() {
		return Draughts.concatenate(
				adjacentSquares.get(FORWARD_LEFT).endManMove(new MovePath(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).endManMove(new MovePath(this, FORWARD_RIGHT)),
				adjacentSquares.get(FORWARD_RIGHT).jumpOverWithMan(new CapturePath(this, FORWARD_RIGHT)));
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