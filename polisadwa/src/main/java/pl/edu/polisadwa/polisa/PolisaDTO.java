package pl.edu.polisadwa.polisa;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import pl.edu.polisadwa.ryzyko.RyzykoDTO;

public class PolisaDTO {

	private Integer id;

	private String symbol;

	private Date dataOd;

	private Date dataDo;

	private BigDecimal skladka;
	
	private List<RyzykoDTO> ryzyka;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Date getDataOd() {
		return dataOd;
	}

	public void setDataOd(Date dataOd) {
		this.dataOd = dataOd;
	}

	public Date getDataDo() {
		return dataDo;
	}

	public void setDataDo(Date dataDo) {
		this.dataDo = dataDo;
	}

	public BigDecimal getSkladka() {
		return skladka;
	}

	public void setSkladka(BigDecimal skladka) {
		this.skladka = skladka;
	}

	public List<RyzykoDTO> getRyzyka() {
		return ryzyka;
	}

	public void setRyzyka(List<RyzykoDTO> ryzyka) {
		this.ryzyka = ryzyka;
	}

	@Override
	public String toString() {
		return "PolisaDTO [id=" + id + ", symbol=" + symbol + ", dataOd=" + dataOd + ", dataDo=" + dataDo + ", skladka="
				+ skladka + "]";
	}

}
