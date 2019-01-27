package com.xyz.ekart.repository;

import java.util.List;

import javax.inject.Inject;

import com.xyz.ekart.constant.EkartConstants;
import com.xyz.ekart.model.Product;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import play.db.ebean.EbeanConfig;
import play.db.ebean.EbeanDynamicEvolutions;

public class ProductRepository {

	private final EbeanServer ebeanServer;

	@Inject
	public ProductRepository(EbeanConfig ebeanConfig, EbeanDynamicEvolutions ebeanDynamicEvolutions) {
		this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
	}
	
	public Product findById(Long id) {
		return ebeanServer.find(Product.class,id);
	}
	
	public List<Product> getAllActiveProduct(){
		return ebeanServer.find(Product.class).where().eq("status",EkartConstants.ACTIVE).findList();
	}
	
	public void save(Product product) {
		ebeanServer.save(product);
	}
}
