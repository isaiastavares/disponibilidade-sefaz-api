package br.com.disponibilidadesefaz.nfce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.disponibilidadesefaz.dfe.controller.AbstractDisponibilidadeSefazDFeCtrl;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFCe;
import br.com.disponibilidadesefaz.nfce.service.DisponibilidadeSefazNFCeService;

/**
 * Controlador que expõe endpoints relacionados
 * a disponibilidade dos serviços de NFC-e.
 *
 * @author Isaias Tavares
 *
 */
@RestController
@RequestMapping({"/nfce", "/nfc-e", "/NFCe", "/NFC-e"})
public class DisponibilidadeSefazNFCeController extends AbstractDisponibilidadeSefazDFeCtrl<DisponibilidadeSefazNFCe> {

	private final DisponibilidadeSefazNFCeService disponibilidadeSefazNfceService;

	/**
     * Constrói o controlador responsável por expor endpoints relacionados a
     * disponibilidade dos serviços de NFC-e.
     *
     * Realiza a validação dos parâmetros para que nenhum esteja nulo.
     *
	 * @param disponibilidadeSefazNfceService serviço principal para lidar com disponibilidade Sefaz NFC-e
     */
	@Autowired
	public DisponibilidadeSefazNFCeController(DisponibilidadeSefazNFCeService disponibilidadeSefazNfceService) {
		super();

        Assert.notNull(disponibilidadeSefazNfceService);

        this.disponibilidadeSefazNfceService = disponibilidadeSefazNfceService;
    }

	@Override
	@SuppressWarnings("unchecked")
	protected DisponibilidadeSefazNFCeService getDFeService() {
		return disponibilidadeSefazNfceService;
	}

}
