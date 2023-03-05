package com.ms.randomdata.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Location {

	@JoinColumn(name = "street")
	public Street street;

	@Column(name = "city")
	public String city;

	@Column(name = "state")
	public String state;

	@Column(name = "country")
	public String country;

	@Column(name = "postcode")
	public String postcode;

	@JoinColumn(name = "coordinates")
	public Coordinates coordinates;

	@JoinColumn(name = "timezone")
	public Timezone timezone;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Location [street=");
		builder.append(street);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", country=");
		builder.append(country);
		builder.append(", postcode=");
		builder.append(postcode);
		builder.append(", coordinates=");
		builder.append(coordinates);
		builder.append(", timezone=");
		builder.append(timezone);
		builder.append("]");
		return builder.toString();
	}

}
