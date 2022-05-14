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
		possibleTurns.addAll(adjacentSquares.entrySet().stream()
				.filter(entry -> !entry.getKey().equals(pathSoFar.getEndDirection().getOpposite()))
				.map(entry -> entry.getValue().jumpOverWithMan(new CaptureTurn(turnEndingHere, entry.getKey())))
				.flatMap(Collection::stream)
				.toList());
		return possibleTurns;
	}

	@Override
	public List<Turn> moveKing(MoveTurn turnSoFar) {
		MoveTurn turnEndingHere = new MoveTurn(turnSoFar, this);
		List<Turn> possibleTurns = new ArrayList<>();
		possibleTurns.add(turnEndingHere);
		possibleTurns.addAll(adjacentSquares.get(turnSoFar.getEndDirection()).moveKing(turnEndingHere));
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