package com.spectrun.spectrum.config.kafka;

import com.spectrun.spectrum.MessageTemplate.createInstanceResponse;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class kafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, createInstanceResponse> createInstanceConsumer() {
        Map<String, Object> props = new HashMap<>();

        // Set the broker address
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");

        // Set the group ID (ensure consistency with the listener)
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "response_group");

        // Set key deserializer
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        // Configure the JsonDeserializer directly without conflicting properties
        JsonDeserializer<createInstanceResponse> jsonDeserializer = new JsonDeserializer<>(createInstanceResponse.class);
        jsonDeserializer.addTrustedPackages("com.spectrun.spectrum.MessageTemplate");

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, createInstanceResponse> concurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, createInstanceResponse> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(createInstanceConsumer());
        return factory;
    }
}
