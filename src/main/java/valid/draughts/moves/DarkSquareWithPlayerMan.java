package valid.draughts.moves;

import static valid.draughts.moves.Direction.BACKWARD_LEFT;
import static valid.draughts.moves.Direction.BACKWARD_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;
import static valid.draughts.moves.Lists.concatenate;

import java.util.List;

class DarkSquareWithPlayerMan extends DarkSquareWithPlayerPiece {

	public DarkSquareWithPlayerMan(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> getPlayerTurns() {
		return concatenate(
				move(FORWARD_LEFT),
				move(FORWARD_RIGHT),
				capture(FORWARD_LEFT),
				capture(FORWARD_RIGHT),
				capture(BACKWARD_LEFT),
				capture(BACKWARD_RIGHT));
	}

	private List<Turn> move(Direction direction) {
		return getAdjacentSquare(direction).endManMove(new MoveTurn(this, direction));
	}

	private List<Turn> capture(Direction direction) {
		return getAdjacentSquare(direction).jumpOverWithMan(new CaptureTurn(this, direction));
	}
}