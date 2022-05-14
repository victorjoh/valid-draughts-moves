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
				adjacentSquares.get(FORWARD_LEFT).moveKing(new MoveTurn(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).moveKing(new MoveTurn(this, FORWARD_RIGHT)),
				adjacentSquares.get(BACKWARD_LEFT).moveKing(new MoveTurn(this, BACKWARD_LEFT)),
				adjacentSquares.get(BACKWARD_RIGHT).moveKing(new MoveTurn(this, BACKWARD_RIGHT)),
				adjacentSquares.get(FORWARD_LEFT).jumpOverWithKing(new CaptureTurn(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).jumpOverWithKing(new CaptureTurn(this, FORWARD_RIGHT)),
				adjacentSquares.get(BACKWARD_LEFT).jumpOverWithKing(new CaptureTurn(this, BACKWARD_LEFT)),
				adjacentSquares.get(BACKWARD_RIGHT).jumpOverWithKing(new CaptureTurn(this, BACKWARD_RIGHT)));
	}
}