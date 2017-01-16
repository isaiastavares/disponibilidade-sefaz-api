package br.com.disponibilidadesefaz.nfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.disponibilidadesefaz.dfe.controller.AbstractDisponibilidadeSefazDFeCtrl;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFe;
import br.com.disponibilidadesefaz.nfe.service.DisponibilidadeSefazNFeService;

/**
 * Controlador que expõe endpoints relacionados
 * a disponibilidade dos serviços de NF-e.
 *
 * @author Isaias Tavares
 *
 */
@RestController
@RequestMapping({"/nfe", "/nf-e", "/NFe", "/NF-e"})
public class DisponibilidadeSefazNFeController extends AbstractDisponibilidadeSefazDFeCtrl<DisponibilidadeSefazNFe> {

	private final DisponibilidadeSefazNFeService disponibilidadeSefazNfeService;

	/**
     * Constrói o controlador responsável por expor endpoints relacionados a
     * disponibilidade dos serviços de NF-e.
     *
     * Realiza a validação dos parâmetros para que nenhum esteja nulo.
     *
	 * @param disponibilidadeSefazNfeService serviço principal para lidar com disponibilidade Sefaz NF-e
     */
	@Autowired
	public DisponibilidadeSefazNFeController(DisponibilidadeSefazNFeService disponibilidadeSefazNfeService) {
		super();

        Assert.notNull(disponibilidadeSefazNfeService);

        this.disponibilidadeSefazNfeService = disponibilidadeSefazNfeService;
    }

	@Override
	@SuppressWarnings("unchecked")
	protected DisponibilidadeSefazNFeService getDFeService() {
		return disponibilidadeSefazNfeService;
	}

}
