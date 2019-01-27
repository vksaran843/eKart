package com.xyz.ekart.repository;

import javax.inject.Inject;

import com.xyz.ekart.model.Retailer;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;
import play.db.ebean.EbeanDynamicEvolutions;

public class RetailerRepository {

	private final EbeanServer ebeanServer;

	@Inject
	public RetailerRepository(EbeanConfig ebeanConfig, EbeanDynamicEvolutions ebeanDynamicEvolutions) {
		this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
	}
	
	public Retailer findById(Long id) {
		return ebeanServer.find(Retailer.class,id);
	}
	
	public void save(Retailer retailer) {
		ebeanServer.save(retailer);
	}
}
