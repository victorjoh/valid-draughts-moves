package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class BoardPosition {
	private List<Piece> blackPieces = new ArrayList<>();
	private List<Piece> whitePieces = new ArrayList<>();
	private List<Row> rows = new ArrayList<>();

	List<Turn> getWhitePlayerTurns() {
		return getTurns(whitePieces);
	}

	List<Turn> getBlackPlayerTruns() {
		return getTurns(blackPieces);
	}

	private static List<Turn> getTurns(List<Piece> pieces) {
		return pieces.stream()
				.findFirst()
				.map(Piece::getPossibleTurns)
				.orElse(List.of());
	}

	Optional<Row> getRowAt(int y) {
		return Optional.ofNullable(rows.get(y));
	}

	void linkSquares() {
		rows.forEach(
				row -> row.getSquares().forEach(
						darkSquare -> darkSquare.linkWithNeighbours(this)));
	}

	void add(Row row) {
		rows.add(row);
	}

	Optional<DarkSquare> getSquareAt(int x, int y) {
		if (y < 0 || y >= rows.size()) {
			return Optional.empty();
		}

		return rows.get(y).getSquareAt(x);
	}

	void addBlackPiece(Piece piece) {
		blackPieces.add(piece);
	}

	void addWhitePiece(Piece piece) {
		whitePieces.add(piece);
	}
}