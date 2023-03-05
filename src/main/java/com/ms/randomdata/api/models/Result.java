package com.ms.randomdata.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Result {

	@Column(name = "gender")
	private String gender;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "title", column = @Column(name = "title")),
			@AttributeOverride(name = "first", column = @Column(name = "first")),
			@AttributeOverride(name = "last", column = @Column(name = "last")) })
	private Name name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "street")),
			@AttributeOverride(name = "city", column = @Column(name = "city")),
			@AttributeOverride(name = "state", column = @Column(name = "state")),
			@AttributeOverride(name = "country", column = @Column(name = "country")),
			@AttributeOverride(name = "postcode", column = @Column(name = "postcode")),
			@AttributeOverride(name = "coordinates", column = @Column(name = "coordinates")),
			@AttributeOverride(name = "timezone", column = @Column(name = "timezone")) })
	private Location location;

	@Column(name = "email")
	private String email;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "uuid", column = @Column(name = "uuid")),
			@AttributeOverride(name = "username", column = @Column(name = "username")),
			@AttributeOverride(name = "password", column = @Column(name = "password")),
			@AttributeOverride(name = "salt", column = @Column(name = "salt")),
			@AttributeOverride(name = "md5", column = @Column(name = "md5")),
			@AttributeOverride(name = "sha1", column = @Column(name = "sha1")),
			@AttributeOverride(name = "sha256", column = @Column(name = "sha256")) })
	private Login login;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "date", column = @Column(name = "date")),
			@AttributeOverride(name = "age", column = @Column(name = "age")) })
	private Dob dob;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "date", column = @Column(name = "date")),
			@AttributeOverride(name = "age", column = @Column(name = "age")) })
	private Registered registered;

	@Column(name = "phone")
	private String phone;

	@Column(name = "cell")
	private String cell;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "id_name", column = @Column(name = "id_name")),
			@AttributeOverride(name = "value", column = @Column(name = "value")) })
	private ModelId modelId;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "large", column = @Column(name = "large")),
			@AttributeOverride(name = "medium", column = @Column(name = "medium")),
			@AttributeOverride(name = "thumbnail", column = @Column(name = "thumbnail")) })
	private Picture picture;

	@Column(name = "nat")
	private String nat;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [gender=");
		builder.append(gender);
		builder.append(", name=");
		builder.append(name);
		builder.append(", location=");
		builder.append(location);
		builder.append(", email=");
		builder.append(email);
		builder.append(", login=");
		builder.append(login);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", registered=");
		builder.append(registered);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", cell=");
		builder.append(cell);
		builder.append(", modelId=");
		builder.append(modelId);
		builder.append(", picture=");
		builder.append(picture);
		builder.append(", nat=");
		builder.append(nat);
		builder.append("]");
		return builder.toString();
	}

}
