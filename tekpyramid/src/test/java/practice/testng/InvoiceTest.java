package practice.testng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseclassutility.BaseClass;

import junit.framework.Assert;
//@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass {

	//@Test
	public void createInvoice() {
		System.out.println("Execute createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	//@Test
	public void createInvoiceWithContactTest() {
		System.out.println("Execute createInvoiceWithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImpl.class)
	public void activateSime() {
		System.out.println("Execute activateSim");
		Assert.fail();
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
