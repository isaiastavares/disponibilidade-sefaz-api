package br.com.disponibilidadesefaz.dfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;

/**
 * Interface que expõe métodos para obtenção e persistência das
 * informações comuns sobre disponibilidade dos serviços de DF-e
 *
 * @author Isaias Tavares
 *
 */
@NoRepositoryBean
public interface DisponibilidadeSefazDFeRepository<E extends IDisponibilidadeSefazDFe> extends JpaRepository<E, Long> {

	E findFirstByEstadoAndTipoEmissaoOrderByDataUltimaConsultaDesc(String estado, Integer tipoEmissao);

}
