package dataBased;

import javax.ws.rs.GET;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Constants;

public class PostgreSQL extends Constants{
	@GET
	public String getServerName()
	{
		return serverName;
	}
	@GET
	public String getUserName()
	{
		return userName;
	}
	@GET
	public String getPasswordName()
	{
		return passwordName;
	}

	/**
	 * Initial drivers to connect Postgre DB
	 * @param serverName   set Server Name to DB
	 * @param userName     set Login to DB
	 * @param passwordName set password to DB
	 * @return Connection parameter
	 */
	protected static Connection connectPostgre(String serverName, String userName, String passwordName) throws Exception {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(serverName, userName, passwordName);
	}

	/**
	 * Read SQL statements
	 * @param sqlRequest - sql request example "select * from life "
	 * @return ResultSet -all data from sql request
	 */
	public ResultSet readSQL(String sqlRequest) throws Exception {
		Connection connect = connectPostgre(getServerName(), getUserName(), getPasswordName());
		Statement statement = connect.createStatement();
		ResultSet rs = statement.executeQuery(sqlRequest);
		return rs;
	}

	/**
	 * @param sql - sql request example "select * from life "
	 * @return JSONObject with <5 JSONArray in each array exist column of sql
	 */
	protected JSONObject getJSONResult(String sql) throws Exception {
		ResultSet rs = readSQL(sql);
		JSONArray dataFirstSQL= new JSONArray();
		JSONArray dataSecondSQL= new JSONArray();
		JSONArray dataThirdSQL= new JSONArray();
		JSONArray dataFourthSQL= new JSONArray();
		JSONArray dataFiveSQL= new JSONArray();
		int i=getSqlParametric(sql);
		int j=0;
		while (rs.next()) {
			switch (i) {
				case 5: {
					dataFiveSQL.put(j, rs.getObject(5));
				}
				case 4: {
					dataFourthSQL.put(j, rs.getObject(4));
				}
				case 3: {
					dataThirdSQL.put(j, rs.getObject(3));
				}
				case 2: {
					dataSecondSQL.put(j, rs.getObject(2));
				}
				case 1: {
					dataFirstSQL.put(j, rs.getObject(1));
				}
			}
			j++;
		}
		JSONObject dataSQL= new JSONObject();
		if(dataFirstSQL.isNull(0))
		{dataFirstSQL.put(0,0);}
		if(dataSecondSQL.isNull(0))
		{dataSecondSQL.put(0,0);}
		if(dataThirdSQL.isNull(0))
		{dataThirdSQL.put(0,0);}
		if(dataFourthSQL.isNull(0))
		{dataFourthSQL.put(0,0);}
		dataSQL.put("first_data",dataFirstSQL);
		dataSQL.put("second_data",dataSecondSQL);
		dataSQL.put("third_data",dataThirdSQL);
		dataSQL.put("fourth_data",dataFourthSQL);
		dataSQL.put("five_data",dataFiveSQL);
		System.out.println(dataSQL);
		return  dataSQL;
	}

	/**Parsed SQL request
	 * @param sql- sql request example "select test1,test2,test3 from life "
	 * @return counter of parameters example 3
	 */
	private int getSqlParametric(String sql)
	{
		sql = sql.toLowerCase();
		String delims = "[ ,]";
		String[] tokens = sql.split(delims);
		int j=0;
		while (!tokens[j+1].contains("from"))
		{
			j++;
		}
		return j;
	}
}
