package Tests;

import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import base.Testbase;
import pages.Add_To_Cart;
import utils.JsonDataReader;

public class TC_2_Product_Add_To_Cart extends Testbase{
	
	@Test(dataProvider = "jsondata", dataProviderClass = JsonDataReader.class)


	public void capstoneautomation(JsonObject data) throws InterruptedException {
		Add_To_Cart addtocart = new Add_To_Cart (driver, ui);
		addtocart.Addingproducttocart();
}
}
