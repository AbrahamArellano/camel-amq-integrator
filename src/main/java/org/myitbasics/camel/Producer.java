/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.myitbasics.camel;

import java.util.logging.Logger;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * An example class for demonstrating some of the basics behind Camel. This
 * example sends some text messages on to a JMS Queue, consumes them and
 * persists them to disk
 */
public final class Producer {

	private static Logger LOG = Logger.getLogger(Producer.class.getName());
	
    private Producer() {        
    }
    
    public static void main(String args[]) throws Exception {
        // START SNIPPET: e1
        CamelContext context = new DefaultCamelContext();
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        // Now send some test text to a component - for this case a JMS Queue
        // The text get converted to JMS messages - and sent to the Queue
        // test.queue
        // The file component is listening for messages from the Queue
        // test.queue, consumes
        // them and stores them to disk. The content of each file will be the
        // test we sent here.
        // The listener on the file component gets notified when new files are
        // found ... that's it!
        for (int i = 0; i < 10; i++) {
            template.sendBody("activemq:queue:instantpayments.ing.beneficiary.payment.request?username=gpays&password=gpays", "Test Message: " + i);
            LOG.info("Sending message: " + i); 
        }

        // wait a bit and then stop
        Thread.sleep(1000);
        context.stop();
    }
}
