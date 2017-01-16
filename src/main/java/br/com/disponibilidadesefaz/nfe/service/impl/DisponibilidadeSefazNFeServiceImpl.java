package br.com.disponibilidadesefaz.nfe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.disponibilidadesefaz.dfe.service.AbstractDisponibilidadeSefazDFeService;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFe;
import br.com.disponibilidadesefaz.nfe.repository.DisponibilidadeSefazNFeRepository;
import br.com.disponibilidadesefaz.nfe.service.DisponibilidadeSefazNFeService;

/**
 * Service para disponibilidade dos serviços de NF-e.
 * <p>
 * Lida com informações especificas da disponibilidade de NF-e.
 * </p>
 *
 * @author Isaias Tavares
 *
 */
@Service("disponibilidadeSefazNfeService")
@Transactional(propagation = Propagation.SUPPORTS)
public class DisponibilidadeSefazNFeServiceImpl extends AbstractDisponibilidadeSefazDFeService<DisponibilidadeSefazNFe, DisponibilidadeSefazNFeRepository> implements DisponibilidadeSefazNFeService {

	private final DisponibilidadeSefazNFeRepository disponibilidadeSefazNfeRepository;

	/**
	 * Constrói o service responsável pelas operações relacionadas a
     * disponibilidade dos serviços de NF-e.
     *
     * Realiza a validação dos parâmetros para que nenhum esteja nulo.
     *
	 * @param disponibilidadeSefazNfeRepository repositório que lida com {@link DisponibilidadeSefazNFe}
	 */
	@Autowired
	public DisponibilidadeSefazNFeServiceImpl(DisponibilidadeSefazNFeRepository disponibilidadeSefazNfeRepository) {
		super();

		Assert.notNull(disponibilidadeSefazNfeRepository);

		this.disponibilidadeSefazNfeRepository = disponibilidadeSefazNfeRepository;
	}

	@Override
	protected DisponibilidadeSefazNFeRepository getRepository() {
		return disponibilidadeSefazNfeRepository;
	}

}
