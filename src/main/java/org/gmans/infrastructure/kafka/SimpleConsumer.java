package org.gmans.infrastructure.kafka;

import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class SimpleConsumer {
    public static void main(String[] args) {
        //kafka consumer configuration settings
        String topicName = "test-topic";
        Properties properties = new Properties();

        properties.put("bootstrap.servers","localhost:9092");
        properties.put("group.id","test-group");
        properties.put("enable.auto.commit","true");
        properties.put("auto.commit.interval.ms","1000");
        properties.put("session.timeout.ms","30000");
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        //kafka consumer subscribes list of topics here
        consumer.subscribe(Arrays.asList(topicName));

        //print the topic name
        System.out.println("Subscribed to topic "+ topicName);

        int i = 0;

        while(true){
            ConsumerRecords<String, String> records = consumer.poll(100);
          //  System.out.println(records.isEmpty());
            for(ConsumerRecord<String, String> record : records) {
                //print the offset, key and value for the consumer records
           //     System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.key(), record.value());
                System.out.println("offset ="+record.offset()+", key = "+record.key()+", value = "+ record.value());
            }
        }

    }
}
