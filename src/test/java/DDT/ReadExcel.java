package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadExcel {
@Test(enabled = false)
public void single() throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("C:\\SelniumFile\\dwsCridential.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	String username = sh.getRow(0).getCell(0).toString();
	String password = sh.getRow(0).getCell(1).toString();
	System.out.println(username);
	System.out.println(password);
}
@Test
public void Multiple() throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("C:\\SelniumFile\\dwsCridential.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int row = sh.getPhysicalNumberOfRows();
	int colom = sh.getRow(0).getPhysicalNumberOfCells();
	String[][] str=new String[row][colom];
	System.out.println(row+"====="+colom);
	for (int i = 0; i <row; i++) {
		for (int j = 0; j <colom; j++) {
			str[i][j]=sh.getRow(i).getCell(j).toString();
		}
	}
	for (int i = 0; i <row; i++) {
		for (int j = 0; j <colom; j++) {
			System.out.print(str[i][j]+" ");
		}
		System.out.println("");
	}   
}
}
