package demo

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.sqs.model.Message
import com.google.gson.Gson

class SqsToDynamoFunction : RequestHandler<Message, String> {

    override fun handleRequest(input: Message?, context: Context?): String {

        //val environment = System.getenv("Environment")
        val region = System.getenv("Region")
        val tableName = System.getenv("OutboundDynamoTable")

        val body = input!!.body

        val gson = Gson();
        val inbound = gson.fromJson(body, InboundMessage::class.java)

        val dynamoDBClient = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(region)
                .build()

        val config = DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride
                        .withTableNameReplacement(tableName)).build();

        val mapper = DynamoDBMapper(dynamoDBClient, config)

        mapper.save(inbound)

        return "{}"
    }
}