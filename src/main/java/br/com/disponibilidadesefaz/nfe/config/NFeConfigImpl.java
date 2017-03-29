package br.com.disponibilidadesefaz.nfe.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.NFeConfig;

/**
 * Implementação da configuração de NF-e e NFC-e.
 *
 * @author Isaias Tavares
 *
 */
public class NFeConfigImpl extends NFeConfig {

    private static final String CAMINHO_CERTIFICADO = "D:/Certificados/certificado.pfx";
    private static final String CACERT_PRODUCAO = "producao.cacerts";
    private static final String CAMINHO_CADEIA_SERTIFICADO = System.getProperty("java.home") + "/lib/security/" + CACERT_PRODUCAO;

    private KeyStore keyStoreCertificado = null;
    private KeyStore keyStoreCadeia = null;

    @Override
    public DFAmbiente getAmbiente() {
        return DFAmbiente.PRODUCAO;
    }

    @Override
    public DFUnidadeFederativa getCUF() {
        return DFUnidadeFederativa.RS;
    }

    @Override
    public String getCertificadoSenha() {
        return "senhacertificado";
    }

    @Override
    public String getCadeiaCertificadosSenha() {
        return "disponibilidadeSefaz";
    }

    @Override
    public KeyStore getCertificadoKeyStore() throws KeyStoreException {
        if (this.keyStoreCertificado == null) {
            this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
            try (InputStream certificadoStream = new FileInputStream(CAMINHO_CERTIFICADO)) {
                this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possibel montar o KeyStore com a cadeia de certificados", e);
            }
        }
        return this.keyStoreCertificado;
    }

    @Override
    public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
        if (this.keyStoreCadeia == null) {
            this.keyStoreCadeia = KeyStore.getInstance("JKS");
            try (InputStream cadeia = new FileInputStream(CAMINHO_CADEIA_SERTIFICADO)) {
                this.keyStoreCadeia.load(cadeia, this.getCadeiaCertificadosSenha().toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possibel montar o KeyStore com o certificado", e);
            }
        }
        return this.keyStoreCadeia;
    }
}
