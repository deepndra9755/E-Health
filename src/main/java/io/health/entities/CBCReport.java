package io.health.entities;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CBCReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String redBloodCell;
	private String neutrophil;
	private String eosinophil;
	private String basophil;
	private String lymphocyte;
	private String monocyte;

	@ManyToOne
	@JoinColumn(name = "report_id") // Assuming "report_id" is the foreign key in CBCReport table
	private Report report;


	public CBCReport(String redBloodCell, String neutrophil, String eosinophil, String basophil, String lymphocyte, String monocyte) {
		this.redBloodCell = redBloodCell;
		this.neutrophil = neutrophil;
		this.eosinophil = eosinophil;
		this.basophil = basophil;
		this.lymphocyte = lymphocyte;
		this.monocyte = monocyte;
	}



}
