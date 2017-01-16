package br.com.disponibilidadesefaz.enuns;

/**
 * Enum que representa o Tipo de Emissão.
 * Se Normal ou Contingência
 *
 * @author Isaias Tavares
 *
 */
public enum TipoEmissao {

	NORMAL(1, "Normal"),
	CONTINGENCIA(2, "Contingência");

	private final Integer codigo;
    private final String descricao;

	TipoEmissao(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	/**
	 * Retorna {@link TipoEmissao} a partir do código
	 *
	 * @param codigo que representa o tipo de emissão
	 * @return {@link TipoEmissao}
	 */
	public static TipoEmissao valueOfCodigo(final Integer codigo) {
        for (final TipoEmissao tipo : TipoEmissao.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        return null;
    }
}
