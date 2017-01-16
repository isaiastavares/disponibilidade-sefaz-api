package br.com.disponibilidadesefaz.entidade;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "disponibilidade_sefaz_nfce",
	indexes = { @Index(name = "idx_nfce_estado", columnList = "estado"),
		@Index(name = "idx_nfce_status_servico", columnList = "status_servico"),
		@Index(name = "idx_nfce_x_motivo", columnList = "x_motivo"),
		@Index(name = "idx_nfce_tempo_medio", columnList = "tempo_medio"),
		@Index(name = "idx_nfce_data_ultima_consulta", columnList = "data_ultima_consulta"),
		@Index(name = "idx_nfce_tipo_emissao", columnList = "tipo_emissao"),
		@Index(name = "idx_nfce_observacoes", columnList = "observacoes")
	}
)
public class DisponibilidadeSefazNFCe extends DisponibilidadeSefazDFe {

	private static final long serialVersionUID = 3636754202208151658L;

}
