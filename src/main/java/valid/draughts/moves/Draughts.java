package valid.draughts.moves;

import static valid.draughts.moves.ParsingConfig.getParsingConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public class Draughts {

	public static List<String> getValidMoves(PlayerColor player, String position) {
		return parseBoardPosition(player, position).stream()
				.map(DarkSquareWithPlayerPiece::getPlayerTurns)
				.flatMap(Collection::stream)
				.map(Object::toString)
				.toList();
	}

	private static List<DarkSquareWithPlayerPiece> parseBoardPosition(PlayerColor player, String position) {
		List<String> rows = Lists.reverse(position.lines().toList());
		ParsingConfig config = getParsingConfig(player);
		BoardPosition parsedBoard = new BoardPosition(config);

		for (int y = 0; y < rows.size(); y++) {
			String row = rows.get(y);
			List<DarkSquare> parsedRow = new ArrayList<>();
			for (int x = 0; x < row.length(); x++) {
				if (row.charAt(x) == ParsingConfig.DARK_SQUARE) {
					parsedRow.add(new EmptyDarkSquare(x, y));
				} else if (row.charAt(x) == config.playerMan()) {
					DarkSquareWithPlayerMan darkSquareWithMyMan = new DarkSquareWithPlayerMan(x, y);
					parsedRow.add(darkSquareWithMyMan);
					parsedBoard.addPlayerPiece(darkSquareWithMyMan);
				} else if (row.charAt(x) == config.playerKing()) {
					DarkSquareWithPlayerKing darkSquareWithMyKing = new DarkSquareWithPlayerKing(x, y);
					parsedRow.add(darkSquareWithMyKing);
					parsedBoard.addPlayerPiece(darkSquareWithMyKing);
				} else if (row.charAt(x) == config.opponentMan() || row.charAt(x) == config.opponentKing()) {
					parsedRow.add(new DarkSquareWithOpponentPiece(x, y));
				}
			}
			parsedBoard.addRow(parsedRow);
		}
		
		parsedBoard.linkSquares();

		return parsedBoard.getPlayerPieces();
	}
}
