package br.com.disponibilidadesefaz.entidade;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "disponibilidade_sefaz_cte",
	indexes = { @Index(name = "idx_cte_estado", columnList = "estado"),
		@Index(name = "idx_cte_status_servico", columnList = "status_servico"),
		@Index(name = "idx_cte_x_motivo", columnList = "x_motivo"),
		@Index(name = "idx_cte_tempo_medio", columnList = "tempo_medio"),
		@Index(name = "idx_cte_data_ultima_consulta", columnList = "data_ultima_consulta"),
		@Index(name = "idx_cte_tipo_emissao", columnList = "tipo_emissao"),
		@Index(name = "idx_cte_observacoes", columnList = "observacoes")
	}
)
public class DisponibilidadeSefazCTe extends DisponibilidadeSefazDFe {

	private static final long serialVersionUID = 3636754202208151658L;

}
