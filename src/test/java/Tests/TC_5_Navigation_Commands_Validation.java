package Tests;

import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import base.Testbase;
import pages.Validating_Navigation_Commands;
import utils.JsonDataReader;

public class TC_5_Navigation_Commands_Validation extends Testbase{

	@Test(dataProvider = "jsondata", dataProviderClass = JsonDataReader.class)


	public void capstoneautomation(JsonObject data) throws InterruptedException {
	Validating_Navigation_Commands Navigation = new Validating_Navigation_Commands (driver, ui);
	Navigation.Navigationcommandsvalidation();
}
}