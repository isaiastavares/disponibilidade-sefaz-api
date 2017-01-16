package br.com.disponibilidadesefaz.entidade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;
import br.com.disponibilidadesefaz.entidade.support.AbstractBaseEntity;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;

@MappedSuperclass
public class DisponibilidadeSefazDFe extends AbstractBaseEntity implements IDisponibilidadeSefazDFe {

	private static final long serialVersionUID = -2657970307637620943L;

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

	@NotEmpty
	@Size(min = 2, max = 2)
	@Column(nullable = false, length = 2)
	private String estado;

	@NotNull
	@Column(name = "status_servico", nullable = false, length = 3)
	private Integer statusServico;

	@NotEmpty
	@Column(name = "x_motivo", nullable = false)
	private String xMotivo;

	@NotNull
	@Column(name = "tempo_medio", nullable = false)
	private Integer tMed;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_consulta", nullable = false)
	private Date dataUltimaConsulta;

	@NotNull
	@Range(min = 1, max = 2)
	@Column(name = "tipo_emissao", nullable = false, length = 1)
	private Integer tipoEmissao;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public Integer getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(Integer statusServico) {
		this.statusServico = statusServico;
	}

	@Override
	public String getXMotivo() {
		return xMotivo;
	}

	public void setXMotivo(String xMotivo) {
		this.xMotivo = xMotivo;
	}

	@Override
	public Integer getTMed() {
		return tMed;
	}

	public void setTMed(Integer tMed) {
		this.tMed = tMed;
	}

	public Date getDataUltimaConsulta() {
		return dataUltimaConsulta;
	}

	public void setDataUltimaConsulta(Date dataUltimaConsulta) {
		this.dataUltimaConsulta = dataUltimaConsulta;
	}

	public Integer getTipoEmissao() {
		return tipoEmissao;
	}

	public void setTipoEmissao(Integer tipoEmissao) {
		this.tipoEmissao = tipoEmissao;
	}

	@Override
	@Transient
	public DFUnidadeFederativa getEstadoType() {
		return DFUnidadeFederativa.valueOfCodigo(getEstado());
	}

	@Override
	@Transient
	public String getDataUltimaConsultaFormatada() {
		return DATE_FORMAT.format(getDataUltimaConsulta());
	}

	@Override
	@Transient
	public TipoEmissao getTipoEmissaoType() {
		return TipoEmissao.valueOfCodigo(getTipoEmissao());
	}
}