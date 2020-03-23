package stockMarketLogger;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import constants.Exchnages;

public class Stock {

	public Stock( String stockCode ) throws IOException{
		this.stockCode = stockCode;
		this.baseURL = constants.Exchnages.LIST_OF_EXCHANGES.get( "NASDAQ" );
		parseHTML();
	} 
	
	public String getStockName() {		
		return this.stockName;
	}
		
	public double getStockPrice() {
		return this.stockPrice;
	}
	
//	private String pageHTML;
	private String baseURL;
	private String stockCode;
	private String stockName;
	private double stockPrice;
	
	private boolean parseHTML() throws IOException {
		String url = this.baseURL + this.stockCode;
				
		Document doc = Jsoup.connect( url ).get();
		
		setStockPrice( doc );
		setStockName( doc );
		return true;
	}
	
	private void setStockName( Document doc ) {
		this.stockName = doc.select("h1.wsod_fLeft.wsod_narrowH1Container").first().text();
	}
		
	private void setStockPrice( Document doc ) {
		this.stockPrice = Double.parseDouble( doc.select("td.wsod_last span").first().text() );
	}
}
