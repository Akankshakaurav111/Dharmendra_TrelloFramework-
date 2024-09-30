package testNG;

import org.testng.annotations.Test;

public class ClassB 
{
	@Test(groups = "integration")
public void boardspage()
{
	System.out.println("boardspage has been executed");
}
	
	@Test(groups = "functionality")
public void loginToContinuepage()
{
		System.out.println("loginToContinuepage has been executed");
}
}
