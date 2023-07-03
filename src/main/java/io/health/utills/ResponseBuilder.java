package io.health.utills;

import org.springframework.stereotype.Service;

import io.health.dto.PatientResponseDto;
import io.health.vo.response.ResponseVo;

@Service
public class ResponseBuilder {
	
	public ResponseVo buildFinalResponse(PatientResponseDto patientVo,String statusMessage,Integer statusCode) {
		return new ResponseVo(statusCode, statusMessage, patientVo);
	}

}
