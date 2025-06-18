package com.techtez.aws.sqslambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techtez.aws.sqslambda.db.DatabaseClient;
import com.techtez.aws.sqslambda.model.College;

public class SqsLambdaHandler implements RequestHandler<SQSEvent, Void> {

	private static final Logger logger = LogManager.getLogger(SqsLambdaHandler.class);
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public Void handleRequest(SQSEvent event, Context context) {

		for (SQSEvent.SQSMessage msg : event.getRecords()) {

			try {

				logger.info("Received message: {}", msg.getBody());

				College college = mapper.readValue(msg.getBody(), College.class);
				DatabaseClient.insertCollege(college);

				logger.info("Successfully processed college: {}", college.getCollegeName());
				
			} catch (Exception e) {

				logger.error("Error processing message: {}", e);
			}
		}

		return null;
	}
}
