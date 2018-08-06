package demo

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey

class InboundMessage(@DynamoDBAttribute val attribute1: String, @DynamoDBAttribute val attribute2: String) {

    @DynamoDBHashKey()
    var id : String = generateId()

    fun generateId() : String {
        return attribute1 + "_" + attribute2

    }
}