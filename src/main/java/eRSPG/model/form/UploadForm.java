package eRSPG.model.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import eRSPG.model.UploadFile;

public class UploadForm {
	private MultipartFile fileUpload;
	private String name;
	private byte[] bytes;
	

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	private UploadFile generateUploadFile()
	{
		UploadFile file = new UploadFile();
		//file.setFileName(fileName);
		return file;
		
	}

	// Not sure why this is using a list for a single file....
	public List<UploadFile> generateUploadFiles()
	{
		List<UploadFile> uploadList = new ArrayList<>();
		
		if( !(fileUpload == null))
		{
			UploadFile file = generateUploadFile();
			uploadList.add(file);
		}
		
		return uploadList;
	}
}
