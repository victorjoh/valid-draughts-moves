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
	public List<Turn> movePlayerKing(MoveTurn turnSoFar) {
		List<Turn> possibleTurns = new ArrayList<>();
		MoveTurn turnEndingHere = new MoveTurn(turnSoFar, this);
		possibleTurns.add(turnEndingHere);
		possibleTurns.addAll(adjacentSquares.get(turnSoFar.getEndDirection()).movePlayerKing(turnEndingHere));
		return possibleTurns;
	}

	@Override
	public List<Turn> landCaptureWithKing(CaptureTurn turnSoFar) {
		List<Turn> possibleTurns = new ArrayList<>();
		possibleTurns.add(new CaptureTurn(turnSoFar, this));
		possibleTurns.addAll(adjacentSquares.get(turnSoFar.getEndDirection()).landCaptureWithKing(turnSoFar));
		return possibleTurns;
	}
}