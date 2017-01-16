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

	protected void consultarDisponibilidadeSefaz() {
		List<DFUnidadeFederativa> listUFs = DFUnidadeFederativa.getApenasEstados();

		for (DFUnidadeFederativa uf : listUFs) {
			try {
				IStatusServicoConsultaRetorno retornoSefaz = consultaDisponibilidadeSefazPorUf(uf);

				E disponibilidadeSefaz = newInstanceDisponibilidadeSefaz();
		    	disponibilidadeSefaz.setEstado(retornoSefaz.getUf().getCodigo());
		    	disponibilidadeSefaz.setStatusServico(Integer.parseInt(retornoSefaz.getStatus()));
		    	disponibilidadeSefaz.setXMotivo(retornoSefaz.getMotivo());
		    	disponibilidadeSefaz.setTMed(Integer.parseInt(retornoSefaz.getTempoMedio()));
		    	disponibilidadeSefaz.setDataUltimaConsulta(new Date());
		    	disponibilidadeSefaz.setTipoEmissao(TipoEmissao.NORMAL.getCodigo());
		    	getRepository().save(disponibilidadeSefaz);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	protected abstract E newInstanceDisponibilidadeSefaz();

	protected abstract R getRepository();

	protected abstract IStatusServicoConsultaRetorno consultaDisponibilidadeSefazPorUf(DFUnidadeFederativa uf) throws Exception;

}
