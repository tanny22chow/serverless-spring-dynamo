package com.serverlessspringdynamo.serverlessspringdynamo.Configuration;

import java.lang.annotation.Annotation;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDBConfig {

	@Bean
	public DynamoDBMapper dynamodbmapper() {
		return new DynamoDBMapper(new AmazonDynamoDBClient
				(AmazonDynamoDBClientBuilder.standard().withRegion("")
						.withCredentials(new BasicAWSCredentials("", "")))
				.build())))
	}
}
