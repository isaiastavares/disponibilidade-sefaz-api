package br.com.disponibilidadesefaz.nfce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

import br.com.disponibilidadesefaz.dfe.service.AbstractDisponibilidadeSefazDFeService;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFCe;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;
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
	public List<DisponibilidadeSefazNFCe> allDisponibilidades() {
		List<DisponibilidadeSefazNFCe> disponibilidadesSefaz = new ArrayList<>();
		for (DFUnidadeFederativa uf : DFUnidadeFederativa.getApenasEstados()) {
			DisponibilidadeSefazNFCe disponibilidadeSefaz = disponibilidadeSefazNfceRepository
					.findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
							uf.getCodigo(), TipoEmissao.NORMAL.getCodigo());
			disponibilidadesSefaz.add(disponibilidadeSefaz);
		}
		return disponibilidadesSefaz;
	}

	@Override
	public DisponibilidadeSefazNFCe disponibilidadePorUf(String siglaUf) {
		return disponibilidadeSefazNfceRepository.findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
				siglaUf, TipoEmissao.NORMAL.getCodigo());
	}

}
