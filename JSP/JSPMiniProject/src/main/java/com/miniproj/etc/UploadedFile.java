package com.miniproj.etc;

public class UploadedFile {
	private String originalFileName;
	private String ext;
	private String newFileName;
	private long size;
	private String base64String;
	
	public UploadedFile(String originalFileName, String ext, String newFileName, long size) {
		super();
		this.originalFileName = originalFileName;
		this.ext = ext;
		this.newFileName = newFileName;
		this.size = size;
	}
	
	
	public UploadedFile(String originalFileName, String ext, String newFileName, long size, String base64String) {
		super();
		this.originalFileName = originalFileName;
		this.ext = ext;
		this.newFileName = newFileName;
		this.size = size;
		this.base64String = base64String;
	}


	public String getOriginalFileName() {
		return originalFileName;
	}


	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}


	public String getExt() {
		return ext;
	}


	public void setExt(String ext) {
		this.ext = ext;
	}


	public String getNewFileName() {
		return newFileName;
	}


	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}


	public String getBase64String() {
		return base64String;
	}


	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}


	@Override
	public String toString() {
		return "UploadedFile [originalFileName=" + originalFileName + ", ext=" + ext + ", newFileName=" + newFileName
				+ ", size=" + size + ", base64String=" + base64String + "]";
	}


	
	
}
