package com.roytrack.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.concurrent.ConcurrentMap;

/**
 * 添加map还有序列化问题
 *
 * @author roytrack
 * @time 2018/7/26 上午11:30
 */
public class BasicMapOperations {
    private HazelcastInstance instance = Hazelcast.newHazelcastInstance();

    public static void main(String[] args) {
        BasicMapOperations basicMapOperations = new BasicMapOperations();
        basicMapOperations.instance.addDistributedObjectListener(new SampleForListener());
        Customer c = new Customer("22");
        c.setName("roy");
        c.setAge(23);
        basicMapOperations.addCustomer(c);
        c = c.clone(c);
        c.setId("23");
        basicMapOperations.addCustomer(c);
        c = c.clone(c);
        c.setId("22");
        basicMapOperations.removeCustomer(c);
        c = c.clone(c);
        c.setId("24");
        basicMapOperations.updateCustomer(c);
        ConcurrentMap<String, Customer> customerConcurrentMap = basicMapOperations.instance.getMap("customers");
        System.out.println(customerConcurrentMap.size());
        ((IMap<String, Customer>) customerConcurrentMap).destroy();
        System.out.println(customerConcurrentMap.size());

    }

    public Customer getCustomer(String id) {
        ConcurrentMap<String, Customer> customerConcurrentMap = instance.getMap("customers");
        Customer customer = customerConcurrentMap.get(id);
        if (customer == null) {
            customer = new Customer(id);
            customer = ((IMap<String, Customer>) customerConcurrentMap).putIfAbsent(id, customer);
        }
        return customer;
    }

    public boolean updateCustomer(Customer customer) {
        ConcurrentMap<String, Customer> customerConcurrentMap = instance.getMap("customers");
        return (customerConcurrentMap.replace(customer.getId(), customer) != null);
    }

    public boolean removeCustomer(Customer customer) {
        ConcurrentMap<String, Customer> customerConcurrentMap = instance.getMap("customers");
        return customerConcurrentMap.remove(customer.getId(), customer);
    }

    public Customer addCustomer(Customer customer) {
        ConcurrentMap<String, Customer> customerConcurrentMap = instance.getMap("customers");
        return customerConcurrentMap.put(customer.getId(), customer);
    }


}
