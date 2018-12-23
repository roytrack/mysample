package com.roytrack.hazelcast.distributed.data.structure.map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.concurrent.ConcurrentMap;

/**
 * 注意添加到hazelcast中的内容需要增加序列化
 * 所以添加一个对象不需要克隆就可以加很多了
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

        c.setId("23");
        basicMapOperations.addCustomer(c);

        c.setId("22");
        basicMapOperations.removeCustomer(c);
        //不需要克隆了
        //c = c.clone(c);
        c.setId("24");
        basicMapOperations.updateCustomer(c);
        ConcurrentMap<String, Customer> customerConcurrentMap = basicMapOperations.instance.getMap("customers");
        System.out.println(customerConcurrentMap.size());
        ((IMap<String, Customer>) customerConcurrentMap).destroy();
        System.out.println(customerConcurrentMap.size());
        basicMapOperations.addCustomer(c);
        c.setId("2");
        basicMapOperations.addCustomer(c);
        c.setId("3");
        basicMapOperations.addCustomer(c);
        c.setId("4");
        basicMapOperations.addCustomer(c);
        System.out.println(customerConcurrentMap.size());
        System.out.println(basicMapOperations.getCustomer("2"));
      basicMapOperations.instance.shutdown();
      ;
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
