package pl.edu.polisadwa.polisa;

import java.math.BigDecimal;
import java.sql.Date;

public class PolisaDTO {

	private Integer id;

	private String symbol;

	private Date dataOd;

	private Date dataDo;

	private BigDecimal skladka;

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

	@Override
	public String toString() {
		return "PolisaDTO [id=" + id + ", symbol=" + symbol + ", dataOd=" + dataOd + ", dataDo=" + dataDo + ", skladka="
				+ skladka + "]";
	}

}
