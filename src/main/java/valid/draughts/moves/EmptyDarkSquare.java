package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;

class EmptyDarkSquare extends DarkSquare {

	EmptyDarkSquare(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Turn> endManMove(MoveTurn pathSoFar) {
		return List.of(new MoveTurn(pathSoFar, this));
	}

	@Override
	public List<Turn> landCaptureWithMan(CaptureTurn pathSoFar) {
		return List.of(new CaptureTurn(pathSoFar, this));
	}

	@Override
	public List<Turn> movePlayerKing(MoveTurn pathSoFar) {
		List<Turn> possibleTurns = new ArrayList<>();
		MoveTurn turnEndingHere = new MoveTurn(pathSoFar, this);
		possibleTurns.add(turnEndingHere);
		possibleTurns.addAll(adjacentSquares.get(pathSoFar.getEndDirection()).movePlayerKing(turnEndingHere));
		return possibleTurns;
	}
}