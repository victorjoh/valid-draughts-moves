package valid.draughts.moves;

import static valid.draughts.moves.Direction.BACKWARDS_LEFT;
import static valid.draughts.moves.Direction.BACKWARDS_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;

import java.util.List;

class DarkSquareWithPlayerKing extends DarkSquareWithPlayerPiece {

	DarkSquareWithPlayerKing(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> getPlayerTurns() {
		return Draughts.concatenate(
				adjacentSquares.get(FORWARD_LEFT).movePlayerKing(new MovePath(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).movePlayerKing(new MovePath(this, FORWARD_RIGHT)),
				adjacentSquares.get(BACKWARDS_LEFT).movePlayerKing(new MovePath(this, BACKWARDS_LEFT)),
				adjacentSquares.get(BACKWARDS_RIGHT).movePlayerKing(new MovePath(this, BACKWARDS_RIGHT)));
	}
}