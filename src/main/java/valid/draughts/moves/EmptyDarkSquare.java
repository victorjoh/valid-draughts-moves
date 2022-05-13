package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;

class EmptyDarkSquare extends DarkSquare {

	EmptyDarkSquare(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> endManMove(MovePath pathSoFar) {
		return List.of(new Turn(new MovePath(pathSoFar, this)));
	}

	@Override
	public List<Turn> landCaptureWithMan(CapturePath pathSoFar) {
		return List.of(new Turn(new CapturePath(pathSoFar, this)));
	}

	@Override
	public List<Turn> movePlayerKing(MovePath pathSoFar) {
		List<Turn> possibleTurns = new ArrayList<>();
		MovePath pathUpToThis = new MovePath(pathSoFar, this);
		possibleTurns.add(new Turn(pathUpToThis));
		possibleTurns.addAll(adjacentSquares.get(pathSoFar.getDirection()).movePlayerKing(pathUpToThis));
		return possibleTurns;
	}
}