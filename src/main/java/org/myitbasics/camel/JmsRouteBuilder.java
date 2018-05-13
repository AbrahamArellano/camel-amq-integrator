package org.myitbasics.camel;

import org.apache.camel.builder.RouteBuilder;

public class JmsRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("activemq:queue:testclient.payment.request")
			.log("Consuming...")
			.bean(Consumer.class);
	}

}
