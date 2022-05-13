package valid.draughts.moves;

import static java.util.Collections.emptyList;
import static valid.draughts.moves.Direction.BACKWARDS_LEFT;
import static valid.draughts.moves.Direction.BACKWARDS_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

class DarkSquareWithMyKing implements DarkSquareWithMyPiece {
	private final Map<Direction, Square> adjacentSquares = new EnumMap<>(Direction.class);
	private final int x;
	private final int y;

	public DarkSquareWithMyKing(int x, int y) {
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
	public List<Turn> endKingMove(MovePath movePath) {
		return emptyList();
	}

	@Override
	public List<Turn> getTurns() {
		return Draughts.concatenate(
				adjacentSquares.get(FORWARD_LEFT).endKingMove(new MovePath(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).endKingMove(new MovePath(this, FORWARD_RIGHT)),
				adjacentSquares.get(BACKWARDS_LEFT).endKingMove(new MovePath(this, BACKWARDS_LEFT)),
				adjacentSquares.get(BACKWARDS_RIGHT).endKingMove(new MovePath(this, BACKWARDS_RIGHT)));
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