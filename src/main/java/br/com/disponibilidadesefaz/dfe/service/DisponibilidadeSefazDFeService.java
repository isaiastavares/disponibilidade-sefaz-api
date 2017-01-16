package br.com.disponibilidadesefaz.dfe.service;

import java.util.List;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;

/**
 * Interface que expõe métodos comuns de serviço relacionados a
 * disponibilidade dos serviços de DF-e.
 *
 * @author Isaias Tavares
 *
 * @param <E> entidade relacionada a disponibilidade da Sefaz de acordo com o modelo fiscal
 */
public interface DisponibilidadeSefazDFeService<E extends IDisponibilidadeSefazDFe> {

	/**
	 * Retorna a disponibilidade dos serviços de todos os estados.
	 *
	 * @return uma lista contendo a disponibilidade dos serviços de todos os estados.
	 */
	List<E> allDisponibilidades();

	/**
	 * Retorna a disponibilidade da Sefaz referente a UF passada por parâmetro
	 *
	 * @param siglaUf código da UF que deseja consultar a disponibilidade.
	 * @return a disponibilidade da Sefaz referente a UF passada por parâmetro
	 */
	E disponibilidadePorUf(String siglaUf);

}
