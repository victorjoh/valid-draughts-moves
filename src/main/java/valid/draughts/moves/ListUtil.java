package valid.draughts.moves;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ListUtil {

	@SafeVarargs
	public static <T> List<T> concatenate(List<T>... lists) {
		return Stream.of(lists)
				.flatMap(Collection::stream)
				.toList();
	}
}
