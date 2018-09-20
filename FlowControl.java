package com.demo.tebtQuotePages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class FlowControl {


	public void executeSteps(List<HashMap<String,String>>scenariotestData,List<ArrayList<String>> AllSteps, String TestcaseID,WebDriver driver) {
		LoginPage login= new LoginPage(driver);
		QuoteCreationPage quote= new QuoteCreationPage(driver);
		
		ProposerCKYCpage ckycPage= new ProposerCKYCpage(driver);;
		PersonalDetails personaldetails=new PersonalDetails(driver);;
		ContactInformation contactInformation= new ContactInformation(driver);
		ContactInfoPermanantAddress permanantAddress= new ContactInfoPermanantAddress(driver);
		ContactInfoEmploymentDetails employmentDetails= new ContactInfoEmploymentDetails(driver);
		AdditionalDetails additionalDetails= new AdditionalDetails(driver);
		CommunicationPreferences communicationPreferences= new CommunicationPreferences(driver);
		ProposerDetails proposerDetails= new ProposerDetails(driver);;
		MagnumPage magnumpage= new MagnumPage(driver);
		PaymentPage paymentPage= new PaymentPage(driver);
		QuoteCreationCP2CDPLUS cp23cdQuote= new QuoteCreationCP2CDPLUS(driver);
		
		
		for(ArrayList<String> steps:AllSteps) {

				String stepName=steps.get(2).toString();
				String executeFlag=steps.get(1).toString();

				if(stepName.equalsIgnoreCase("Login") && executeFlag.equalsIgnoreCase("Yes") )	
					login.loginDetails(scenariotestData,"Login",TestcaseID);
				
				if(stepName.equalsIgnoreCase("QuoteCreation") && executeFlag.equalsIgnoreCase("Yes"))	
					quote.createNewQuote(scenariotestData,"QuoteCreation",TestcaseID);
				
				if(stepName.equalsIgnoreCase("QuoteCreationCP2CDPLUS") && executeFlag.equalsIgnoreCase("Yes"))	
					cp23cdQuote.createNewQuote(scenariotestData,"QuoteCreation",TestcaseID);
				
				
				
				if(stepName.equalsIgnoreCase("ProposerCKYCpage") && executeFlag.equalsIgnoreCase("Yes"))	
					ckycPage.fillCKYCpage(scenariotestData,"ProposerCKYCpage",TestcaseID);

				if(stepName.equalsIgnoreCase("PersonalDetails") && executeFlag.equalsIgnoreCase("Yes"))	
					personaldetails.fillpersonalDetails(scenariotestData,"PersonalDetails",TestcaseID);

				if(stepName.equalsIgnoreCase("ContactInfo") && executeFlag.equalsIgnoreCase("Yes"))	
					contactInformation.fillContactInformation(scenariotestData,"ContactInfo",TestcaseID);
				
				if(stepName.equalsIgnoreCase("ContactInfoPermanantAddress") && executeFlag.equalsIgnoreCase("Yes"))	
					permanantAddress.fillpermanantAddress(scenariotestData,"ContactInfoPermanantAddress",TestcaseID);
				
				if(stepName.equalsIgnoreCase("CommunicationPreferences") && executeFlag.equalsIgnoreCase("Yes"))	
					communicationPreferences.fillCommunicationPreferences(scenariotestData,"CommunicationPreferences",TestcaseID);
				
				if(stepName.equalsIgnoreCase("ContactInfoEmploymentDetails") && executeFlag.equalsIgnoreCase("Yes"))	
					employmentDetails.fillContactInfoEmploymentDetails(scenariotestData,"ContactInfoEmploymentDetails",TestcaseID);
				
				if(stepName.equalsIgnoreCase("ProposerDetails") && executeFlag.equalsIgnoreCase("Yes"))	
					proposerDetails.fillProposerDetails(scenariotestData,"ProposerDetails",TestcaseID);
				
				if(stepName.equalsIgnoreCase("MagnumDetails") && executeFlag.equalsIgnoreCase("Yes"))	
					magnumpage.fillMagnumDetails(scenariotestData,"MagnumDetails",TestcaseID);
				
				if(stepName.equalsIgnoreCase("PaymentDetails") && executeFlag.equalsIgnoreCase("Yes"))	
					paymentPage.fillPaymentDetails(scenariotestData,"PaymentDetails",TestcaseID);



		}


	}

}
