package com.xyz.ekart.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.xyz.ekart.dto.AddProductRequestDto;
import com.xyz.ekart.dto.DeleteProductRequestDto;
import com.xyz.ekart.dto.GenericResponseDto;
import com.xyz.ekart.dto.ModifyProductRequestDto;
import com.xyz.ekart.service.ProductService;

import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class ProductController extends Controller{

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Inject
	private ProductService productService;
	
	@Transactional
	public CompletionStage<Result> addProduct(){
		try {
			JsonNode request = request().body().asJson();
			
			AddProductRequestDto addProductRequestDto = Json.fromJson(request, AddProductRequestDto.class);
			
			return productService.addProduct(addProductRequestDto).thenApplyAsync(responseObj ->{
				return Results.ok(Json.toJson(responseObj));
			});
			
		}catch(Exception ex) {
			System.out.println("Exception occured in addProduct::"+ex);
			
			GenericResponseDto genericResponseDto = new GenericResponseDto();
			genericResponseDto.setResponseCode("400");
			genericResponseDto.setStatus("Failure");
			genericResponseDto.setErrorCode("ADD_PRODUCT");
			genericResponseDto.setErrorMessage("unable to process your request");
			
			return CompletableFuture.completedFuture(Results.ok(Json.toJson(genericResponseDto)));

		}
	}
	
	@Transactional
	public CompletionStage<Result> modifyProduct(){
		try {
			JsonNode request = request().body().asJson();
			
			ModifyProductRequestDto modifyProductRequestDto = Json.fromJson(request, ModifyProductRequestDto.class);
			
			return productService.modifyProduct(modifyProductRequestDto).thenApplyAsync(responseObj ->{
				return Results.ok(Json.toJson(responseObj));
			});
			
		}catch(Exception ex) {
			System.out.println("Exception occured in modifyProduct::"+ex);

			GenericResponseDto genericResponseDto = new GenericResponseDto();
			genericResponseDto.setResponseCode("400");
			genericResponseDto.setStatus("Failure");
			genericResponseDto.setErrorCode("MODIFY_PRODUCT");
			genericResponseDto.setErrorMessage("unable to process your request");
			
			return CompletableFuture.completedFuture(Results.ok(Json.toJson(genericResponseDto)));

		}
	}
	
	@Transactional
	public CompletionStage<Result> deleteProduct(){
		try {
			JsonNode request = request().body().asJson();
			
			DeleteProductRequestDto deleteProductRequestDto = Json.fromJson(request, DeleteProductRequestDto.class);
			
			return productService.deleteProduct(deleteProductRequestDto).thenApplyAsync(responseObj ->{
				return Results.ok(Json.toJson(responseObj));
			});
			
		}catch(Exception ex) {
			System.out.println("Exception occured in deleteProduct::"+ex);

			GenericResponseDto genericResponseDto = new GenericResponseDto();
			genericResponseDto.setResponseObj("400");
			genericResponseDto.setStatus("Failure");
			genericResponseDto.setErrorCode("DELETE_PRODUCT");
			genericResponseDto.setErrorMessage("unable to process your request");
			
			return CompletableFuture.completedFuture(Results.ok(Json.toJson(genericResponseDto)));

		}
	}
	
	@Transactional
	public CompletionStage<Result> getAllProduct(){
		try {
			
			
			return productService.getAllProduct().thenApplyAsync(responseObj ->{
				return Results.ok(Json.toJson(responseObj));
			});
			
		}catch(Exception ex) {
			System.out.println("Exception occured in getAllProduct::"+ex);

			GenericResponseDto genericResponseDto = new GenericResponseDto();
			genericResponseDto.setResponseObj("400");
			genericResponseDto.setStatus("Failure");
			genericResponseDto.setErrorCode("ALL_PRODUCT");
			genericResponseDto.setErrorMessage("unable to process your request");
			
			return CompletableFuture.completedFuture(Results.ok(Json.toJson(genericResponseDto)));

		}
	}
}
