package com.alcon.patient.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alcon.patient.dto.common.DBSecrets;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class DBAWSConfig {

	@Value("${spring.aws.secretsmanager.secretName}")
	private String secretId;

	@Value("${spring.datasource.driver-class-name}")
	private String driver;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.aws.secretsmanager.region}")
	private String awsRegion;

	@Bean
	public AWSSecretsManager awsSecretsManager() {
		return AWSSecretsManagerClientBuilder.standard().withRegion(awsRegion).build();
	}

	public <T> T getSecret(String secretName, Class<T> valueType) throws Exception {

		AWSSecretsManager client = AWSSecretsManagerClientBuilder.defaultClient();
		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretId);
		GetSecretValueResult getSecretValueResult = client.getSecretValue(getSecretValueRequest);
		String secretString = getSecretValueResult.getSecretString();
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(secretString, valueType);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource1() throws Exception {
		DBSecrets dbSecret = this.getSecret("mySecrets", DBSecrets.class);
		return DataSourceBuilder.create().username(dbSecret.getIoldt_mlops_user())
				.password(dbSecret.getIold_mlops_pwd()).driverClassName(this.driver).url(this.url).build();
	}
}