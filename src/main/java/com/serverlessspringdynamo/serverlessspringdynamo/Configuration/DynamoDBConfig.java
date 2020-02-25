package com.serverlessspringdynamo.serverlessspringdynamo.Configuration;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.PaginationLoadingStrategy;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDBConfig {

	@Bean
	public DynamoDBMapper dynamodbmapper() {
		return new DynamoDBMapper(dynamodbprovider(), config());
	}
	private DynamoDBMapperConfig config() {
		return DynamoDBMapperConfig.builder().withPaginationLoadingStrategy(PaginationLoadingStrategy.LAZY_LOADING)
				.build();
	}
	@Bean
	public AmazonDynamoDB dynamodbprovider() {
		return AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider()).build();
	}
	@Bean
	private AWSCredentialsProvider credentialsProvider() {
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials("", ""));
	}
}
