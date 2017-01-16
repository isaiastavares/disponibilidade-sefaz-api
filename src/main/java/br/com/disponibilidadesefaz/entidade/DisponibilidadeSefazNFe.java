package br.com.disponibilidadesefaz.entidade;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "disponibilidade_sefaz_nfe",
	indexes = { @Index(name = "idx_nfe_estado", columnList = "estado"),
		@Index(name = "idx_nfe_status_servico", columnList = "status_servico"),
		@Index(name = "idx_nfe_x_motivo", columnList = "x_motivo"),
		@Index(name = "idx_nfe_tempo_medio", columnList = "tempo_medio"),
		@Index(name = "idx_nfe_data_ultima_consulta", columnList = "data_ultima_consulta"),
		@Index(name = "idx_nfe_tipo_emissao", columnList = "tipo_emissao")
	}
)
public class DisponibilidadeSefazNFe extends DisponibilidadeSefazDFe {

	private static final long serialVersionUID = 3636754202208151658L;

}
