package io.health.vo.response;


import io.health.dto.PatientResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class ResponseVo  {
	
	private Integer statusCode;
	private String statusMessage;
	private PatientResponseDto patient;


	public ResponseVo(Integer statusCode, String statusMessage, PatientResponseDto patient) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.patient = patient;
	}
}
