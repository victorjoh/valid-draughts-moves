package valid.draughts.moves;

import static valid.draughts.moves.Direction.BACKWARD_LEFT;
import static valid.draughts.moves.Direction.BACKWARD_RIGHT;
import static valid.draughts.moves.Direction.FORWARD_LEFT;
import static valid.draughts.moves.Direction.FORWARD_RIGHT;

import java.util.List;

class DarkSquareWithPlayerMan extends DarkSquareWithPlayerPiece {

	public DarkSquareWithPlayerMan(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> getPlayerTurns() {
		return ListUtil.concatenate(
				adjacentSquares.get(FORWARD_LEFT).endManMove(new MoveTurn(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).endManMove(new MoveTurn(this, FORWARD_RIGHT)),
				adjacentSquares.get(FORWARD_LEFT).jumpOverWithMan(new CaptureTurn(this, FORWARD_LEFT)),
				adjacentSquares.get(FORWARD_RIGHT).jumpOverWithMan(new CaptureTurn(this, FORWARD_RIGHT)),
				adjacentSquares.get(BACKWARD_LEFT).jumpOverWithMan(new CaptureTurn(this, BACKWARD_LEFT)),
				adjacentSquares.get(BACKWARD_RIGHT).jumpOverWithMan(new CaptureTurn(this, BACKWARD_RIGHT)));
	}
}