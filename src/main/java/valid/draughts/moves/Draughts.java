package valid.draughts.moves;

import static valid.draughts.moves.PlayerColor.WHITE;

import java.util.List;

import com.google.common.collect.Lists;

public class Draughts {
	private static final char WHITE_MAN = 'w';
	private static final char WHITE_KING = 'K';
	private static final char BLACK_MAN = 'b';
	private static final char DARK_SQUARE = '_';

	public boolean someLibraryMethod() {
		return true;
	}

	public List<String> getValidMoves(PlayerColor player, String position) {
		BoardPosition boardPosition = parseBoardPosition(position);
		if (player == WHITE) {
			return boardPosition.getWhitePlayerMoves();
		} else {
			return boardPosition.getBlackPlayerMoves();
		}
	}

	private BoardPosition parseBoardPosition(String boardPosition) {
		List<String> rows = Lists.reverse(boardPosition.lines().toList());
		BoardPosition parsedBoardPosition = new BoardPosition();

		for (int y = 0; y < rows.size(); y++) {
			String row = rows.get(y);
			Row currentRow = new Row();
			for (int x = 0; x < row.length(); x++) {
				switch (row.charAt(x)) {
					case DARK_SQUARE:
						currentRow.add(new DarkSquare(x, y));
						break;
					case WHITE_MAN:
						WhiteMan whiteMan = new WhiteMan();
						currentRow.add(new DarkSquare(x, y, whiteMan));
						parsedBoardPosition.addWhitePiece(whiteMan);
						break;
					case WHITE_KING:
						WhiteMan whiteKing = new WhiteMan();
						currentRow.add(new DarkSquare(x, y, whiteKing));
						parsedBoardPosition.addWhitePiece(whiteKing);
						break;
					case BLACK_MAN:
						BlackMan blackMan = new BlackMan();
						currentRow.add(new DarkSquare(x, y, blackMan));
						parsedBoardPosition.addBlackPiece(blackMan);
						break;
					default:
						// ignore other characters
				}
			}
			parsedBoardPosition.add(currentRow);
		}
		parsedBoardPosition.linkSquares();
		return parsedBoardPosition;
	}
}