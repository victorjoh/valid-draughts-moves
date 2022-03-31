package valid.draughts.moves;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


abstract class Man implements Piece {
	DarkSquare square;

	@Override
	public List<String> getMoves() {
		return Stream.of(getForwardLeftSquare(), getForwardRightSquare())
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(targetSquare -> square.getId() + "-" + targetSquare.getId())
				.toList();
	}

	abstract Optional<DarkSquare> getForwardLeftSquare();

	abstract Optional<DarkSquare> getForwardRightSquare();

	@Override
	public void setSquare(DarkSquare square) {
		this.square = square;
	}

}
