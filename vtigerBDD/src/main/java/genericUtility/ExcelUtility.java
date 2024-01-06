package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Akash Deb
 *
 */
public class ExcelUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String fetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_DATA_PATH);

		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static int fetchNumericDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_DATA_PATH);

		return (int)WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static boolean fetchBooleanDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_DATA_PATH);

		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}

	

}
