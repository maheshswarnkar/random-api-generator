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
public class Timezone {

	@Column(name = "offset")
	private String offset;

	@Column(name = "description")
	private String description;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Timezone [offset=");
		builder.append(offset);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
