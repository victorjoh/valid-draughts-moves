package valid.draughts.moves;

public class MoveTurn implements Turn {
	private final Direction endDirection;
	private final DarkSquareWithPlayerPiece start;
	private final EmptyDarkSquare end;

	public MoveTurn(DarkSquareWithPlayerPiece start, Direction endDirection) {
		this.start = start;
		this.endDirection = endDirection;
		this.end = null;
	}

	public MoveTurn(MoveTurn pathSoFar, EmptyDarkSquare end) {
		this.start = pathSoFar.start;
		this.end = end;
		this.endDirection = pathSoFar.getDirection();
	}

	@Override
	public int getNbrOfCaptures() {
		return 0;
	}

	@Override
	public Direction getDirection() {
		return endDirection;
	}

	@Override
	public String toString() {
		if (end == null) {
			return start.getId();
		}

		return start.getId() + '-' + end.getId();
	}
}