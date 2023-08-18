package com.miniproj.etc;

public class UploadedFile {
	private String originalFileName;
	private String ext;
	private String newFileName;
	private long size;
	public UploadedFile(String originalFileName, String ext, String newFileName, long size) {
		super();
		this.originalFileName = originalFileName;
		this.ext = ext;
		this.newFileName = newFileName;
		this.size = size;
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
	@Override
	public String toString() {
		return "UploadedFile [originalFileName=" + originalFileName + ", ext=" + ext + ", newFileName=" + newFileName
				+ ", size=" + size + "]";
	}
	
	
}
