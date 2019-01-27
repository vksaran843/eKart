package com.xyz.ekart.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.xyz.ekart.dto.AllOrderListRequestDto;
import com.xyz.ekart.dto.GenericResponseDto;
import com.xyz.ekart.dto.PlaceOrderRequestDto;
import com.xyz.ekart.service.OrderService;

import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class OrderController extends Controller{

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Inject
	private OrderService orderService;

	@Transactional
	public CompletionStage<Result> placeOrder(){
		try {
			JsonNode request = request().body().asJson();

			PlaceOrderRequestDto placeOrderRequestDto = Json.fromJson(request, PlaceOrderRequestDto.class);

			return orderService.placeOrder(placeOrderRequestDto).thenApplyAsync(responseObj ->{
				return Results.ok(Json.toJson(responseObj));
			});

		}catch(Exception ex) {
			System.out.println("Exception occured in placeOrder::"+ex);

			GenericResponseDto genericResponseDto = new GenericResponseDto();
			genericResponseDto.setResponseCode("400");
			genericResponseDto.setStatus("Failure");
			genericResponseDto.setErrorCode("PLACE_ORDER");
			genericResponseDto.setErrorMessage("unable to process your request");

			return CompletableFuture.completedFuture(Results.ok(Json.toJson(genericResponseDto)));

		}
	}

	@Transactional
	public CompletionStage<Result> allOrderList(){
		try {
			JsonNode request = request().body().asJson();

			AllOrderListRequestDto allOrderListRequestDto = Json.fromJson(request, AllOrderListRequestDto.class);

			return orderService.allOrderList(allOrderListRequestDto).thenApplyAsync(responseObj ->{
				return Results.ok(Json.toJson(responseObj));
			});

		}catch(Exception ex) {

			System.out.println("Exception occured in allOrderList::"+ex);

			GenericResponseDto genericResponseDto = new GenericResponseDto();
			genericResponseDto.setResponseCode("400");
			genericResponseDto.setStatus("Failure");
			genericResponseDto.setErrorCode("ALL_ORDER_LIST");
			genericResponseDto.setErrorMessage("unable to process your request");

			return CompletableFuture.completedFuture(Results.ok(Json.toJson(genericResponseDto)));

		}
	}
}
