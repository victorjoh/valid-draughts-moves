package valid.draughts.moves;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static valid.draughts.moves.Lists.concatenate;

import java.util.List;

public class CaptureTurn implements Turn {
	private final Direction endDirection;
	private final List<DarkSquare> checkpoints;
	private final List<DarkSquareWithOpponentPiece> captures;

	public CaptureTurn(DarkSquareWithPlayerPiece startSquare, Direction endDirection) {
		this(endDirection, List.of(startSquare), emptyList());
	}

	private CaptureTurn(Direction endDirection, List<DarkSquare> checkpoints, List<DarkSquareWithOpponentPiece> captures) {
		this.endDirection = endDirection;
		this.checkpoints = checkpoints;
		this.captures = captures;
	}

	CaptureTurn addCheckpoint(DarkSquare landingSquare) {
		return new CaptureTurn(endDirection, concatenate(checkpoints, List.of(landingSquare)), captures);
	}

	CaptureTurn redirect(Direction newEndDirection) {
		return new CaptureTurn(newEndDirection, checkpoints, captures);
	}

	CaptureTurn addCapture(DarkSquareWithOpponentPiece playerPieceSquare) {
		return new CaptureTurn(endDirection, checkpoints, concatenate(captures, List.of(playerPieceSquare)));
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

	public boolean startsWith(DarkSquareWithPlayerPiece playerPieceSquare) {
		return checkpoints.get(0) == playerPieceSquare;
	}

	public boolean isCaptured(DarkSquareWithOpponentPiece opponentPieceSquare) {
		return captures.contains(opponentPieceSquare);
	}

}