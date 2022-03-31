package valid.draughts.moves;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


abstract class Man implements Piece {
	DarkSquare square;

	@Override
	public List<Turn> getPossibleTurns() {
		return Stream.of(getForwardLeftSquare(), getForwardRightSquare())
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(this::getTurn)
				.toList();
	}

	private Turn getTurn(DarkSquare targetSquare) {
		if (targetSquare.getPiece().isPresent()) {
			return new Move(square, targetSquare.getTopRightSquare().get());
		}
		return new Move(square, targetSquare);
	}

	abstract Optional<DarkSquare> getForwardLeftSquare();

	abstract Optional<DarkSquare> getForwardRightSquare();

	@Override
	public void setSquare(DarkSquare square) {
		this.square = square;
	}
}
