package br.com.disponibilidadesefaz.dfe.service;

import java.util.ArrayList;
import java.util.List;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;
import br.com.disponibilidadesefaz.dfe.repository.DisponibilidadeSefazDFeRepository;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;

/**
 * Service que expõe métodos comuns relacionados
 * a disponibilidade dos serviços de DF-e.
 *
 * @author Isaias Tavares
 *
 * @param <E> entidade relacionada a disponibilidade da Sefaz de acordo com o modelo fiscal
 * @param <R> repositório relacionado a disponibilidade da Sefaz de acordo com o modelo fiscal
 */
public abstract class AbstractDisponibilidadeSefazDFeService<E extends IDisponibilidadeSefazDFe, R extends DisponibilidadeSefazDFeRepository<E>> {

	public List<E> allDisponibilidades() {
		List<E> disponibilidadesSefaz = new ArrayList<>();
		for (DFUnidadeFederativa uf : DFUnidadeFederativa.getApenasEstados()) {
			E disponibilidadeSefaz = getRepository()
					.findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
							uf.getCodigo(), TipoEmissao.NORMAL.getCodigo());
			disponibilidadesSefaz.add(disponibilidadeSefaz);
		}
		return disponibilidadesSefaz;
	}

	public E disponibilidadePorUf(String siglaUf) {
		return getRepository().findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
				siglaUf, TipoEmissao.NORMAL.getCodigo());
	}

	/**
	 * Repositório referente a disponibilidade do serviço da SEFAZ
	 * de acordo com o modelo fiscal.
	 *
	 * @return o repositório referente a disponibilidade do serviço da SEFAZ
	 * de acordo com o modelo fiscal.
	 */
	protected abstract R getRepository();

}
