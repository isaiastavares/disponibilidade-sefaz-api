package br.com.disponibilidadesefaz.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.fincatto.cte200.CTeConfig;
import com.fincatto.cte200.webservices.WSFacade;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.statusservico.consulta.IStatusServicoConsultaRetorno;

import br.com.disponibilidadesefaz.cte.config.CTeConfigImpl;
import br.com.disponibilidadesefaz.cte.repository.DisponibilidadeSefazCTeRepository;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazCTe;

@Component
public class SchedulerDisponibilidadeSefazCTe extends SchedulerDisponibilidadeSefazDFe<DisponibilidadeSefazCTe, DisponibilidadeSefazCTeRepository> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerDisponibilidadeSefazCTe.class);

	private static final CTeConfig config = new CTeConfigImpl();

	private final DisponibilidadeSefazCTeRepository disponibilidadeSefazCTeRepository;

	@Autowired
	public SchedulerDisponibilidadeSefazCTe(DisponibilidadeSefazCTeRepository disponibilidadeSefazCTeRepository) {
		super();

		Assert.notNull(disponibilidadeSefazCTeRepository);

		this.disponibilidadeSefazCTeRepository = disponibilidadeSefazCTeRepository;
	}

    @Override
	protected DisponibilidadeSefazCTe newInstanceDisponibilidadeSefaz() {
		return new DisponibilidadeSefazCTe();
	}

	@Override
	protected DisponibilidadeSefazCTeRepository getRepository() {
		return disponibilidadeSefazCTeRepository;
	}

	@Override
	protected IStatusServicoConsultaRetorno consultaDisponibilidadeSefazPorUf(DFUnidadeFederativa uf) throws Exception {
		LOGGER.info("Consultando Status do Serviço de CT-e - UF: " + uf.getDescricao());
		return new WSFacade(config).consultaStatus(uf, DFModelo.CTE);
	}
}
