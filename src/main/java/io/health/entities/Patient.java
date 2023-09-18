package io.health.entities;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
@ToString
public class Patient {

	@Id
	@GeneratedValue
	private Integer pid;
	@Column(unique=true)
	private String aadharNumber;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	private LocalDate date;
	@OneToMany(cascade = {CascadeType.ALL})
    //@JoinColumn(name="cart_id", nullable=false)
    //@JoinColumn(name = "cbcReportId")
	private List<CBCReport> reports;
    
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
