package br.com.disponibilidadesefaz.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.statusservico.consulta.IStatusServicoConsultaRetorno;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.webservices.WSFacade;

import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFe;
import br.com.disponibilidadesefaz.nfe.config.NFeConfigImpl;
import br.com.disponibilidadesefaz.nfe.repository.DisponibilidadeSefazNFeRepository;

/**
 * Tarefa agendada que realiza uma consulta da
 * disponibilidade dos Serviços da Sefaz (NF-e) de
 * tempos em tempos.
 *
 * @author Isaias Tavares
 *
 */
@Component
public class SchedulerDisponibilidadeSefazNFe extends SchedulerDisponibilidadeSefazDFe<DisponibilidadeSefazNFe, DisponibilidadeSefazNFeRepository> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerDisponibilidadeSefazNFe.class);

	private static final NFeConfig config = new NFeConfigImpl();
	private final DisponibilidadeSefazNFeRepository disponibilidadeSefazNFeRepository;

	/**
	 * Constrói o scheduler responsável pelas consultas de
     * disponibilidade dos serviços de NF-e.
     *
     * Realiza a validação dos parâmetros para que nenhum esteja nulo.
     *
	 * @param DisponibilidadeSefazNFeRepository repositório que lida com {@link DisponibilidadeSefazNFe}
	 */
	@Autowired
	public SchedulerDisponibilidadeSefazNFe(DisponibilidadeSefazNFeRepository disponibilidadeSefazNFeRepository) {
		super();

		Assert.notNull(disponibilidadeSefazNFeRepository);

		this.disponibilidadeSefazNFeRepository = disponibilidadeSefazNFeRepository;
	}

    @Override
	protected DisponibilidadeSefazNFe newInstanceDisponibilidadeSefaz() {
		return new DisponibilidadeSefazNFe();
	}

	@Override
	protected DisponibilidadeSefazNFeRepository getRepository() {
		return disponibilidadeSefazNFeRepository;
	}

	@Override
	protected IStatusServicoConsultaRetorno consultaDisponibilidadeSefazPorUf(DFUnidadeFederativa uf) throws Exception {
		LOGGER.info("Consultando Status do Serviço de NF-e - UF: " + uf.getDescricao());
		return new WSFacade(config).consultaStatus(uf, DFModelo.NFE);
	}
}