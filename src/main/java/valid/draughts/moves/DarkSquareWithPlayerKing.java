package valid.draughts.moves;

import static valid.draughts.moves.Direction.BACKWARD_LEFT;
import static valid.draughts.moves.Direction.BACKWARD_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;

import java.util.List;

class DarkSquareWithPlayerKing extends DarkSquareWithPlayerPiece {

	DarkSquareWithPlayerKing(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> getPlayerTurns() {
		return ListUtil.concatenate(
				adjacentSquares.get(FORWARD_LEFT).movePlayerKing(new MoveTurn(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).movePlayerKing(new MoveTurn(this, FORWARD_RIGHT)),
				adjacentSquares.get(BACKWARD_LEFT).movePlayerKing(new MoveTurn(this, BACKWARD_LEFT)),
				adjacentSquares.get(BACKWARD_RIGHT).movePlayerKing(new MoveTurn(this, BACKWARD_RIGHT)));
	}
}