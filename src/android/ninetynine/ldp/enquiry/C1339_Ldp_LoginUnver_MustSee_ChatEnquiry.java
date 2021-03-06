package android.ninetynine.ldp.enquiry;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Test;
import android.ninetynine.util.Base_Test;
import android.ninetynine.util.GeneralUtilities;
import android.ninetynine.pageobjects.*;

public class C1339_Ldp_LoginUnver_MustSee_ChatEnquiry extends Base_Test {
	
	private Login login;
	private AssertEqual_List asl;
	private Homepage hp;
	private GeneralUtilities util;
	private Landing_Page ldp;
	private SearchResultPage srp;
	
	@Test
	public void C1339_LDP_LoginUnver_MustSee_Chat_Enquiry() throws Exception {
		CONFIG = new Properties();
		FileInputStream fsconf = new FileInputStream(test_data);
		CONFIG.load(fsconf);
		login = new Login(driver);
		asl = new AssertEqual_List(driver);
		hp = new Homepage(driver);
		util = new GeneralUtilities(driver);
		ldp = new Landing_Page(driver); 
		srp = new SearchResultPage(driver);
			
		
		 System.out.println("TestCase : C1339");	
		 System.out.println("Must See - Chat Enquiry for logged in, unverified user");	
		 System.out.println("---------");		 
		 System.out.println("#Given I am a logged-in, unverified user");
		wait_Long();	
		login.Click_Home_Me();
				
		if (util.verifyLogin()) {
			
		
			 System.out.println("State : Logged in");			
			 driver.swipe(620, 1114, 604, 235, 2845);
			 driver.swipe(633, 1162, 612, 493, 3771);
		     driver.swipe(597, 1204, 622, 593, 2131);
		     login.Click_MeLogout();
		     login.Click_ConfLogout();		  
		     wait_Long();		    
		     
		     
		     login.Click_Home_Me();
			 login.Click_MeLogin();
			 login.Click_Login();
			 login.InputUsername(CONFIG.getProperty("Unver_Email"));
			 login.InputPassword(CONFIG.getProperty("Unver_Pass"));
			 login.Click_ButtonLogin(); 
		     wait_Long();
	     
		     //LDP search method in SRP
		     hp.Click_HomeSale();
		     wait_Med();			
		     ldp.Click_LdpSaleResult();
			 
			 
			 srp.Click_Srp_Ldp_List();
			 System.out.println("#And I am on Must see listing detail page");
			 
			
			ldp.Click_BtEnquireNow();
			System.out.println("#When click enquire now button");	
			 
			 
			 
			 ldp.Click_BtChatWithAgent();
			 System.out.println("#And I click Chat with agent");	
			 
			 
			 try {
					assertEquals(asl.Verify_ModalChatWithAgent(), true, "#And the Chat enquiry form should display as expected");
					System.out.println("State : Chat Enquiry Form displayed as expected");
					
				} catch (Exception e){
							
					System.out.println("State : Chat Enquiry For Not Shown as expected");
					
				}

			 
			   System.out.println("#And I send enquiry"); 
			   ldp.Click_CWA_BtEnquireNow();
			   
			   
			   try {
					assertEquals(asl.Verify_SuccessModalChatWithAgent(), true, "#And the Chat enquiry form should display as expected");
					System.out.println("State : Send Enquiry success as expected");
					
				} catch (Exception e){
							
					System.out.println("State : Send Enquiry not success");
					
				}
			   
			   
			   System.out.println("#And I verify phone number"); 
			   ldp.Cwa_Input_Otp(CONFIG.getProperty("otp_unverID"));
		
			   
			   ldp.Click_BtCWABtConfirm();

		} else {
			
				System.out.println("State : Logged out");
				
				login.Click_Home_Me();
				login.Click_MeLogin();
				login.Click_Login();
				login.InputUsername(CONFIG.getProperty("Ver_Email"));
				login.InputPassword(CONFIG.getProperty("Ver_Pass"));
				login.Click_ButtonLogin();
				
				wait_Long();
				hp.Click_HomeSale();
				wait_Med();			
				
			    //LDP search method in SRP
//			     lp.Input_Sale_Search(CONFIG.getProperty("RegisteredNumberNonTsel"));
			     wait_Med();
				 ldp.Click_LdpSaleResult(); 
				 
				 srp.Click_Srp_Ldp_List(); 
				 System.out.println("#And I am on Must see listing detail page");	
				
				 
				 ldp.Click_BtEnquireNow();
				 System.out.println("#When click enquire now button");	
					
				 ldp.Click_BtChatWithAgent();
				 System.out.println("#And I click Chat with agent");	
					
				 
				 try {
						assertEquals(asl.Verify_ModalChatWithAgent(), true, "#And the Chat enquiry form should display as expected");
						System.out.println("State : Chat Enquiry Form displayed as expected");
						
					} catch (Exception e){
								
						System.out.println("State : Chat Enquiry For Not Shown as expected");
						
					}
				 
	
				   System.out.println("#And I send enquiry"); 
				   ldp.Click_CWA_BtEnquireNow();
				   
				   try {
						assertEquals(asl.Verify_SuccessModalChatWithAgent(), true, "#And the Chat enquiry form should display as expected");
						System.out.println("State : Send Enquiry success as expected");
						
					} catch (Exception e){
								
						System.out.println("State : Send Enquiry not success");
						
					}
				   
				   System.out.println("#And I verify phone number"); 
				   ldp.Cwa_Input_Otp(CONFIG.getProperty("otp_unverID"));
					
				   ldp.Click_BtCWABtConfirm();
				 
			
		}
		
		 
		wait_Med();
		
		
	}

}
