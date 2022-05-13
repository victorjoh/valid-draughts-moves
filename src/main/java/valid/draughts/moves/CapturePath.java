package valid.draughts.moves;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class CapturePath implements Path {
	private final Direction endDirection;
	private final List<DarkSquare> checkpoints = new ArrayList<>();

	public CapturePath(Direction endDirection) {
		this.endDirection = endDirection;
	}

	public CapturePath(CapturePath pathSoFar, EmptyDarkSquare landingSquare) {
		this.endDirection = pathSoFar.getDirection();
		this.checkpoints.addAll(pathSoFar.checkpoints);
		this.checkpoints.add(landingSquare);
	}

	public CapturePath(DarkSquareWithMyMan startSquare, Direction endDirection) {
		this.endDirection = endDirection;
		this.checkpoints.add(startSquare);
	}

	@Override
	public Direction getDirection() {
		return endDirection;
	}

	@Override
	public String toString() {
		return checkpoints.stream()
				.map(square -> "" + square.getX() + square.getY())
				.collect(joining("x"));
	}
}