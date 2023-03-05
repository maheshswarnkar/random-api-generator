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
public class Picture {

	@Column(name = "large")
	private String large;

	@Column(name = "medium")
	private String medium;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Picture [large=");
		builder.append(large);
		builder.append(", medium=");
		builder.append(medium);
		builder.append(", thumbnail=");
		builder.append(thumbnail);
		builder.append("]");
		return builder.toString();
	}

}
