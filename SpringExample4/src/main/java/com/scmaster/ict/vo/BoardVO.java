package com.scmaster.ict.vo;

import lombok.Data;

@Data
public class BoardVO {
	private String title;
	private String content;
	// 길면 lob (Oracle) lomtext (다른 DB)
}
