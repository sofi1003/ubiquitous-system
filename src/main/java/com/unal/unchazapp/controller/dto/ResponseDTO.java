package com.unal.unchazapp.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean success = true;
	private String message;
	
	

}
