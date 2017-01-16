package br.com.disponibilidadesefaz.nfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.disponibilidadesefaz.dfe.controller.AbstractDisponibilidadeSefazDFeCtrl;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFe;
import br.com.disponibilidadesefaz.nfe.service.DisponibilidadeSefazNFeService;

@RestController
@RequestMapping({"/nfe", "/nf-e", "/NFe", "/NF-e"})
public class DisponibilidadeSefazNFeController extends AbstractDisponibilidadeSefazDFeCtrl<DisponibilidadeSefazNFe> {

	private final DisponibilidadeSefazNFeService disponibilidadeSefazNfeService;

	/**
     * Constrói os endpoints para expor operações relacionadas
     * a disponibilidade da Sefaz de NF-e.
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
