package com.suime.excel;

import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlWriteExcel {
	
	public static void main(String[] args) {
		//数组存放表头
		String[] title={"id","name","sex"};
		File file=new File("/Users/fire/JxlWriteExcel.xls");
		try{
			file.createNewFile();
			//创建工作表
			WritableWorkbook workbook=Workbook.createWorkbook(file);
			
			//创建sheet
			WritableSheet sheet=workbook.createSheet("sheet1", 0);
			
			Label label=null;
			
			//设置列明
			for(int i=0;i<title.length;i++){
				label=new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			
			//添加数据
			for(int i=1;i<100;i++){
				label=new Label(0,i,"a"+i);
				sheet.addCell(label);
				
				label=new Label(1,i,"user"+i);
				sheet.addCell(label);
				
				label=new Label(2,i,"M");
				sheet.addCell(label);
			}
			
			//写入数据，并关闭
			workbook.write();
			workbook.close();
			System.out.println("创建完成！");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
