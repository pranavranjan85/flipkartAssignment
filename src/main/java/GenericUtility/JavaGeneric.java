package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is used to implement some java methods
 * @author Pranav
 *
 */
public class JavaGeneric 
{
	/**
	 * This method is used to convert string to long
	 * @param StringData
	 * @return
	 */
	public long converStringToLong(String StringData) {
		return Long.parseLong(StringData);
	}


	/**
	 * this method is used to print the statement
	 * @param value
	 */
	public void printStatement(String value)
	{
		  System.out.println(value);
	}

	/**
	 * This method is is used to split the string based on strategy
	 * @param value
	 * @param strategy
	 * @return
	 */
	public String[] splitString(String value, String strategy)
	{
		return value.split(strategy);
	}


	/**
	 * This method is used to fetch current date
	 * @param strategy
	 * @return
	 */

	public String getCurrentDate(String strategy)
	{
		return new SimpleDateFormat(strategy).format(new Date());
	}

}
