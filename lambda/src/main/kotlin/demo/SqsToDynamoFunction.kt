package demo

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.sqs.model.Message

class SqsToDynamoFunction : RequestHandler<Message, String> {

    override fun handleRequest(input: Message?, context: Context?): String {

        val environment = System.getenv("Environment")
        val region = System.getenv("Region")

        // TODO: parse inbound message

        //

        // TODO: setup mapper and write to dynamo

        //        val dynamoDBClient = AmazonDynamoDBClientBuilder
        //                .standard()
        //                .withRegion(region)
        //                .build()

        //        val config = DynamoDBMapperConfig.builder()
        //                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride
        //                        .withTableNamePrefix("$environment-")).build();

        //        val mapper = DynamoDBMapper(dynamoDBClient, config)

        //        mapper.save(it)

        TODO("not implemented")
    }
}