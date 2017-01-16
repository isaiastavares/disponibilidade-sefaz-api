package br.com.disponibilidadesefaz.dfe.service;

import java.util.List;

public interface DisponibilidadeSefazDFeService<E> {

	List<E> allDisponibilidades();

	E disponibilidadePorUf(String siglaUf);

}
