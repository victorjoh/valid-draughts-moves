package valid.draughts.moves;

import java.util.Optional;

class DarkSquare {
	private int x;
	private int y;
	private Optional<Piece> piece;
	private Optional<DarkSquare> topLeftSquare = Optional.empty();
	private Optional<DarkSquare> topRightSquare = Optional.empty();
	private Optional<DarkSquare> bottomLeftSquare = Optional.empty();
	private Optional<DarkSquare> bottomRightSquare = Optional.empty();

	DarkSquare(int x, int y) {
		this.x = x;
		this.y = y;
		this.piece = Optional.empty();
	}

	public int getX() {
		return x;
	}

	String getId() {
		return "" + x + y;
	}

	public void linkWithNeighbours(BoardPosition boardPosition) {
		topLeftSquare = boardPosition.getSquareAt(x - 1, y + 1);
		topRightSquare = boardPosition.getSquareAt(x + 1, y + 1);
		bottomLeftSquare = boardPosition.getSquareAt(x - 1, y - 1);
		bottomRightSquare = boardPosition.getSquareAt(x + 1, y - 1);
	}

	public DarkSquare(int x, int y, Piece piece) {
		this.x = x;
		this.y = y;
		this.piece = Optional.of(piece);
		piece.setSquare(this);
	}

	public boolean hasWhiteMan() {
		return piece != null;
	}

	public Optional<Piece> getPiece() {
		return piece;
	}

	public Optional<DarkSquare> getTopLeftSquare() {
		return topLeftSquare;
	}

	public Optional<DarkSquare> getTopRightSquare() {
		return topRightSquare;
	}

	public Optional<DarkSquare> getBottomLeftSquare() {
		return bottomLeftSquare;
	}

	public Optional<DarkSquare> getBottomRightSquare() {
		return bottomRightSquare;
	}
}