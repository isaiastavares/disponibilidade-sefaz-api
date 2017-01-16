package br.com.disponibilidadesefaz.dfe.dto;

import java.util.Date;

public class RetornoSefazDisponibilidadeDTO {

	private Long id;
	private String siglaUf;
	private String estado;
	private Integer cStat;
	private String xMotivo;
	private Integer tMed;
	private String tipoEmissao;
	private Date dataUltimaConsulta;
	private String dataUltimaConsultaFormatada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSiglaUf() {
		return siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCStat() {
		return cStat;
	}

	public void setCStat(Integer cStat) {
		this.cStat = cStat;
	}

	public String getXMotivo() {
		return xMotivo;
	}

	public void setXMotivo(String xMotivo) {
		this.xMotivo = xMotivo;
	}

	public Integer getTMed() {
		return tMed;
	}

	public void setTMed(Integer tMed) {
		this.tMed = tMed;
	}

	public String getTipoEmissao() {
		return tipoEmissao;
	}

	public void setTipoEmissao(String tipoEmissao) {
		this.tipoEmissao = tipoEmissao;
	}

	public Date getDataUltimaConsulta() {
		if (dataUltimaConsulta != null) {
            return (Date) dataUltimaConsulta.clone();
        }
        return null;
	}

	public void setDataUltimaConsulta(Date dataUltimaConsulta) {
		if (dataUltimaConsulta != null) {
            this.dataUltimaConsulta = (Date) dataUltimaConsulta.clone();
        }
	}

	public String getDataUltimaConsultaFormatada() {
		return dataUltimaConsultaFormatada;
	}

	public void setDataUltimaConsultaFormatada(String dataUltimaConsultaFormatada) {
		this.dataUltimaConsultaFormatada = dataUltimaConsultaFormatada;
	}
}
