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

/**
 * Controlador que expõe endpoints comuns relacionados
 * a disponibilidade dos serviços de DF-e.
 *
 * @author Isaias Tavares
 *
 * @param <E> entidade relacionada a disponibilidade da Sefaz de acordo com o modelo fiscal
 */
public abstract class AbstractDisponibilidadeSefazDFeCtrl<E extends IDisponibilidadeSefazDFe> {

	@Autowired
	private DisponibilidadeSefazDTOFactory disponibilidadeSefazDTOFactory;

	/**
     * Obtém o service referente a disponibilidade da Sefaz
     * de acordo com o modelo.
     *
     * @param <S> serviço especifico da Disponibilidade da Sefaz para o modelo requerido
     * @param <E> entidade relacionada a disponibilidade da Sefaz de acordo com o modelo fiscal
     * @return o serviço da Disponibilidade da Sefaz relacionado ao seu modelo
     */
    protected abstract <S extends DisponibilidadeSefazDFeService<E>> S getDFeService();

    /**
     * EndPoint que retorna a disponibilidade dos serviços de todos os estados.
     *
     * @return uma lista de {@link RetornoSefazDisponibilidadeDTO}
     */
	@RequestMapping(value = "/disponibilidade", method = RequestMethod.GET)
    public List<RetornoSefazDisponibilidadeDTO> consultaDisponibilidadeSefaz() {
		List<RetornoSefazDisponibilidadeDTO> listDTO = new ArrayList<RetornoSefazDisponibilidadeDTO>();
		for (IDisponibilidadeSefazDFe disponibilidadeSefazDFe : getDFeService().allDisponibilidades()) {
			listDTO.add(disponibilidadeSefazDTOFactory.gerarDTORetornoSefaz(disponibilidadeSefazDFe));
		}
		return listDTO;
    }

	/**
	 * EndPoint que retorna a disponibilidade da Sefaz referente
	 * a UF passada por parâmetro
	 *
	 * @param ufSigla código da UF que deseja consultar a disponibilidade.
	 * @return {@link RetornoSefazDisponibilidadeDTO}
	 */
	@RequestMapping(value = "/disponibilidadePorUF", method = RequestMethod.GET)
    public RetornoSefazDisponibilidadeDTO consultaDisponibilidadeSefazPorUF(@RequestParam String ufSigla) {
		return disponibilidadeSefazDTOFactory.gerarDTORetornoSefaz(getDFeService().disponibilidadePorUf(ufSigla));
    }

}
