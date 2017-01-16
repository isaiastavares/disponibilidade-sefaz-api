package br.com.disponibilidadesefaz.entidade.support;

import org.springframework.data.domain.Persistable;

public interface Entityable extends Persistable<Long> {

	Long getId();

	void setId(Long id);

}
