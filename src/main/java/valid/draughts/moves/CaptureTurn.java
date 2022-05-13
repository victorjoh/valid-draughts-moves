package valid.draughts.moves;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class CaptureTurn implements Turn {
	private final Direction endDirection;
	private final List<DarkSquare> checkpoints = new ArrayList<>();

	public CaptureTurn(CaptureTurn turnSoFar, EmptyDarkSquare landingSquare) {
		this.endDirection = turnSoFar.getEndDirection();
		this.checkpoints.addAll(turnSoFar.checkpoints);
		this.checkpoints.add(landingSquare);
	}

	public CaptureTurn(DarkSquareWithPlayerPiece startSquare, Direction endDirection) {
		this.endDirection = endDirection;
		this.checkpoints.add(startSquare);
	}

	@Override
	public Direction getEndDirection() {
		return endDirection;
	}

	@Override
	public String toString() {
		return checkpoints.stream()
				.map(DarkSquare::getId)
				.collect(joining("x"));
	}
}