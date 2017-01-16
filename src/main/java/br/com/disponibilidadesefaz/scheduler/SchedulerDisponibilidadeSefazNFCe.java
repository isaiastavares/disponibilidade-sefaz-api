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

import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFCe;
import br.com.disponibilidadesefaz.nfce.repository.DisponibilidadeSefazNFCeRepository;
import br.com.disponibilidadesefaz.nfe.config.NFeConfigImpl;

/**
 * Tarefa agendada que realiza uma consulta da
 * disponibilidade dos Serviços da Sefaz (NFC-e) de
 * tempos em tempos.
 *
 * @author Isaias Tavares
 *
 */
@Component
public class SchedulerDisponibilidadeSefazNFCe extends SchedulerDisponibilidadeSefazDFe<DisponibilidadeSefazNFCe, DisponibilidadeSefazNFCeRepository> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerDisponibilidadeSefazNFCe.class);

	private static final NFeConfig config = new NFeConfigImpl();
	private final DisponibilidadeSefazNFCeRepository disponibilidadeSefazNFCeRepository;

	/**
	 * Constrói o scheduler responsável pelas consultas de
     * disponibilidade dos serviços de NFC-e.
     *
     * Realiza a validação dos parâmetros para que nenhum esteja nulo.
     *
	 * @param DisponibilidadeSefazNFCeRepository repositório que lida com {@link DisponibilidadeSefazNFCe}
	 */
	@Autowired
	public SchedulerDisponibilidadeSefazNFCe(DisponibilidadeSefazNFCeRepository disponibilidadeSefazNFCeRepository) {
		super();

		Assert.notNull(disponibilidadeSefazNFCeRepository);

		this.disponibilidadeSefazNFCeRepository = disponibilidadeSefazNFCeRepository;
	}

    @Override
	protected DisponibilidadeSefazNFCe newInstanceDisponibilidadeSefaz() {
		return new DisponibilidadeSefazNFCe();
	}

	@Override
	protected DisponibilidadeSefazNFCeRepository getRepository() {
		return disponibilidadeSefazNFCeRepository;
	}

	@Override
	protected IStatusServicoConsultaRetorno consultaDisponibilidadeSefazPorUf(DFUnidadeFederativa uf) throws Exception {
		LOGGER.info("Consultando Status do Serviço de NFC-e - UF: " + uf.getDescricao());
		return new WSFacade(config).consultaStatus(uf, DFModelo.NFCE);
	}
}