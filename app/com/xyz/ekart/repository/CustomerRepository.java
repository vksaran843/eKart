package com.xyz.ekart.repository;

import javax.inject.Inject;

import com.xyz.ekart.model.Customer;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;
import play.db.ebean.EbeanDynamicEvolutions;

public class CustomerRepository {

	private final EbeanServer ebeanServer;
	
	@Inject
	public CustomerRepository(EbeanConfig ebeanConfig, EbeanDynamicEvolutions ebeanDynamicEvolutions) {
		this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
	}
	
	public Customer findById(Long id) {
		return ebeanServer.find(Customer.class,id);
	}
	
	public void save(Customer customer) {
		ebeanServer.save(customer);
	}
}
