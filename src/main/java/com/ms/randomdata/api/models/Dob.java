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
public class Dob {

	@Column(name = "dob_date")
	private String dobDate;

	@Column(name = "dob_age")
	private int dobAge;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dob [date=");
		builder.append(dobDate);
		builder.append(", age=");
		builder.append(dobAge);
		builder.append("]");
		return builder.toString();
	}

}
