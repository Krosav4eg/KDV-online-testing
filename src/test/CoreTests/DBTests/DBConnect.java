package DBTests;

import dataBased.SQLConnect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DBConnect extends SQLConnect{

	@Test
	public void MySQLConnectTest() throws Exception
	{
		Assert.assertNotNull(connectMySQLDB(getServerName(),getUserName(),getPasswordName()));
	}
	//TODO DB is absent
//	@Test
//	public void PostgreConnectTest()
//	{
//		new SQLConnect().connectPostgreaDB()
//	}
}
