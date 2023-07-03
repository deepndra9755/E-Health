package io.health.vo.response;

import java.io.Serializable;

import io.health.dto.PatientResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ResponseVo {
	
	private Integer statusCode;
	private String statusMessage;
	private PatientResponseDto patient;

}
