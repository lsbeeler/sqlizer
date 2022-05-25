package com.hazelcast.sqlizer;

import com.hazelcast.client.config.XmlClientConfigBuilder;

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
        } catch (IOException e) {
            System.err.println("unable to read configuration XML: " + e.getMessage());
            System.exit(127);
        }

    }
}
