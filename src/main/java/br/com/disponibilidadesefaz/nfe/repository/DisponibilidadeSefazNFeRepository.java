package br.com.disponibilidadesefaz.nfe.repository;

import org.springframework.stereotype.Repository;

import br.com.disponibilidadesefaz.dfe.repository.DisponibilidadeSefazDFeRepository;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFe;

/**
 * Interface que expõe métodos para obtenção e persistência das
 * informações sobre disponibilidade dos serviços de NF-e
 *
 * @author Isaias Tavares
 *
 */
@Repository
public interface DisponibilidadeSefazNFeRepository extends DisponibilidadeSefazDFeRepository<DisponibilidadeSefazNFe> {

}
