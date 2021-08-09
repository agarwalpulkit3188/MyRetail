package com.myretail.myRetail.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.myretail.myRetail.model.ProductDetails;

@Configuration
public class SenderConfig {
	
	private String bootStrapServer="localhost:9092";
	
	@Bean
	public KafkaTemplate<String, ProductDetails> producerFactory(){
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new KafkaTemplate<String, ProductDetails>(new DefaultKafkaProducerFactory<String, ProductDetails>(properties));			
	}
	

}
