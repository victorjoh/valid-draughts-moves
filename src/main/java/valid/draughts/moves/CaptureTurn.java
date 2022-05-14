package valid.draughts.moves;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class CaptureTurn implements Turn {
	private final Direction endDirection;
	private final List<DarkSquare> checkpoints = new ArrayList<>();

	public CaptureTurn(CaptureTurn turnSoFar, EmptyDarkSquare landingSquare) {
		this.endDirection = turnSoFar.getDirection();
		this.checkpoints.addAll(turnSoFar.checkpoints);
		this.checkpoints.add(landingSquare);
	}

	public CaptureTurn(CaptureTurn turnSoFar, Direction endDirection) {
		this.endDirection = endDirection;
		this.checkpoints.addAll(turnSoFar.checkpoints);
	}

	public CaptureTurn(DarkSquareWithPlayerPiece startSquare, Direction endDirection) {
		this.endDirection = endDirection;
		this.checkpoints.add(startSquare);
	}

	@Override
	public int getNbrOfCaptures() {
		return checkpoints.size() - 1;
	}

	@Override
	public Direction getDirection() {
		return endDirection;
	}

	@Override
	public String toString() {
		return checkpoints.stream()
				.map(DarkSquare::getId)
				.collect(joining("x"));
	}
}