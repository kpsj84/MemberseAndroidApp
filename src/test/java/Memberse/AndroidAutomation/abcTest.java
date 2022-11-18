package Memberse.AndroidAutomation;

import org.testng.annotations.Test;

import SoFaDog.AndroidAutomation.Base;

public class abcTest extends Base {
	
	@Test
	public void abcTestCase() throws InterruptedException {
		
		Thread.sleep(30000);
		
		boolean QA = true;
		boolean Prod = false;
			
		if(QA == true)
		{
			System.out.println("1");
		}
		else if(Prod == true)
		{
			System.out.println("2");
		}
		
		if(QA == true || Prod == true)
		{
			System.out.println("3");
		}
	}

}
