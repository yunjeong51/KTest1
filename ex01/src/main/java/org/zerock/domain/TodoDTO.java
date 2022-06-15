package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class TodoDTO {
	//할일, 날짜
	private String title;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
	
}
