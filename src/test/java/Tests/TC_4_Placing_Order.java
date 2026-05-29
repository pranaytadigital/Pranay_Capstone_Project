package Tests;

import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import base.Testbase;
import pages.Place_Order;
import utils.JsonDataReader;

public class TC_4_Placing_Order extends Testbase{

	@Test(dataProvider = "jsondata", dataProviderClass = JsonDataReader.class)


	public void capstoneautomation(JsonObject data) throws InterruptedException {
	String promocode = data.get("promo").getAsString();
	Place_Order Checkout = new Place_Order (driver, ui);
	Checkout.PlacingOrder(promocode);	
}
}
