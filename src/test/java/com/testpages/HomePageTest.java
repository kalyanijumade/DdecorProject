package com.testpages;

import org.testng.annotations.Test;

import com.baseclass.TestBase;

public class HomePageTest extends TestBase {
	
	
	@Test
	public void homePageLuanch() {
		
		driver.get(pro.getProperty("URL"));
	}

}
