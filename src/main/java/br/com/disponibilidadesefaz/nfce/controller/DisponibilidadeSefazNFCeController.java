package br.com.disponibilidadesefaz.nfce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.disponibilidadesefaz.dfe.controller.AbstractDisponibilidadeSefazDFeCtrl;
import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazNFCe;
import br.com.disponibilidadesefaz.nfce.service.DisponibilidadeSefazNFCeService;

@RestController
@RequestMapping({"/nfce", "/nfc-e", "/NFCe", "/NFC-e"})
public class DisponibilidadeSefazNFCeController extends AbstractDisponibilidadeSefazDFeCtrl<DisponibilidadeSefazNFCe> {

	private final DisponibilidadeSefazNFCeService disponibilidadeSefazNfceService;

	/**
     * Constrói os endpoints para expor operações relacionadas
     * a disponibilidade da Sefaz de NFC-e.
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
