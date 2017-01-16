package br.com.disponibilidadesefaz.entidade.support;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Super classe que contém os métodos básicos
 * comum a todas as entidades.
 *
 * @author Isaias Tavares
 *
 */
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "_uuid")
public abstract class AbstractBaseEntity implements Entityable {

	private static final long serialVersionUID = -7268643932031369032L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Construtor padrão
	 */
	public AbstractBaseEntity() {
		super();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder().append(this.getClass().getName());
		if (this.getId() != null) {
			hashCodeBuilder.append("{").append("id : ").append(id).append("}");
		}
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		return new EqualsBuilder()
			.append(this.getId(), ((AbstractBaseEntity) obj).getId())
			.isEquals();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this);
		if (this.getId() != null) {
			toStringBuilder.append("{").append("id : ").append(id).append("}");
		}
		return toStringBuilder.toString();
	}

	@Override
	public boolean isNew() {
		return id == null;
	}

}
