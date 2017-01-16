package br.com.disponibilidadesefaz.cte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.disponibilidadesefaz.cte.service.DisponibilidadeSefazCTeService;
import br.com.disponibilidadesefaz.dfe.controller.AbstractDisponibilidadeSefazDFeCtrl;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazCTe;

@RestController
@RequestMapping({"/cte", "/ct-e", "/CTe", "/CT-e"})
public class DisponibilidadeSefazCTeController extends AbstractDisponibilidadeSefazDFeCtrl<DisponibilidadeSefazCTe> {

	private final DisponibilidadeSefazCTeService disponibilidadeSefazCteService;

	/**
     * Constrói os endpoints para expor operações relacionadas
     * a disponibilidade da Sefaz de CT-e.
     *
	 * @param disponibilidadeSefazCteService serviço principal para lidar com disponibilidade Sefaz CT-e
     */
	@Autowired
	public DisponibilidadeSefazCTeController(DisponibilidadeSefazCTeService disponibilidadeSefazCteService) {
		super();

        Assert.notNull(disponibilidadeSefazCteService);

        this.disponibilidadeSefazCteService = disponibilidadeSefazCteService;
    }

	@Override
	@SuppressWarnings("unchecked")
	protected DisponibilidadeSefazCTeService getDFeService() {
		return disponibilidadeSefazCteService;
	}

}
