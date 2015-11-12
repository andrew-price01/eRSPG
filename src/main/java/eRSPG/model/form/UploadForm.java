package eRSPG.model.form;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {
	private MultipartFile fileUpload;
	private String name;

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
	
	
}
