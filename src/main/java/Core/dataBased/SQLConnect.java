package Core.dataBased;

import utils.Constants;

import javax.ws.rs.GET;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnect  extends Constants{

	@GET
	public String getServerName()
	{
		return this.serverName;
	}
	@GET
	public String getUserName()
	{
		return this.userName;
	}
	@GET
	public String getPasswordName()
	{
		return this.passwordName;
	}

	/**
	 * Initial drivers to connect Postgre DB
	 * @param serverName   set Server Name to DB
	 * @param userName     set Login to DB
	 * @param passwordName set password to DB
	 * @return Connection parameter
	 */
	@Deprecated
	public  Connection connectPostgreaDB(String serverName, String userName, String passwordName) throws Exception {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(serverName, userName, passwordName);
	}
	/**
	 * Initial drivers to connect MySQL DB
	 * @param serverName   set Server Name to DB
	 * @param userName     set Login to DB
	 * @param passwordName set password to DB
	 * @return Connection parameter
	 */
	@Deprecated
	public  Connection connectMySQLDB(String serverName, String userName, String passwordName) throws Exception {
		Class.forName("org.mysql.Driver");
		return DriverManager.getConnection(serverName, userName, passwordName);
	}

}
