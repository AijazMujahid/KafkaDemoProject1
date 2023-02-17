# KafkaDemoProject1
Kafka Producer and Consumer

Start Zookeeper

C:\tools\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

#############

Start Kafka

C:\tools\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties

.\bin\windows\kafka-server-start.bat .\config\server.properties

#############

C:\tools\kafka>.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
Created topic test-topic.

.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1

.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --topic test-topic --describe
