package br.com.disponibilidadesefaz.nfe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

import br.com.disponibilidadesefaz.dfe.service.AbstractDisponibilidadeSefazDFeService;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFe;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;
import br.com.disponibilidadesefaz.nfe.repository.DisponibilidadeSefazNFeRepository;
import br.com.disponibilidadesefaz.nfe.service.DisponibilidadeSefazNFeService;

@Service("disponibilidadeSefazNfeService")
@Transactional(propagation = Propagation.SUPPORTS)
public class DisponibilidadeSefazNFeServiceImpl extends AbstractDisponibilidadeSefazDFeService<DisponibilidadeSefazNFe, DisponibilidadeSefazNFeRepository> implements DisponibilidadeSefazNFeService {

	private final DisponibilidadeSefazNFeRepository disponibilidadeSefazNfeRepository;

	@Autowired
	public DisponibilidadeSefazNFeServiceImpl(DisponibilidadeSefazNFeRepository disponibilidadeSefazNfeRepository) {
		super();

		Assert.notNull(disponibilidadeSefazNfeRepository);

		this.disponibilidadeSefazNfeRepository = disponibilidadeSefazNfeRepository;
	}

	@Override
	public List<DisponibilidadeSefazNFe> allDisponibilidades() {
		List<DisponibilidadeSefazNFe> disponibilidadesSefaz = new ArrayList<>();
		for (DFUnidadeFederativa uf : DFUnidadeFederativa.getApenasEstados()) {
			DisponibilidadeSefazNFe disponibilidadeSefaz = disponibilidadeSefazNfeRepository
					.findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
							uf.getCodigo(), TipoEmissao.NORMAL.getCodigo());
			disponibilidadesSefaz.add(disponibilidadeSefaz);
		}
		return disponibilidadesSefaz;
	}

	@Override
	public DisponibilidadeSefazNFe disponibilidadePorUf(String siglaUf) {
		return disponibilidadeSefazNfeRepository.findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
				siglaUf, TipoEmissao.NORMAL.getCodigo());
	}

}
