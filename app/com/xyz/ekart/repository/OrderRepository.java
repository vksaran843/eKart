package com.xyz.ekart.repository;

import java.util.List;

import javax.inject.Inject;

import com.xyz.ekart.model.Order;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;
import play.db.ebean.EbeanDynamicEvolutions;

public class OrderRepository {

	private final EbeanServer ebeanServer;

	@Inject
	public OrderRepository(EbeanConfig ebeanConfig, EbeanDynamicEvolutions ebeanDynamicEvolutions) {
		this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
	}
	
	public Order findById(Long id) {
		return ebeanServer.find(Order.class,id);
	}
	
	public void save(Order order) {
		ebeanServer.save(order);
	}
	
	public List<Order> getAllOrderList(Long customerId) {
		return ebeanServer.find(Order.class).where().eq("customerId.customerId", customerId).findList();
	}
}
