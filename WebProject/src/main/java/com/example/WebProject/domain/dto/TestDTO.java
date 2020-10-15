package com.example.WebProject.domain.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TestDTO {
	
	@Id
	private int listNum;
    private String listName;
    private Date regDate;
    
    //SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
    //private String  time1 = format1.format(regDate); 
	
}
