package valid.draughts.moves;

import static valid.draughts.moves.PlayerColor.WHITE;

record ParsingConfig(char playerMan, char playerKing, char opponentMan, char opponentKing, int forward) {

	static final char WHITE_MAN = 'w';
	static final char WHITE_KING = 'K';
	static final char BLACK_MAN = 'b';
	static final char BLACK_KING = 'B';
	static final char DARK_SQUARE = '_';
	private static final int UPWARDS = 1;
	private static final int DOWNWARDS = -1;

	static ParsingConfig getParsingConfig(PlayerColor player) {
		if (player.equals(WHITE)) {
			return new ParsingConfig(WHITE_MAN, WHITE_KING, BLACK_MAN, BLACK_KING, UPWARDS);
		} else {
			return new ParsingConfig(BLACK_MAN, BLACK_KING, WHITE_MAN, WHITE_KING, DOWNWARDS);
		}
	}
}
