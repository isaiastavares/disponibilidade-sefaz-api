package br.com.disponibilidadesefaz.nfce.repository;

import org.springframework.stereotype.Repository;

import br.com.disponibilidadesefaz.dfe.repository.DisponibilidadeSefazDFeRepository;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFCe;

/**
 * Interface que expõe métodos para obtenção e persistência das
 * informações sobre disponibilidade dos serviços de NFC-e
 *
 * @author Isaias Tavares
 *
 */
@Repository
public interface DisponibilidadeSefazNFCeRepository extends DisponibilidadeSefazDFeRepository<DisponibilidadeSefazNFCe> {

}
