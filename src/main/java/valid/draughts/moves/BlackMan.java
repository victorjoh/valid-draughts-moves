package valid.draughts.moves;

import java.util.Optional;

class BlackMan extends Man {

	@Override
	Optional<DarkSquare> getForwardLeftSquare() {
		return square.getBottomLeftSquare();
	}

	@Override
	Optional<DarkSquare> getForwardRightSquare() {
		return square.getBottomRightSquare();
	}
}