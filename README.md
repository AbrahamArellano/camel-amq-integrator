# JMS & File Example

### Introduction
This example creates a simple producer and consumer using camel framework.

### Build

You will need to compile this example first:

	mvn compile

### Consumer Run  

The example should run if you type

	mvn camel:run

This will create 10 concurrent consumers of the queue "instantpayments.ing.beneficiary.payment.request"

### Producer Run

To run this example:

	Right click on the java class -> Run As -> Java Application

This will send 10 messages to the queue "instantpayments.ing.beneficiary.payment.request"
  

