package com.praktycznajava.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class HazelcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastApplication.class, args);
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        Map<Long, String> map = hazelcastInstance.getMap("data");

        addEntries(map, hazelcastInstance);
        createClient();
    }


    public static void addEntries(Map<Long, String> map, HazelcastInstance hazelcastInstance)
    {
        FlakeIdGenerator idGenerator = hazelcastInstance.getFlakeIdGenerator("newid");
        for (int i = 0; i < 10; i++) {
            map.put(idGenerator.newId(), "message" + i);
        }
    }

    public static void createClient()
    {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);

        Map<Long, String> map = hazelcastInstanceClient.getMap("data");
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

}
