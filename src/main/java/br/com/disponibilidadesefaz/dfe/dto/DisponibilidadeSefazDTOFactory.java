package br.com.disponibilidadesefaz.dfe.dto;

import org.springframework.stereotype.Component;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;

@Component
public class DisponibilidadeSefazDTOFactory {

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
