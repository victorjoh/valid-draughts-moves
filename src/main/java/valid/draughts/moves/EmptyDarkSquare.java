package valid.draughts.moves;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

class EmptyDarkSquare implements DarkSquare {
	private final Map<Direction, Square> adjacentSquares = new EnumMap<>(Direction.class);
	private final int x;
	private final int y;

	public EmptyDarkSquare(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setAdjacentSquare(Direction fromThisSquare, Square adjecentSquare) {
		adjacentSquares.put(fromThisSquare, adjecentSquare);
	}

	@Override
	public List<Turn> endManMove(MovePath pathSoFar) {
		return List.of(new Turn(new MovePath(pathSoFar, this)));
	}

	@Override
	public List<Turn> jumpOverWithMan(CapturePath pathSoFar) {
		return emptyList();
	}

	@Override
	public List<Turn> landCaptureWithMan(CapturePath pathSoFar) {
		return List.of(new Turn(new CapturePath(pathSoFar, this)));
	}

	@Override
	public List<Turn> endKingMove(MovePath pathSoFar) {
		List<Turn> possibleTurns = new ArrayList<>();
		MovePath pathUpToThis = new MovePath(pathSoFar, this);
		possibleTurns.add(new Turn(pathUpToThis));
		possibleTurns.addAll(adjacentSquares.get(pathSoFar.getDirection()).endKingMove(pathUpToThis));
		return possibleTurns;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}