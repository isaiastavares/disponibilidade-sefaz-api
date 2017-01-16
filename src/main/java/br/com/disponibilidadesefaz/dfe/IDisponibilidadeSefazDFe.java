package br.com.disponibilidadesefaz.dfe;

import java.util.Date;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

import br.com.disponibilidadesefaz.enuns.TipoEmissao;

public interface IDisponibilidadeSefazDFe {

	Long getId();

	DFUnidadeFederativa getEstadoType();

	Integer getStatusServico();

	String getXMotivo();

	Integer getTMed();

	Date getDataUltimaConsulta();

	String getDataUltimaConsultaFormatada();

	TipoEmissao getTipoEmissaoType();

}
