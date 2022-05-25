package com.hazelcast.sqlizer;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.nio.serialization.GenericRecord;
import com.hazelcast.nio.serialization.GenericRecordBuilder;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
    public App()
    {
    }

    public static void main( String[] args )
    {
        App app = new App();
        app.run();
    }

    @Override
    public void run( )
    {
        try {
            XmlClientConfigBuilder configBuilder =
                    new XmlClientConfigBuilder(new File("src/main/resources/client.xml"));
            HazelcastInstance client = HazelcastClient.newHazelcastClient(configBuilder.build());
        } catch (IOException e) {
            System.err.println("unable to read configuration XML: " + e.getMessage());
            System.exit(127);
        }
        
        // Creating New Compact Objects
        GenericRecord employeeOne = GenericRecordBuilder.compact("employee")
        			.setString("name", "Charles Harris")
        			.setInt32("id", 100)
        			.build();
        
        GenericRecord employeeTwo = GenericRecordBuilder.compact("employee")
    			.setString("name", "Lucas Beeler")
    			.setInt32("id", 110)
    			.build();

    }
}
