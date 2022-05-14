package valid.draughts.moves;

import java.util.ArrayList;
import java.util.Collection;
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
		CaptureTurn turnEndingHere = new CaptureTurn(pathSoFar, this);
		List<Turn> possibleTurns = new ArrayList<>();
		possibleTurns.add(turnEndingHere);
		possibleTurns.addAll(getAdjacentSquares().stream()
				.filter(adjacent -> !adjacent.getDirection().equals(pathSoFar.getDirection().getOpposite()))
				.map(adjacent -> adjacent.jumpOverWithMan(new CaptureTurn(turnEndingHere, adjacent.getDirection())))
				.flatMap(Collection::stream)
				.toList());
		return possibleTurns;
	}

	@Override
	public List<Turn> moveKing(MoveTurn turnSoFar) {
		MoveTurn turnEndingHere = new MoveTurn(turnSoFar, this);
		List<Turn> possibleTurns = new ArrayList<>();
		possibleTurns.add(turnEndingHere);
		possibleTurns.addAll(getAdjacentSquare(turnSoFar.getDirection()).moveKing(turnEndingHere));
		return possibleTurns;
	}

	@Override
	public List<Turn> landCaptureWithKing(CaptureTurn turnSoFar) {
		List<Turn> possibleTurns = new ArrayList<>();
		possibleTurns.add(new CaptureTurn(turnSoFar, this));
		possibleTurns.addAll(getAdjacentSquare(turnSoFar.getDirection()).landCaptureWithKing(turnSoFar));
		return possibleTurns;
	}
}