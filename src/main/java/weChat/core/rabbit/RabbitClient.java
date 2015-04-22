package weChat.core.rabbit;

import java.util.UUID;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitClient {

	private final AmqpAdmin amqpAdmin;

	private final RabbitTemplate rabbitTemplate;

	@Autowired
	public RabbitClient(AmqpAdmin amqpAdmin, RabbitTemplate rabbitTemplate) {
		this.amqpAdmin = amqpAdmin;
		this.rabbitTemplate = rabbitTemplate;
	}

	public Object convertSendAndReceive(final String routingKey,
			final Object message) {
		Object result = rabbitTemplate.convertSendAndReceive(routingKey,
				message, messagePostProcessor());
		return result;
	}

	@Bean()
	public MessagePostProcessor messagePostProcessor() {
		return (message) -> {
			MessageProperties properities = message.getMessageProperties();
			String corrId = UUID.randomUUID().toString();
			properities.setCorrelationId(corrId.getBytes());

			return message;
		};
	}

}
