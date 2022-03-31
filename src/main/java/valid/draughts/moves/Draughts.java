package valid.draughts.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class Draughts {
	private static final char WHITE_MAN = 'w';
	private static final char DARK_SQUARE = '_';

	public boolean someLibraryMethod() {
		return true;
	}

	public List<String> getValidMoves(PlayerColor player, String position) {
		BoardPosition boardPosition = parseBoardPosition(position);
		return boardPosition.getWhitePlayerMoves();
	}

	private BoardPosition parseBoardPosition(String boardPosition) {
		List<String> rows = Lists.reverse(boardPosition.lines().toList());
		BoardPosition boardPosition1 = new BoardPosition();

		WhiteMan whiteMan = new WhiteMan();
		for (int y = 0; y < rows.size(); y++) {
			String row = rows.get(y);
			Row currentRow = new Row();
			for (int x = 0; x < row.length(); x++) {
				switch (row.charAt(x)) {
					case DARK_SQUARE:
						currentRow.add(new DarkSquare(x, y));
						break;
					case WHITE_MAN:
						currentRow.add(new DarkSquare(x, y, whiteMan));
						break;
				}
			}
			boardPosition1.add(currentRow);
		}
		boardPosition1.linkSquares();
		return boardPosition1;
	}

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

	class WhiteMan {
		private DarkSquare square;

		public List<String> getMoves() {
			return Stream.of(square.topLeftSquare, square.topRightSquare)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.map(targetSquare -> square.getId() + "-" + targetSquare.getId())
					.toList();
		}

		public void setSquare(DarkSquare square) {
			this.square = square;
		}

	}

	class BoardPosition {
		private List<Row> rows = new ArrayList<>();

		public List<String> getWhitePlayerMoves() {
			WhiteMan whiteMan = rows.stream()
					.flatMap(row -> row.getSquares().stream())
					.filter(DarkSquare::hasWhiteMan)
					.map(DarkSquare::getPiece)
					.findFirst()
					.get();
			return whiteMan.getMoves();
		}

		public Optional<Row> getRowAt(int y) {
			return Optional.ofNullable(rows.get(y));
		}

		public void linkSquares() {
			for (int y = 0; y < rows.size() - 1; y++) {
				Row rowAbove = rows.get(y + 1);
				Row row = rows.get(y);
				row.getSquares().forEach(darkSquare -> darkSquare.linkWithRowAbove(rowAbove));
			}
		}

		public void add(Row row) {
			rows.add(row);
		}
	}

	class DarkSquare {

		private int x;
		private int y;
		private WhiteMan whiteMan;
		private Optional<DarkSquare> topLeftSquare = Optional.empty();
		private Optional<DarkSquare> topRightSquare = Optional.empty();

		DarkSquare(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		String getId() {
			return "" + x + y;
		}

		public void linkWithRowAbove(Row rowAbove) {
			topLeftSquare = rowAbove.getSquareAt(x - 1);
			topRightSquare = rowAbove.getSquareAt(x + 1);
		}

		public DarkSquare(int x, int y, WhiteMan whiteMan) {
			this.x = x;
			this.y = y;
			this.whiteMan = whiteMan;
			whiteMan.setSquare(this);
		}
		
		public boolean hasWhiteMan() {
			return whiteMan != null;
		}

		public WhiteMan getPiece() {
			return whiteMan;
		}
	}
}
