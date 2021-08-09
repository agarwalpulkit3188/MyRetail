package com.myretail.myRetail.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.myretail.myRetail.model.ProductDetails;

@Configuration
@EnableKafka
public class ReceiverConfig {
private String bootStrapServer="localhost:9092";
	
//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, ProductDetails> producerFactory(){
//		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
//		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group_store");
//		return new ConcurrentKafkaListenerContainerFactory<String, ProductDetails>();			
//	}
	
	
	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-store");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		return props;
	}
	

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ProductDetails> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, ProductDetails> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(new DefaultKafkaConsumerFactory<String,ProductDetails>(consumerConfigs(),new org.apache.kafka.common.serialization.StringDeserializer(),new org.springframework.kafka.support.serializer.JsonDeserializer<>(ProductDetails.class)
				));

		return factory;
	}


	
}
