package com.trello.qsp.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseClass implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("testcase failed");
		try {
			takesScreenShots(result.getMethod().getMethodName());
					} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	
}
