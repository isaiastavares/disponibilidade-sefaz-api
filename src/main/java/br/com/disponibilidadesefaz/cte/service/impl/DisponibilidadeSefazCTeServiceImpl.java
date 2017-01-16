package br.com.disponibilidadesefaz.cte.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

import br.com.disponibilidadesefaz.cte.repository.DisponibilidadeSefazCTeRepository;
import br.com.disponibilidadesefaz.cte.service.DisponibilidadeSefazCTeService;
import br.com.disponibilidadesefaz.dfe.service.AbstractDisponibilidadeSefazDFeService;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazCTe;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;

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
	public List<DisponibilidadeSefazCTe> allDisponibilidades() {
		List<DisponibilidadeSefazCTe> disponibilidadesSefaz = new ArrayList<>();
		for (DFUnidadeFederativa uf : DFUnidadeFederativa.getApenasEstados()) {
			DisponibilidadeSefazCTe disponibilidadeSefaz = disponibilidadeSefazCteRepository
					.findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
							uf.getCodigo(), TipoEmissao.NORMAL.getCodigo());
			disponibilidadesSefaz.add(disponibilidadeSefaz);
		}
		return disponibilidadesSefaz;
	}

	@Override
	public DisponibilidadeSefazCTe disponibilidadePorUf(String siglaUf) {
		return disponibilidadeSefazCteRepository.findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(
				siglaUf, TipoEmissao.NORMAL.getCodigo());
	}

}
