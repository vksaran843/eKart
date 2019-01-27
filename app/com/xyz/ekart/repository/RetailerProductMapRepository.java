package com.xyz.ekart.repository;

import javax.inject.Inject;

import com.xyz.ekart.model.RetailerProductMap;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;
import play.db.ebean.EbeanDynamicEvolutions;

public class RetailerProductMapRepository {

	private final EbeanServer ebeanServer;

	@Inject
	public RetailerProductMapRepository(EbeanConfig ebeanConfig, EbeanDynamicEvolutions ebeanDynamicEvolutions) {
		this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
	}
	
	public RetailerProductMap findById(Long id) {
		return ebeanServer.find(RetailerProductMap.class,id);
	}
	
	public void save(RetailerProductMap retailerProductMap) {
		ebeanServer.save(retailerProductMap);
	}
}
