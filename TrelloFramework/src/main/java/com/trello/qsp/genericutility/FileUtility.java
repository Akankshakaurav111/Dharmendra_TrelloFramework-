package com.trello.qsp.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
public String readTheDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis = new FileInputStream("./src/test/resource/TrelloCommonData.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
    String value = pObj.getProperty(key);
    return value;
}
}
