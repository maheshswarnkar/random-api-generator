package com.ms.randomdata.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Info {

	@Column(name = "seed")
	private String seed;

	@Column(name = "results")
	private String results;

	@Column(name = "page")
	private String page;

	@Column(name = "version")
	private String version;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Info [seed=");
		builder.append(seed);
		builder.append(", results=");
		builder.append(results);
		builder.append(", page=");
		builder.append(page);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

}
