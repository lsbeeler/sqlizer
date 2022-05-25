package com.hazelcast.sqlizer;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;

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

    }
}
