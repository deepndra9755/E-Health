package io.health.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;


@Configuration
@Data
@NoArgsConstructor
@Component
public class StatusCodeConfig {
	
	@Value("${core.api.invalidAadharCode}")
	public Integer invalidAadhar;
	
	@Value("${core.api.generalErrorCode}")
	public Integer genericExcpection;
	
	@Value("${core.api.patientNotFound}")
	public Integer patientNotFound;
	
	@Value("${core.api.reportsNotAddedCode}")
	public Integer reportsNotadded;
	
	
}
