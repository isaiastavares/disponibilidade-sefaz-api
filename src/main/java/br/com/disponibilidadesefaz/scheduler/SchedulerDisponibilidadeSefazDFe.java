package br.com.disponibilidadesefaz.scheduler;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.statusservico.consulta.IStatusServicoConsultaRetorno;

import br.com.disponibilidadesefaz.dfe.repository.DisponibilidadeSefazDFeRepository;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazDFe;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;

public abstract class SchedulerDisponibilidadeSefazDFe<E extends DisponibilidadeSefazDFe, R extends DisponibilidadeSefazDFeRepository<E>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerDisponibilidadeSefazDFe.class);

	private static final Integer STATUS_FALHA_CONSULTA = 999;
	private static final String MOTIVO_SERVICO_INDISPONIVEL = "Serviço Indisponível";

	/**
     * Executa a cada 3 minutos (cron = "0 0/3 * 1/1 * ? *")
     * uma consulta na SEFAZ com o intuito de verificar a
     * disponibilidade do serviço e persiste o resultado no
     * Banco de Dados.
     *
     * Obs.: No Manual de Orientação do Contribuinte da SEFAZ,
     * eles recomendam aguardar um tempo mínimo de 3 minutos
     * entre cada consulta, evitando sobrecarregar desnecessariamente
     * os servidores da SEFAZ.
     */
    @Scheduled(cron = "0 0/3 * 1/1 * ?")
    protected void configuraScheduleConsultaDisponibilidadeSefaz() {
    	List<DFUnidadeFederativa> listUFs = DFUnidadeFederativa.getApenasEstados();

		for (DFUnidadeFederativa uf : listUFs) {
			E disponibilidadeSefaz = newInstanceDisponibilidadeSefaz();
			try {
				IStatusServicoConsultaRetorno retornoSefaz = consultaDisponibilidadeSefazPorUf(uf);

		    	disponibilidadeSefaz.setEstado(retornoSefaz.getUf().getCodigo());
		    	disponibilidadeSefaz.setStatusServico(Integer.parseInt(retornoSefaz.getStatus()));
		    	disponibilidadeSefaz.setXMotivo(retornoSefaz.getMotivo());
		    	disponibilidadeSefaz.setTMed(Integer.parseInt(retornoSefaz.getTempoMedio()));
		    	disponibilidadeSefaz.setXObs(retornoSefaz.getObservacao());
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
				disponibilidadeSefaz.setEstado(uf.getCodigo());
		    	disponibilidadeSefaz.setStatusServico(STATUS_FALHA_CONSULTA);
		    	disponibilidadeSefaz.setXMotivo(MOTIVO_SERVICO_INDISPONIVEL);
		    	disponibilidadeSefaz.setXObs(e.getMessage());
			} finally {
				disponibilidadeSefaz.setDataUltimaConsulta(new Date());
		    	disponibilidadeSefaz.setTipoEmissao(TipoEmissao.NORMAL.getCodigo());
				LOGGER.info(disponibilidadeSefaz.toString());
				getRepository().save(disponibilidadeSefaz);
			}
		}
    }

	protected abstract E newInstanceDisponibilidadeSefaz();

	protected abstract R getRepository();

	protected abstract IStatusServicoConsultaRetorno consultaDisponibilidadeSefazPorUf(DFUnidadeFederativa uf) throws Exception;

}
