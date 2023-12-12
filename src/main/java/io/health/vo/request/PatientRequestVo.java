package io.health.vo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestVo {
    private String aadharNumber;
    private String name;
    private String lastName;
    private String address;
    private Long mobile;
    private LocalDate date;

}
