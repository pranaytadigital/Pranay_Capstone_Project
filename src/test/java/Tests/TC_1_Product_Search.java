package Tests;

import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import base.Testbase;
import pages.Search_Product;
import utils.JsonDataReader;

public class TC_1_Product_Search extends Testbase{

	@Test(dataProvider = "jsondata", dataProviderClass = JsonDataReader.class)
	

	public void capstoneautomation(JsonObject data) throws InterruptedException {
		String search = data.get("searchtext").getAsString();
		Search_Product searchpro =new Search_Product (driver, ui);
		searchpro.Searchingproduct(search);
}
}
