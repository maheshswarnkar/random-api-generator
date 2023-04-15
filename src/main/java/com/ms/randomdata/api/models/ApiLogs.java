package com.ms.randomdata.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "api_logs")
public class ApiLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "loggerInfo")
	private String loggerInfo;

	@Column(name = "uid")
	private String uid;

	@Column(name = "logGenerationTime")
	private String logGenerationTime;

	@Column(name = "workFlowName")
	private String workFlowName;

	@Column(name = "stageName")
	private String stageName;

	@Column(name = "message")
	private String message;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApiLogs [id=");
		builder.append(id);
		builder.append(", loggerInfo=");
		builder.append(loggerInfo);
		builder.append(", uid=");
		builder.append(uid);
		builder.append(", logGenerationTime=");
		builder.append(logGenerationTime);
		builder.append(", workFlowName=");
		builder.append(workFlowName);
		builder.append(", stageName=");
		builder.append(stageName);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

}
