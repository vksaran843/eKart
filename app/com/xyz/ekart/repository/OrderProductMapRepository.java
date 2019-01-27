package com.xyz.ekart.repository;

import java.util.List;

import javax.inject.Inject;

import com.xyz.ekart.model.Order;
import com.xyz.ekart.model.OrderProductMap;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;
import play.db.ebean.EbeanDynamicEvolutions;

public class OrderProductMapRepository {

	private final EbeanServer ebeanServer;
	
	@Inject
	public OrderProductMapRepository(EbeanConfig ebeanConfig, EbeanDynamicEvolutions ebeanDynamicEvolutions) {
		this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
	}
	
	public OrderProductMap findById(Long id) {
		return ebeanServer.find(OrderProductMap.class,id);
	}
	
	public void save(OrderProductMap orderProductMap) {
		ebeanServer.save(orderProductMap);
	}
	
	public List<OrderProductMap> productListByOrderId(Order order) {
		return ebeanServer.find(OrderProductMap.class).where().eq("orderId", order).findList();
	}
}
