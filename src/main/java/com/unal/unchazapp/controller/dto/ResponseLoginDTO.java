package com.unal.unchazapp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLoginDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	
	private Long idUser;
    private String user;
    private String numeroDocumento;

}
