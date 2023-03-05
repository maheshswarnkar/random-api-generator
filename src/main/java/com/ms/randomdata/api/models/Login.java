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
public class Login {

	@Column(name = "uuid")
    private String uuid;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "salt")
    private String salt;
	
	@Column(name = "md5")
    private String md5;
	
	@Column(name = "sha1")
    private String sha1;
	
	@Column(name = "sha256")
    private String sha256;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [uuid=");
		builder.append(uuid);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", salt=");
		builder.append(salt);
		builder.append(", md5=");
		builder.append(md5);
		builder.append(", sha1=");
		builder.append(sha1);
		builder.append(", sha256=");
		builder.append(sha256);
		builder.append("]");
		return builder.toString();
	}
    

	
}
