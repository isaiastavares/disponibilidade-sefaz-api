package br.com.disponibilidadesefaz.dfe;

import java.util.Date;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

import br.com.disponibilidadesefaz.entidade.DisponibilidadeSefazDFe;
import br.com.disponibilidadesefaz.enuns.TipoEmissao;

/**
 * Interface que contém os métodos comuns das
 * entidades referente a disponibilidade do
 * serviços da Sefaz.
 *
 * @see {@link DisponibilidadeSefazDFe}
 * @author Isaias Tavares
 *
 */
public interface IDisponibilidadeSefazDFe {

	/**
	 * ID do registro no banco de dados.
	 * @return o id do registro no banco de dados
	 */
	Long getId();

	/**
	 * Uma instância de {@link DFUnidadeFederativa}
	 * contendo o estado em que foi realizado a consulta
	 *
	 * @return uma instância de {@link DFUnidadeFederativa}
	 * contendo o estado em que foi realizado a consulta
	 */
	DFUnidadeFederativa getEstadoType();

	/**
	 * Código do status da resposta.
	 *
	 * Se for sucesso, o código é 107.
	 *
	 * @return o código do status da resposta.
	 */
	Integer getStatusServico();

	/**
	 * Descrição literal do status da resposta.
	 *
	 * @return a descrição literal do status da resposta.
	 */
	String getXMotivo();

	/**
	 * Tempo médio de resposta do serviço
	 * (em segundos) dos últimos 5 minutos
	 *
	 * @return o tempo médio de resposta do serviço
	 * (em segundos) dos últimos 5 minutos
	 */
	Integer getTMed();

	/**
	 * A data da última consulta do status do
	 * serviço que foi realizada na SEFAZ.
	 *
	 * @return a data da última consulta do status do
	 * serviço que foi realizada na SEFAZ.
	 */
	Date getDataUltimaConsulta();

	/**
	 * A data da última consulta do status do
	 * serviço que foi realizada na SEFAZ no
	 * formato "yyyy-MM-dd'T'HH:mm:ss".
	 *
	 * @return a data da última consulta do status do
	 * serviço que foi realizada na SEFAZ no
	 * formato "yyyy-MM-dd'T'HH:mm:ss".
	 */
	String getDataUltimaConsultaFormatada();

	/**
	 * Uma instância de {@link TipoEmissao} que indica
	 * se a consulta foi realizada no webservice normal
	 * ou no webservice de contingência.
	 *
	 * @return uma instância de {@link TipoEmissao} que indica
	 * se a consulta foi realizada no webservice normal
	 * ou no webservice de contingência.
	 */
	TipoEmissao getTipoEmissaoType();

	/**
	 * Informações adicionais para o Contribuinte que a Sefaz
	 * retorna ou em caso de falha, contém a exceção lançada.
	 *
	 * @return as informações adicionais para o Contribuinte que a Sefaz
	 * retorna ou em caso de falha, contém a exceção lançada.
	 */
	String getXObs();

}
