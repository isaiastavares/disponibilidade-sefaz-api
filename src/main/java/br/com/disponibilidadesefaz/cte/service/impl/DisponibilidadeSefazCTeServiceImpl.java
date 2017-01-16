package br.com.disponibilidadesefaz.cte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.disponibilidadesefaz.cte.repository.DisponibilidadeSefazCTeRepository;
import br.com.disponibilidadesefaz.cte.service.DisponibilidadeSefazCTeService;
import br.com.disponibilidadesefaz.dfe.service.AbstractDisponibilidadeSefazDFeService;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazCTe;

/**
 * Service para disponibilidade dos serviços de CT-e.
 * <p>
 * Lida com informações especificas da disponibilidade de CT-e.
 * </p>
 *
 * @author Isaias Tavares
 *
 */
@Service("disponibilidadeSefazCteService")
@Transactional(propagation = Propagation.SUPPORTS)
public class DisponibilidadeSefazCTeServiceImpl extends AbstractDisponibilidadeSefazDFeService<DisponibilidadeSefazCTe, DisponibilidadeSefazCTeRepository> implements DisponibilidadeSefazCTeService {

	private final DisponibilidadeSefazCTeRepository disponibilidadeSefazCteRepository;

	/**
	 * Constrói o service responsável pelas operações relacionadas a
     * disponibilidade dos serviços de CT-e.
     *
     * Realiza a validação dos parâmetros para que nenhum esteja nulo.
     *
	 * @param disponibilidadeSefazCteRepository repositório que lida com {@link DisponibilidadeSefazCTe}
	 */
	@Autowired
	public DisponibilidadeSefazCTeServiceImpl(DisponibilidadeSefazCTeRepository disponibilidadeSefazCteRepository) {
		super();

		Assert.notNull(disponibilidadeSefazCteRepository);

		this.disponibilidadeSefazCteRepository = disponibilidadeSefazCteRepository;
	}

	@Override
	protected DisponibilidadeSefazCTeRepository getRepository() {
		return disponibilidadeSefazCteRepository;
	}

}
