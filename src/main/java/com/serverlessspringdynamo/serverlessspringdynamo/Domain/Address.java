package com.serverlessspringdynamo.serverlessspringdynamo.Domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamoDBDocument
public class Address {
	private String state;
	private Long pin;

}
