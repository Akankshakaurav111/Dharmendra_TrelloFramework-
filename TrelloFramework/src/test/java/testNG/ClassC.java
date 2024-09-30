package testNG;

import org.testng.annotations.Test;

public class ClassC 
{
	@Test(groups = "smoke")
public void createdBoardPage()
{
	System.out.println("createdBoardPage has been executed");
}
	
	@Test(groups = "smoke")
public void deleteBoardPage()
{
	System.out.println("deleteBoardPage has been executed");
}
}
