package com.accolite.hrms.utility;

public class Constant {
	public static final String directoryName = ".\\src\\main\\resources\\images\\profilePicture\\";
	//public static final String serverDirectoryName = "..\\webapps\\hrms_backend\\WEB-INF\\classes\\images\\profilePicture\\";
	public static final String serverDirectoryName = System.getenv("PROFILE_PIC_PATH") + "\\profilePicture\\";
		
	public static final String batchDirectoryName = ".\\src\\main\\resources\\images\\batches\\";
	public static final String httpHeaderContentType = "Content-Type";
	public static final String httpHeaderImageType = "image/jpg";
}
