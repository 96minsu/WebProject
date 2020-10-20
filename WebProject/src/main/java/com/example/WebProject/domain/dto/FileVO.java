package com.example.WebProject.domain.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FileVO {
	
	@Id
	private int fno;
    private int listNum;
    private String filename;     //저장할 파일
    private String fileOriName;  //실제 파일
    private String fileUrl;


}
