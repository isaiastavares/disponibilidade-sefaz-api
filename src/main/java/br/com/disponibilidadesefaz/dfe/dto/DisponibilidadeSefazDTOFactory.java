package br.com.disponibilidadesefaz.dfe.dto;

import org.springframework.stereotype.Component;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;

/**
 * Fábrica de {@link RetornoSefazDisponibilidadeDTO}
 *
 * @author Isaias Tavares
 */
@Component
public class DisponibilidadeSefazDTOFactory {

	/**
	 * Gera um DTO contendo o retorno da Sefaz referente
	 * a disponibilidade do serviço
	 *
	 * @param disponibilidadeSefaz interface que representa a entidade
	 * de disponibilidade da Sefaz.
	 *
	 * @return objeto resultante da conversão {@link RetornoSefazDisponibilidadeDTO}
	 */
	public RetornoSefazDisponibilidadeDTO gerarDTORetornoSefaz(IDisponibilidadeSefazDFe disponibilidadeSefaz) {
		RetornoSefazDisponibilidadeDTO retornoSefaz = new RetornoSefazDisponibilidadeDTO();
		retornoSefaz.setId(disponibilidadeSefaz.getId());
		retornoSefaz.setSiglaUf(disponibilidadeSefaz.getEstadoType().getCodigo());
		retornoSefaz.setEstado(disponibilidadeSefaz.getEstadoType().getDescricao());
		retornoSefaz.setCStat(disponibilidadeSefaz.getStatusServico());
		retornoSefaz.setXMotivo(disponibilidadeSefaz.getXMotivo());
		retornoSefaz.setTMed(disponibilidadeSefaz.getTMed());
		retornoSefaz.setTipoEmissao(disponibilidadeSefaz.getTipoEmissaoType().getDescricao());
		retornoSefaz.setDataUltimaConsulta(disponibilidadeSefaz.getDataUltimaConsulta());
		retornoSefaz.setDataUltimaConsultaFormatada(disponibilidadeSefaz.getDataUltimaConsultaFormatada());
		retornoSefaz.setObservacao(disponibilidadeSefaz.getXObs());
		return retornoSefaz;
	}

}
