package stockMarketLogger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashSet;
import java.util.Set;

public class History {

		public History( ResultSet resultSet ) {
			
			this.sqlRows = new HashSet<String>();
			
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
