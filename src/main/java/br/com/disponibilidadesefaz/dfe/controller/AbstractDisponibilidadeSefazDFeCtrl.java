package br.com.disponibilidadesefaz.dfe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;
import br.com.disponibilidadesefaz.dfe.dto.DisponibilidadeSefazDTOFactory;
import br.com.disponibilidadesefaz.dfe.dto.RetornoSefazDisponibilidadeDTO;
import br.com.disponibilidadesefaz.dfe.service.DisponibilidadeSefazDFeService;

public abstract class AbstractDisponibilidadeSefazDFeCtrl<E extends IDisponibilidadeSefazDFe> {

	@Autowired
	private DisponibilidadeSefazDTOFactory disponibilidadeSefazDTOFactory;

	/**
     * Obtém o serviço referente ao modelo.
     *
     * @param <S> serviço especifico para o modelo requerido
     * @return o serviço relacionado ao seu modelo de documento fiscal
     */
    protected abstract <S extends DisponibilidadeSefazDFeService<E>> S getDFeService();

	@RequestMapping(value = "/disponibilidade", method = RequestMethod.GET)
    public List<RetornoSefazDisponibilidadeDTO> consultaDisponibilidadeSefaz() {
		List<RetornoSefazDisponibilidadeDTO> listDTO = new ArrayList<RetornoSefazDisponibilidadeDTO>();
		for (IDisponibilidadeSefazDFe disponibilidadeSefazDFe : getDFeService().allDisponibilidades()) {
			listDTO.add(disponibilidadeSefazDTOFactory.gerarDTORetornoSefaz(disponibilidadeSefazDFe));
		}
		return listDTO;
    }

	@RequestMapping(value = "/disponibilidadePorUF", method = RequestMethod.GET)
    public RetornoSefazDisponibilidadeDTO consultaDisponibilidadeSefazPorUF(@RequestParam String ufSigla) {
		return disponibilidadeSefazDTOFactory.gerarDTORetornoSefaz(getDFeService().disponibilidadePorUf(ufSigla));
    }

}
