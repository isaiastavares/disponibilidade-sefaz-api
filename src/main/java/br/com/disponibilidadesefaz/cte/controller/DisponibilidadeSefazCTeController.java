package br.com.disponibilidadesefaz.cte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.disponibilidadesefaz.cte.service.DisponibilidadeSefazCTeService;
import br.com.disponibilidadesefaz.dfe.controller.AbstractDisponibilidadeSefazDFeCtrl;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazCTe;

/**
 * Controlador que expõe endpoints relacionados
 * a disponibilidade dos serviços de CT-e.
 *
 * @author Isaias Tavares
 *
 */
@RestController
@RequestMapping({"/cte", "/ct-e", "/CTe", "/CT-e"})
public class DisponibilidadeSefazCTeController extends AbstractDisponibilidadeSefazDFeCtrl<DisponibilidadeSefazCTe> {

	private final DisponibilidadeSefazCTeService disponibilidadeSefazCteService;

	/**
     * Constrói o controlador responsável por expor endpoints relacionados a
     * disponibilidade dos serviços de CT-e.
     *
     * Realiza a validação dos parâmetros para que nenhum esteja nulo.
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
