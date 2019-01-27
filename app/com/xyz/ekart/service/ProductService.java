package com.xyz.ekart.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.xyz.ekart.constant.EkartConstants;
import com.xyz.ekart.controllers.ProductController;
import com.xyz.ekart.dto.AddProductRequestDto;
import com.xyz.ekart.dto.DeleteProductRequestDto;
import com.xyz.ekart.dto.GenericResponseDto;
import com.xyz.ekart.dto.ModifyProductRequestDto;
import com.xyz.ekart.model.Product;
import com.xyz.ekart.repository.ProductRepository;

public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Inject
	private ProductRepository productRepository;

	public CompletableFuture<GenericResponseDto> addProduct(AddProductRequestDto addProductRequestDto){
	
		
		GenericResponseDto genericResponseDto = new GenericResponseDto();
		genericResponseDto.setResponseCode("400");
		genericResponseDto.setStatus("Failure");
		genericResponseDto.setErrorCode("ADD_PRODUCT");
		genericResponseDto.setErrorMessage("unable to process your request");
		
		CompletableFuture<GenericResponseDto> future = new CompletableFuture<GenericResponseDto>();
		
		try {
			
			Product product = new Product();
			
			BeanUtils.copyProperties(addProductRequestDto, product);

			product.setStatus(EkartConstants.ACTIVE);
			product.setCreatedDate(LocalDateTime.now());
			productRepository.save(product);
			
			genericResponseDto.setResponseCode("200");
			genericResponseDto.setStatus("Success");
			genericResponseDto.setErrorCode(null);
			genericResponseDto.setErrorMessage(null);
			
			future.complete(genericResponseDto);
			return future;
			
		}catch(Exception ex) {
			System.out.println("Exception occured in addProduct::"+ex);

			future.complete(genericResponseDto);
			return future;
		}
	}
	
	
public CompletableFuture<GenericResponseDto> modifyProduct(ModifyProductRequestDto modifyProductRequestDto){
	
		
		GenericResponseDto genericResponseDto = new GenericResponseDto();
		genericResponseDto.setResponseCode("400");
		genericResponseDto.setStatus("Failure");
		genericResponseDto.setErrorCode("MODIFY_PRODUCT");
		genericResponseDto.setErrorMessage("unable to process your request");
		
		CompletableFuture<GenericResponseDto> future = new CompletableFuture<GenericResponseDto>();
		
		try {
			
			Product product = productRepository.findById(modifyProductRequestDto.getProductId());
			
			BeanUtils.copyProperties(modifyProductRequestDto, product);


			productRepository.save(product);
			
			genericResponseDto.setResponseCode("200");
			genericResponseDto.setStatus("Success");
			genericResponseDto.setErrorCode(null);
			genericResponseDto.setErrorMessage(null);
			
			future.complete(genericResponseDto);
			return future;
			
		}catch(Exception ex) {
			System.out.println("Exception occured in modifyProduct::"+ex);

			future.complete(genericResponseDto);
			return future;
		}
	}

public CompletableFuture<GenericResponseDto> deleteProduct(DeleteProductRequestDto deleteProductRequestDto){
	
	
	GenericResponseDto genericResponseDto = new GenericResponseDto();
	genericResponseDto.setResponseCode("400");
	genericResponseDto.setStatus("Failure");
	genericResponseDto.setErrorCode("DELETE_PRODUCT");
	genericResponseDto.setErrorMessage("unable to process your request");
	
	CompletableFuture<GenericResponseDto> future = new CompletableFuture<GenericResponseDto>();
	
	try {
		
		Product product = productRepository.findById(deleteProductRequestDto.getProductId());
		

		product.setStatus(EkartConstants.DELETED);
		productRepository.save(product);
		
		genericResponseDto.setResponseCode("200");
		genericResponseDto.setStatus("Success");
		genericResponseDto.setErrorCode(null);
		genericResponseDto.setErrorMessage(null);
		
		future.complete(genericResponseDto);
		return future;
		
	}catch(Exception ex) {
		System.out.println("Exception occured in deleteProduct::"+ex);

		future.complete(genericResponseDto);
		return future;
	}
}

public CompletableFuture<GenericResponseDto> getAllProduct(){
	
	
	GenericResponseDto genericResponseDto = new GenericResponseDto();
	genericResponseDto.setResponseCode("400");
	genericResponseDto.setStatus("Failure");
	genericResponseDto.setErrorCode("ALL_PRODUCT");
	genericResponseDto.setErrorMessage("unable to process your request");
	
	CompletableFuture<GenericResponseDto> future = new CompletableFuture<GenericResponseDto>();
	
	try {
		
		List<Product> productList = productRepository.getAllActiveProduct();
		

		
		genericResponseDto.setResponseCode("200");
		genericResponseDto.setStatus("Success");
		genericResponseDto.setErrorCode(null);
		genericResponseDto.setErrorMessage(null);
		genericResponseDto.setResponseObj(productList);
		
		future.complete(genericResponseDto);
		return future;
		
	}catch(Exception ex) {
		System.out.println("Exception occured in getAllProduct::"+ex);
		
		future.complete(genericResponseDto);
		return future;
	}
}

}
