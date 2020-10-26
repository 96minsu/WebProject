package com.example.WebProject.domain.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class TestDTO {
	
	@Id
	private int listNum;
    private String listName;
    private Date regDate;
    private String fileOriName;  //실제 파일
    private int dateCnt;
    private String test;
    //SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
    //private String  time1 = format1.format(regDate); 
	
}
