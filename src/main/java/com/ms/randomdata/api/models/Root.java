package com.ms.randomdata.api.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "random_api_data")
public class Root {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Embedded
	public Result result;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "seed", column = @Column(name = "seed")),
			@AttributeOverride(name = "results", column = @Column(name = "results")),
			@AttributeOverride(name = "page", column = @Column(name = "page")),
			@AttributeOverride(name = "version", column = @Column(name = "version")) })
	public Info info;

}
