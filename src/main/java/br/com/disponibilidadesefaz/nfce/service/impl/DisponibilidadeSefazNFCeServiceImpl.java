package br.com.disponibilidadesefaz.nfce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.disponibilidadesefaz.dfe.service.AbstractDisponibilidadeSefazDFeService;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFCe;
import br.com.disponibilidadesefaz.nfce.repository.DisponibilidadeSefazNFCeRepository;
import br.com.disponibilidadesefaz.nfce.service.DisponibilidadeSefazNFCeService;

@Service("disponibilidadeSefazNfceService")
@Transactional(propagation = Propagation.SUPPORTS)
public class DisponibilidadeSefazNFCeServiceImpl extends AbstractDisponibilidadeSefazDFeService<DisponibilidadeSefazNFCe, DisponibilidadeSefazNFCeRepository> implements DisponibilidadeSefazNFCeService {

	private final DisponibilidadeSefazNFCeRepository disponibilidadeSefazNfceRepository;

	@Autowired
	public DisponibilidadeSefazNFCeServiceImpl(DisponibilidadeSefazNFCeRepository disponibilidadeSefazNfceRepository) {
		super();

		Assert.notNull(disponibilidadeSefazNfceRepository);

		this.disponibilidadeSefazNfceRepository = disponibilidadeSefazNfceRepository;
	}

	@Override
	protected DisponibilidadeSefazNFCeRepository getRepository() {
		return disponibilidadeSefazNfceRepository;
	}

}
