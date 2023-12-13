package io.health.entities;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	@Column(unique=true)
	private String aadharNumber;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	private LocalDate date;

	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Report> report;


	public Patient(String aadharNumber, String name, String lastName, String address, Long mobile,
			LocalDate date) {
		super();
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
		this.date = date;
	}
    
    
	
    
    
}
