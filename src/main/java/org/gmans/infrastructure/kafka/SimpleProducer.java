package org.gmans.infrastructure.kafka;

//import utl.properties package
import java.util.Properties;

//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import kafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import producer records packages
import org.apache.kafka.clients.producer.ProducerRecord;

//import org.apache.kafka.common.serialization.StringSerializer;

//create java class named "SimpleProducer"

public class SimpleProducer {

    public static void main(String[] args) throws Exception {
        //checks arguments length value
        /*if(args.length==0){
            System.out.println("Enter Topic name");
            return;
        }*/

        //Assign topic name to String variable
        //String topicName = args[0].toString();
        String topicName = "test-topic";

        //create instance for properties to access producer configs
        Properties properties = new Properties();

        //Assign localhost id
        properties.put("bootstrap.servers","localhost:9092");

        //set acknowledge for producer requests
        properties.put("acks","all");

        //if the requests fails the producer can automatically retry
        properties.put("retries",0);

        //specify buffer size in config
        properties.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        properties.put("linger.ms", 1);

        //the buffer.memory controls the total amount of memory available to the producer for buffering
        properties.put("buffer.memory",33554432);

        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);

        for(int i=50; i<60; i++)
            producer.send(new ProducerRecord<String, String>(topicName, Integer.toString(i), Integer.toString(i)));
        System.out.println("Message sent successfully");
        producer.close();
    }
}
