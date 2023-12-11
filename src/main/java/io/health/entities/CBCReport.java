package io.health.entities;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
public class CBCReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	public String getRedBloodCell() {
		return redBloodCell;
	}

	public void setRedBloodCell(String redBloodCell) {
		this.redBloodCell = redBloodCell;
	}

	public String getNeutrophil() {
		return neutrophil;
	}

	public void setNeutrophil(String neutrophil) {
		this.neutrophil = neutrophil;
	}

	public String getEosinophil() {
		return eosinophil;
	}

	public void setEosinophil(String eosinophil) {
		this.eosinophil = eosinophil;
	}

	public String getBasophil() {
		return basophil;
	}

	public void setBasophil(String basophil) {
		this.basophil = basophil;
	}

	public String getLymphocyte() {
		return lymphocyte;
	}

	public void setLymphocyte(String lymphocyte) {
		this.lymphocyte = lymphocyte;
	}

	public String getMonocyte() {
		return monocyte;
	}

	public void setMonocyte(String monocyte) {
		this.monocyte = monocyte;
	}

	private String redBloodCell;
	private String neutrophil;
	private String eosinophil;
	private String basophil;
	private String lymphocyte;
	private String monocyte;


	public CBCReport(String redBloodCell, String neutrophil, String eosinophil, String basophil, String lymphocyte, String monocyte) {
		this.redBloodCell = redBloodCell;
		this.neutrophil = neutrophil;
		this.eosinophil = eosinophil;
		this.basophil = basophil;
		this.lymphocyte = lymphocyte;
		this.monocyte = monocyte;
	}
}
