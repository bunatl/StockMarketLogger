package constants;

import java.util.AbstractMap;
import java.util.Map;

public class Exchnages {

	public static final Map<String, String> LIST_OF_EXCHANGES = Map.ofEntries(
		  new AbstractMap.SimpleEntry<>("NASDAQ", "https://money.cnn.com/quote/quote.html?symb="),
		  new AbstractMap.SimpleEntry<>("exchange2", "www.exch2.com"),
		  new AbstractMap.SimpleEntry<>("exchange3", "www.exch3.com"));
}