package io.health.vo.request;

import java.time.LocalDate;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class PatientRequestVo {
	
	
	@Nullable
	private Integer pid;
	private String aadharNumber;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	@Nullable
	private LocalDate date;

}
