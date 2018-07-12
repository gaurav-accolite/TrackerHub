/**
 * 
 */
package com.accolite.hrms.rest;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.hrms.dto.SowDTO;
import com.accolite.hrms.dto.mapper.SowMapper;
import com.accolite.hrms.entity.Sow;
import com.accolite.hrms.service.SowService;

/**
 * @author Amit Chandrashekar
 *
 */
@RestController
@RequestMapping(value="/sow")
public class SowController {

	@Autowired
	private SowService sowService;
	
	@Autowired
	private SowMapper sowMapper;
	
	private Cell addCell(Row r, int cellNum, Object value) {
		return addCell(r, cellNum, value, null);
	}
	
	private Cell addCell(Row r, int cellNum, Object value, CellStyle style) {
		Cell cell = r.createCell(cellNum);
		if (value instanceof Boolean) {
			cell.setCellValue((boolean)value);
		} else if (value instanceof Date) {
			cell.setCellValue((Date)value);
		} else if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
		} else if (value instanceof String) {
			cell.setCellValue((String)value);
		} else if (value != null) {
			cell.setCellValue(value.toString());
		}
		if (style != null) {
			cell.setCellStyle(style);
		}
		return cell;
	}
	
	private static final String[] sowHeadersText = new String[] {"Sow Id","Sow Name","Sow Budget","Sow Status","Start Date","End Date","Currency Type", "Remarks"};
	
	private XSSFCellStyle createHeaderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
//		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}
	
	private XSSFCellStyle createHeaderStyleNew(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
//		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//		//style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
//		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		Font font = workbook.createFont();
		font.setBold(true);
//		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}
	
	protected String getExportedFileName(final String prefix, final String postfix) {
		StringBuilder filename = new StringBuilder(prefix);
		DateFormat df = new SimpleDateFormat("d MMM yyyy@HHmm");
		filename.append("-").append(df.format(new Date()));
		filename.append(postfix);
		return filename.toString();
	}
	
	private XSSFCellStyle createDataStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		//style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		//style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
//		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		return style;
	}
	
	private CellStyle createDateStyle(XSSFWorkbook workbook) {
		XSSFCreationHelper creationHelper = workbook.getCreationHelper();
		CellStyle style = workbook.createCellStyle();
		style.setDataFormat(creationHelper.createDataFormat().getFormat("MMMM dd, yyyy"));
		return style;
	}
	
	
	@RequestMapping(value="/getAllSOW")	
	public List<SowDTO> getAllSOW() {
		return sowMapper.toSowDtoList(sowService.findAllSow());
	}

	 @RequestMapping(method = RequestMethod.POST)
	 public ResponseEntity<Void> addSow(@RequestBody final SowDTO sowDto) {
		 final Sow sow = sowMapper.toSow(sowDto);
		 sowService.save(sow);
		 return new ResponseEntity<Void>(HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/deleteSow/{id}")
	 public ResponseEntity<Void> deleteSow(@PathVariable("id") final Long id) {
	     sowService.deleteSow(id);
	     return new ResponseEntity<Void>(HttpStatus.OK);
	}
	 
	 @RequestMapping(value="sowexcel", method=RequestMethod.GET)
		public void downloadSow(@PathVariable String role, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			ServletContext context = request.getSession().getServletContext();
			ByteArrayOutputStream fos = null;
			OutputStream os = null; 
			try {
				fos = new ByteArrayOutputStream();
				List<SowDTO> sow = sowMapper.toSowDtoList(sowService.findAllSow());
				XSSFWorkbook workbook = exportSow(sow);
				workbook.write(fos);
				byte [] binaryResponseContent = fos.toByteArray();
				String fileName = getExportedFileName("Exported SOW", ".xlsx");
				String ext = FilenameUtils.getExtension(fileName);
				String downloadedFileName = FilenameUtils.getName(fileName);
				
				String mimeType = context.getMimeType("application/"+ext);
				response.setContentType(mimeType);
				response.setContentLength(binaryResponseContent.length);
				response.setHeader("Content-Disposition", "attachment;filename= " +downloadedFileName);
				os = response.getOutputStream();
				os.write(binaryResponseContent);
			} finally {
				//Util.safeClose(fos);
				//Util.safeClose(os);
			}			
		}
		
		private XSSFWorkbook exportSow(List<SowDTO> sow) {
			ListIterator<SowDTO> listIterator = sow.listIterator();
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();
			//sheet.createFreezePane(4, 1);
			
			int rowNum = 0;
			Row headerRow = sheet.createRow(rowNum++);
			CellStyle headerStyle = createHeaderStyleNew(workbook);
			CellStyle dataStyle = createDataStyle(workbook);
			
			
			
			int cellNum = 0;
			for (String headerText: sowHeadersText) {
				addCell(headerRow, cellNum++, headerText, headerStyle);
			}

			while(listIterator.hasNext()) {
				SowDTO c = listIterator.next();
				Row row = sheet.createRow(rowNum++);
				cellNum = 0;
				addCell(row, cellNum++, c.getSowId(), dataStyle);
				addCell(row, cellNum++, c.getSowName(), dataStyle);
				addCell(row, cellNum++, c.getSowBudget(), dataStyle);
				addCell(row, cellNum++, c.getSowStatus(), dataStyle);
				addCell(row, cellNum++, c.getSowStartDate().toString(), dataStyle);
				addCell(row, cellNum++, c.getSowEndDate().toString(), dataStyle);
				addCell(row, cellNum++, c.getSowEndDate().toString(), dataStyle);
				addCell(row, cellNum++, c.getCurrencyType(), dataStyle);
				addCell(row, cellNum++, c.getRemarks(), dataStyle);

//				if(c.getSowFile()!=null)
//				addCell(row, cellNum++, c.getSowFile().getSowFileName(), dataStyle);//Attachment
//				else
//					cellNum++;
				
			}
			for(int k = 0; k < sowHeadersText.length; ++k) {
				sheet.autoSizeColumn(k);
			}
			return workbook;
		}
	 
// private static final String[] sowHeadersText = new String[] {"Sow Id","Sow Name","Sow Budget","Sow Status","Start Date","End Date","Currency Type", "Remarks"};
		
//	@PutMapping("/updateSow/{id}")
//	 public ResponseEntity<Void> updateSow(@PathVariable("id") final Long id,@RequestBody SowDTO sowDto) {
//	     final Sow sow = sowService.findBySowId(id);
//	     sow.setSowBudget(sowDto.getSowBudget());
//	     sowService.save(sow);
//	     return new ResponseEntity<Void>(HttpStatus.OK);
//	}
}
