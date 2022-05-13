package valid.draughts.moves;

import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;

import java.util.List;

class DarkSquareWithPlayerMan extends DarkSquareWithPlayerPiece {

	public DarkSquareWithPlayerMan(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> getPlayerTurns() {
		return Draughts.concatenate(
				adjacentSquares.get(FORWARD_LEFT).endManMove(new MovePath(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).endManMove(new MovePath(this, FORWARD_RIGHT)),
				adjacentSquares.get(FORWARD_RIGHT).jumpOverWithMan(new CapturePath(this, FORWARD_RIGHT)));
	}
}