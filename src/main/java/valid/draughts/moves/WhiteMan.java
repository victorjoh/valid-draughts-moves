package valid.draughts.moves;

import java.util.Optional;

class WhiteMan extends Man {

	@Override
	Optional<DarkSquare> getForwardLeftSquare() {
		return square.getTopLeftSquare();
	}

	@Override
	Optional<DarkSquare> getForwardRightSquare() {
		return square.getTopRightSquare();
	}
}