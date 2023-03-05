package com.ms.randomdata.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ModelId {

	@Column(name = "id_name")
	private String name;

	@Column(name = "value")
	private String value;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModelId [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
