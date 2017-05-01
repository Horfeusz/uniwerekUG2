package pl.edu.polisadwa.ryzyko;

import java.math.BigDecimal;

public class RyzykoDTO {

	private Integer id;

	private Integer polId;

	private String ubezpieczenie;

	private BigDecimal skladka;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPolId() {
		return polId;
	}

	public void setPolId(Integer polId) {
		this.polId = polId;
	}

	public String getUbezpieczenie() {
		return ubezpieczenie;
	}

	public void setUbezpieczenie(String ubezpieczenie) {
		this.ubezpieczenie = ubezpieczenie;
	}

	public BigDecimal getSkladka() {
		return skladka;
	}

	public void setSkladka(BigDecimal skladka) {
		this.skladka = skladka;
	}

	@Override
	public String toString() {
		return "RyzykoDTO [id=" + id + ", polId=" + polId + ", ubezpieczenie=" + ubezpieczenie + ", skladka=" + skladka
				+ "]";
	}

}
