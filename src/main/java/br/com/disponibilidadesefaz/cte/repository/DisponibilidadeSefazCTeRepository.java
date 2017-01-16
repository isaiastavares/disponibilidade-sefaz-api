package br.com.disponibilidadesefaz.cte.repository;

import org.springframework.stereotype.Repository;

import br.com.disponibilidadesefaz.dfe.repository.DisponibilidadeSefazDFeRepository;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazCTe;

/**
 * Interface que expõe métodos para obtenção e persistência das
 * informações sobre disponibilidade dos serviços de CT-e
 *
 * @author Isaias Tavares
 *
 */
@Repository
public interface DisponibilidadeSefazCTeRepository extends DisponibilidadeSefazDFeRepository<DisponibilidadeSefazCTe> {

}
