package com.ms.randomdata.api.models;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultList {

	@Column(name = "results")
	private List<Result> results;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResultList [results=");
		builder.append(results);
		builder.append("]");
		return builder.toString();
	}

}
