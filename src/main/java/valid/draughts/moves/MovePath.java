package valid.draughts.moves;

public class MovePath implements Path {
	private final Direction endDirection;
	private final DarkSquareWithPlayerPiece start;
	private final EmptyDarkSquare end;


	public MovePath(DarkSquareWithPlayerPiece start, Direction endDirection) {
		this.start = start;
		this.endDirection = endDirection;
		this.end = null;
	}

	public MovePath(MovePath pathSoFar, EmptyDarkSquare end) {
		this.start = pathSoFar.start;
		this.end = end;
		this.endDirection = pathSoFar.getDirection();
	}

	@Override
	public Direction getDirection() {
		return endDirection;
	}

	@Override
	public String toString() {
		return start.getId() + '-' + end.getId();
	}
}