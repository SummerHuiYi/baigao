package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ImagesFile {
	private static File srcFile;
	public static void setImage(WebDriver driver,String className,String functionName,String message) {
		try {
			Date dNow = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh-mm-ss-SSS");
			srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,new File("d:\\imgs\\"+className+"_"+functionName+"_"+message+"_"+ft.format(dNow)+".png"));
			Log.info("类："+className+"；功能："+functionName+"；信息："+message+";截图成功");
		} catch (IOException e) {
			e.printStackTrace();
			Log.error("类："+className+"；功能："+functionName+"；信息："+message+"截图失败");
		}
	}
	
}
