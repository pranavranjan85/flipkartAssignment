package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is used to read the data from excel file.
 * @author Pranav
 *
 */
public class ExcelGeneric 
{
	Workbook workbook;
	FileInputStream fisExcel;
	FileOutputStream fos;
	/**
	 * This method is used to initialize excel file
	 */
	public void initializeExcelFile(String excelPath)
	{
		
		try {
			fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	/**
	 * This method is used to fetch the data from excel file
	 */
	public String getDataFromExcel(String sheetname, int rowNum, int cellNum)
	{
		Sheet sheet = workbook.getSheet(sheetname);
		return new DataFormatter().formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
	}
	
	/**
	 * This method is used to add the data in excel file
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @param addData
	 */
	public void setDataInExcel(String sheetname, int rowNum, int cellNum, String addData)
	{
		 Cell cell = workbook.getSheet(sheetname).getRow(rowNum).createCell(cellNum);
		 cell.setCellValue(addData);
	}
	
	
	/**
	 * This method is used to initialize the file output stream class
	 * @param excelPath
	 */
	public void initializeFileOutputStream(String excelPath) {
		try {
			fos=new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to save the added data in database
	 * @param excelPath
	 */
	public void writeInExcelFile( )
	{
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
