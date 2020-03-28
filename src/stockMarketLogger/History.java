package stockMarketLogger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashSet;
import java.util.Set;

public class History {

		// fill result from DB into a set
		public History( ResultSet resultSet ) {
			
			this.sqlRows = new HashSet<String>();
			
			// https://stackoverflow.com/questions/24229442/print-the-data-in-resultset-along-with-column-names
			try {
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				while (resultSet.next()) {
					String newLineInDB = "";
				    for (int i = 1; i <= columnsNumber; i++) {
				        if (i > 1) newLineInDB += ",  ";
				        String columnValue = resultSet.getString(i);
				        newLineInDB += columnValue + " ";
				    }
				    // add to a set
				    this.sqlRows.add( newLineInDB );
				}
				} catch( Exception e ) {
					e.printStackTrace();
				}
		}
		
		public Set<String> getRows() {
			return this.sqlRows;
		}
		
		private Set<String> sqlRows;
}
