package valid.draughts.moves;

public class MovePath implements Path {
	private final Direction endDirection;
	private DarkSquareWithMyPiece start;
	private EmptyDarkSquare end;


	public MovePath(DarkSquareWithMyPiece start, Direction endDirection) {
		this.start = start;
		this.endDirection = endDirection;
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
		return "" + start.getX() + start.getY() + '-' + end.getX() + end.getY();
	}
}