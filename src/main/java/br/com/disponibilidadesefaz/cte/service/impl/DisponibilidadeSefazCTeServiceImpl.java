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

@Service("disponibilidadeSefazCteService")
@Transactional(propagation = Propagation.SUPPORTS)
public class DisponibilidadeSefazCTeServiceImpl extends AbstractDisponibilidadeSefazDFeService<DisponibilidadeSefazCTe, DisponibilidadeSefazCTeRepository> implements DisponibilidadeSefazCTeService {

	private final DisponibilidadeSefazCTeRepository disponibilidadeSefazCteRepository;

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
