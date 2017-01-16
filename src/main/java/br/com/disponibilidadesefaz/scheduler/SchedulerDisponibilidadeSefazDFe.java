package br.com.disponibilidadesefaz.scheduler;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.statusservico.consulta.IStatusServicoConsultaRetorno;

import br.com.disponibilidadesefaz.dfe.repository.DisponibilidadeSefazDFeRepository;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazDFe;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;

public abstract class SchedulerDisponibilidadeSefazDFe<E extends DisponibilidadeSefazDFe, R extends DisponibilidadeSefazDFeRepository<E>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerDisponibilidadeSefazDFe.class);

	private static final Integer STATUS_FALHA_CONSULTA = 999;
	private static final String MOTIVO_FALHA_CONSULTA = "Falha ao acessar o WebService de Consulta";

	protected void consultarDisponibilidadeSefaz() {
		List<DFUnidadeFederativa> listUFs = DFUnidadeFederativa.getApenasEstados();

		for (DFUnidadeFederativa uf : listUFs) {
			E disponibilidadeSefaz = newInstanceDisponibilidadeSefaz();
			try {
				IStatusServicoConsultaRetorno retornoSefaz = consultaDisponibilidadeSefazPorUf(uf);

		    	disponibilidadeSefaz.setEstado(retornoSefaz.getUf().getCodigo());
		    	disponibilidadeSefaz.setStatusServico(Integer.parseInt(retornoSefaz.getStatus()));
		    	disponibilidadeSefaz.setXMotivo(retornoSefaz.getMotivo());
		    	disponibilidadeSefaz.setTMed(Integer.parseInt(retornoSefaz.getTempoMedio()));
		    	disponibilidadeSefaz.setDataUltimaConsulta(new Date());
		    	disponibilidadeSefaz.setTipoEmissao(TipoEmissao.NORMAL.getCodigo());
		    	disponibilidadeSefaz.setXObs(retornoSefaz.getObservacao());
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
				disponibilidadeSefaz.setEstado(uf.getCodigo());
		    	disponibilidadeSefaz.setStatusServico(STATUS_FALHA_CONSULTA);
		    	disponibilidadeSefaz.setXMotivo(MOTIVO_FALHA_CONSULTA);
		    	disponibilidadeSefaz.setDataUltimaConsulta(new Date());
		    	disponibilidadeSefaz.setTipoEmissao(TipoEmissao.NORMAL.getCodigo());
			} finally {
				getRepository().save(disponibilidadeSefaz);
			}
		}
	}

	protected abstract E newInstanceDisponibilidadeSefaz();

	protected abstract R getRepository();

	protected abstract IStatusServicoConsultaRetorno consultaDisponibilidadeSefazPorUf(DFUnidadeFederativa uf) throws Exception;

}
