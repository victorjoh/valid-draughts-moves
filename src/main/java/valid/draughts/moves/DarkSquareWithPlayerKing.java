package valid.draughts.moves;

import static java.util.Collections.emptyList;
import static valid.draughts.moves.Direction.BACKWARD_LEFT;
import static valid.draughts.moves.Direction.BACKWARD_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;
import static valid.draughts.moves.Lists.concatenate;

import java.util.List;

class DarkSquareWithPlayerKing extends DarkSquareWithPlayerPiece {

	DarkSquareWithPlayerKing(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> getPlayerTurns() {
		return concatenate(
				move(FORWARD_LEFT),
				move(FORWARD_RIGHT),
				move(BACKWARD_LEFT),
				move(BACKWARD_RIGHT),
				capture(FORWARD_LEFT),
				capture(FORWARD_RIGHT),
				capture(BACKWARD_LEFT),
				capture(BACKWARD_RIGHT));
	}

	private List<Turn> move(Direction direction) {
		return getAdjacentSquare(direction).moveKing(new MoveTurn(this, direction));
	}

	private List<Turn> capture(Direction direction) {
		return getAdjacentSquare(direction).jumpOverWithKing(new CaptureTurn(this, direction));
	}

	@Override
	public List<Turn> jumpOverWithKing(CaptureTurn turnSoFar) {
		if (turnSoFar.startsWith(this)) {
			return asEmptySquare().jumpOverWithKing(turnSoFar);
		} else {
			return emptyList();
		}
	}

	@Override
	public List<Turn> landCaptureWithKing(CaptureTurn turnSoFar) {
		if (turnSoFar.startsWith(this)) {
			return asEmptySquare().landCaptureWithKing(turnSoFar);
		} else {
			return emptyList();
		}
	}
}