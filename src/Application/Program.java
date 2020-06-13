package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection _conn = null;
		PreparedStatement _st = null;
		
		try {
			_conn = DB.getConnection();
			_st = _conn.prepareStatement("Update Seller"
					+" SET BaseSalary=BaseSalary+?"
					+" Where "
					+"(DepartmentId = ?)");
			
			_st.setDouble(1, 200.0);
			_st.setInt(2, 2);
			
			int RowsAffected = _st.executeUpdate();
			
			System.out.println("Done! "+RowsAffected);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(_st);
			DB.closeConnection();
		}
	}
}
