package com.wf.excel;

import com.wf.model.StoreSetting;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    public static void exportExcel(HttpServletResponse response,List<StoreSetting> list){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        String fileName = "userinf"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "场所", "设置"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (StoreSetting storeSetting : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(storeSetting.getStoreId());
            row1.createCell(1).setCellValue(storeSetting.getDerail());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<StoreSetting> importExcel(MultipartFile file){
        HSSFWorkbook workbook = null;
        try {
            workbook  = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfSheets = workbook.getNumberOfSheets();
        HSSFSheet sheet = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        List<StoreSetting> list = new ArrayList<>();
        for (int j = 0; j < physicalNumberOfRows; j++) {
            if (j == 0) {
                continue;//标题行
            }
            //...
            Row row = sheet.getRow(j);

            StoreSetting storeSetting = new StoreSetting();
            int storeId = (int) row.getCell(0).getNumericCellValue();
            int derail = (int) row.getCell(1).getNumericCellValue();
            storeSetting.setStoreId(storeId);
            storeSetting.setDerail(derail);
            list.add(storeSetting);
        }
        return list;
    }
}
