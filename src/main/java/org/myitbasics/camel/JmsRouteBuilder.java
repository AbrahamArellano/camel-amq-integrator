package org.myitbasics.camel;

import org.apache.camel.builder.RouteBuilder;

public class JmsRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("activemq:queue:instantpayments.ing.beneficiary.payment.request")
			.log("Consuming...")
			.bean(Consumer.class);
	}

}
