package base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtil {
	public static Object[][] getExcelDate(String sheetName){
		Object[][] o=null;
		try {
			//获取工作文件
			Workbook workbook=WorkbookFactory.create(new File("C:\\Users\\admin\\Desktop\\baigai.xlsx"));
			//获取文件的工作表
			Sheet sheet=workbook.getSheet(sheetName);
			//记录行数
			int r=0;
			//读取每行的内容
			for(Row row:sheet) {
				//不读取第一行信息
				if(row.getRowNum()==0) {
					//初始化数组
					o=new Object[sheet.getLastRowNum()][row.getLastCellNum()];	
					continue;
				}
				for(int c=0;c<row.getLastCellNum();c++) {
					//读取单元格内容，预防空内容
					Cell cellNum=row.getCell(c,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					//把内容强制转换成String类型
					cellNum.setCellType(CellType.STRING);
					o[r][c]=cellNum.getStringCellValue();
				}
				r++;
			}
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	//解析测试数据
	public static Map<String,String> analysisData(String value,String separator1,String separator2) {
		//利用分隔符对数据进行分组
		String [] v1=value.split(separator1);
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0;i<v1.length;i++) {
			//利用分隔符进行对数据解析
			String [] v2=v1[i].split(separator2);
			//数据内容的值要是为空的话，把数据设置为null
			if(v2.length==1) {
				map.put(v2[0], null);
				continue;
			}
			//把数据放在map里面
			map.put(v2[0], v2[1]);
		}
		return map;
	}
}
