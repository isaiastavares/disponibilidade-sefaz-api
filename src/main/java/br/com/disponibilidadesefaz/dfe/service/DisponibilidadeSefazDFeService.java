package br.com.disponibilidadesefaz.dfe.service;

import java.util.List;

import br.com.disponibilidadesefaz.dfe.IDisponibilidadeSefazDFe;

public interface DisponibilidadeSefazDFeService<E> {

	List<IDisponibilidadeSefazDFe> allDisponibilidades();

	IDisponibilidadeSefazDFe disponibilidadePorUf(String siglaUf);

}
