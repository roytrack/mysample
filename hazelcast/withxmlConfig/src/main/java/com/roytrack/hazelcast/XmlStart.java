package com.roytrack.hazelcast;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


public class XmlStart {
  public static void main(String[] args) {
    HazelcastInstance instance = Hazelcast.newHazelcastInstance();
    Map<Integer, String> mapCustomers = instance.getMap("customers");
    mapCustomers.put(1, "Joe");
    mapCustomers.put(2, "Bob");
    mapCustomers.put(3, "Roy");
    System.out.println("Customer with key 1: " + mapCustomers.get(1));
    System.out.println("Map Size:" + mapCustomers.size());
  }

  public void fileConfig() {
    String xmlFileName = "";
    InputStream inputStream = new ByteArrayInputStream("".getBytes());
    String configFilename = "";
    String url = "";
    String xml = "";


    Config cfg = null;
    try {
      cfg = new XmlConfigBuilder(xmlFileName).build();
      cfg = new XmlConfigBuilder(inputStream).build();
      cfg = new ClasspathXmlConfig(xmlFileName);
      cfg = new FileSystemXmlConfig(configFilename);
      cfg = new UrlXmlConfig(url);
      cfg = new InMemoryXmlConfig(xml);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
