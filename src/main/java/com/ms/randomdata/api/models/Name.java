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
public class Name {

	@Column(name = "title")
	private String title;

	@Column(name = "first")
	private String first;

	@Column(name = "last")
	private String last;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name [title=");
		builder.append(title);
		builder.append(", first=");
		builder.append(first);
		builder.append(", last=");
		builder.append(last);
		builder.append("]");
		return builder.toString();
	}

}
