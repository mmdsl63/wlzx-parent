package net.wanho.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-14 20:44
 **/
@Configuration
public class RabbitmqConfig {

    @Value("${wlzx.mq.exchange}")
    public  String exchange;

    @Value("${wlzx.mq.queue}")
    public  String queue;

    @Value("${wlzx.mq.routingKey}")
    public  String routingKey;

    @Bean
    public Queue creatQueue() {
        return new Queue(queue);
    }

    @Bean
    public Exchange creatExchange() {
        return ExchangeBuilder.directExchange(exchange).build();
    }

    @Bean
    public Binding bind(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs();
    }

}
