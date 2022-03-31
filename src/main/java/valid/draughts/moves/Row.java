package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Row {
	private List<DarkSquare> darkSquares = new ArrayList<>();

	public void add(DarkSquare darkSquare) {
		darkSquares.add(darkSquare);
	}

	public List<DarkSquare> getSquares() {
		return darkSquares;
	}

	public Optional<DarkSquare> getSquareAt(int x) {
		return darkSquares.stream()
				.filter(square -> square.getX() == x)
				.findAny();
	}
}