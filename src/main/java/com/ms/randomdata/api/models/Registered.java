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
public class Registered {

	@Column(name = "reg_date")
	private String regDate;

	@Column(name = "reg_age")
	private int regAge;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Registered [date=");
		builder.append(regDate);
		builder.append(", age=");
		builder.append(regAge);
		builder.append("]");
		return builder.toString();
	}

}
