package Tests;

import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import base.Testbase;
import pages.Add_Multiple_Product_To_Cart;
import utils.JsonDataReader;

public class TC_3_Adding_Multiple_Products extends Testbase{

	@Test(dataProvider = "jsondata", dataProviderClass = JsonDataReader.class)
	

	public void capstoneautomation(JsonObject data) throws InterruptedException {
	Add_Multiple_Product_To_Cart addmultipletocart = new Add_Multiple_Product_To_Cart (driver, ui);
	addmultipletocart.Addingmultipleproducttocart();	
}
}
