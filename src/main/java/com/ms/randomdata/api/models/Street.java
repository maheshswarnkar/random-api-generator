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
public class Street {

	@Column(name = "street_number")
	private String streetNumber;

	@Column(name = "street_name")
	private String streetName;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Street [streetNumber=");
		builder.append(streetNumber);
		builder.append(", streetName=");
		builder.append(streetName);
		builder.append("]");
		return builder.toString();
	}

}
