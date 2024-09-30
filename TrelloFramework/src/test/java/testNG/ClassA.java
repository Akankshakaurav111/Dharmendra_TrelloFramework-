package testNG;

import org.testng.annotations.Test;

public class ClassA 
{
	@Test(groups = "smoke")
public void login()
{
	System.out.println("Login has been executed");
}
	
	@Test(groups = "functionality")
public void logout()
{
	System.out.println("logout has been executed");
}
	
	@Test(groups = {"smoke","functionality"})
public void home()
{
	System.out.println("home has been executed");
}
}
