package com.xyz.ekart.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyz.ekart.constant.EkartConstants;
import com.xyz.ekart.controllers.ProductController;
import com.xyz.ekart.dto.AllOrderListRequestDto;
import com.xyz.ekart.dto.AllOrderListResponseDto;
import com.xyz.ekart.dto.GenericResponseDto;
import com.xyz.ekart.dto.OrderDto;
import com.xyz.ekart.dto.PlaceOrderRequestDto;
import com.xyz.ekart.dto.ProductDto;
import com.xyz.ekart.model.Customer;
import com.xyz.ekart.model.Order;
import com.xyz.ekart.model.OrderProductMap;
import com.xyz.ekart.model.Product;
import com.xyz.ekart.repository.CustomerRepository;
import com.xyz.ekart.repository.OrderProductMapRepository;
import com.xyz.ekart.repository.OrderRepository;
import com.xyz.ekart.repository.ProductRepository;

public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	private CustomerRepository customerRepository;

	@Inject
	private OrderRepository orderRepository;

	@Inject
	private ProductRepository  productRepository;

	@Inject
	private OrderProductMapRepository orderProductMapRepository;

	public CompletableFuture<GenericResponseDto> placeOrder(PlaceOrderRequestDto placeOrderRequestDto){


		GenericResponseDto genericResponseDto = new GenericResponseDto();
		genericResponseDto.setResponseCode("400");
		genericResponseDto.setStatus("Failure");
		genericResponseDto.setErrorCode("ADD_PRODUCT");
		genericResponseDto.setErrorMessage("unable to process your request");

		CompletableFuture<GenericResponseDto> future = new CompletableFuture<GenericResponseDto>();

		try {

			/**
			 * customer validation
			 */

			Customer customer = customerRepository.findById(placeOrderRequestDto.getCustomerId());

			if(customer==null) {
				genericResponseDto.setResponseCode("400");
				genericResponseDto.setStatus("Failure");
				genericResponseDto.setErrorCode("CUSTOMER_NOT_FOUND");
				genericResponseDto.setErrorMessage("unable to process your request");

				future.complete(genericResponseDto);
				return future;
			}

			Order order = new Order();

			order.setCustomerId(customer);
			order.setOrderAmount(placeOrderRequestDto.getOrderAmount());
			order.setOrderCreatedDate(LocalDateTime.now());
			order.setOrderStatus(EkartConstants.INITIATED);
			order.setPaymentMode(placeOrderRequestDto.getPaymentMode());
			order.setPaymentStatus(placeOrderRequestDto.getPaymentStatus());

			orderRepository.save(order);

			for(ProductDto productDto : placeOrderRequestDto.getProductList()) {

				Product product =productRepository.findById(productDto.getProductId());
				if(product==null) {
					genericResponseDto.setResponseCode("400");
					genericResponseDto.setStatus("Failure");
					genericResponseDto.setErrorCode("PRODUCT_NOT_FOUND");
					genericResponseDto.setErrorMessage("unable to process your request");

					future.complete(genericResponseDto);
					return future;
				}

				if(product.getProductQuantity()<productDto.getProductQuantity()) {
					genericResponseDto.setResponseCode("400");
					genericResponseDto.setStatus("Failure");
					genericResponseDto.setErrorCode("PRODUCT_OUT_OF_STOCK");
					genericResponseDto.setErrorMessage("unable to process your request");

					future.complete(genericResponseDto);
					return future;
				}

				OrderProductMap orderProductMap = new OrderProductMap();
				orderProductMap.setOrderId(order);
				orderProductMap.setProductId(product);
				orderProductMap.setProductQuantity(productDto.getProductQuantity());
				orderProductMap.setTotalAmount(productDto.getTotalPrice());

				orderProductMapRepository.save(orderProductMap);
			}

			order.setOrderStatus(EkartConstants.PLACED);

			orderRepository.save(order);

			genericResponseDto.setResponseCode("200");
			genericResponseDto.setStatus("Success");
			genericResponseDto.setErrorCode(null);
			genericResponseDto.setErrorMessage(null);

			future.complete(genericResponseDto);
			return future;

		}catch(Exception ex) {
			System.out.println("Exception occured in placeOrder::"+ex);

			future.complete(genericResponseDto);
			return future;
		}
	}

	public CompletableFuture<GenericResponseDto> allOrderList(AllOrderListRequestDto allOrderListRequestDto){


		GenericResponseDto genericResponseDto = new GenericResponseDto();
		genericResponseDto.setResponseCode("400");
		genericResponseDto.setStatus("Failure");
		genericResponseDto.setErrorCode("ALL_ORDER_LIST");
		genericResponseDto.setErrorMessage("unable to process your request");

		AllOrderListResponseDto responseDto = new AllOrderListResponseDto();

		CompletableFuture<GenericResponseDto> future = new CompletableFuture<GenericResponseDto>();

		try {

			/**
			 * customer validation
			 */

			Customer customer = customerRepository.findById(allOrderListRequestDto.getCustomerId());

			if(customer==null) {
				genericResponseDto.setResponseCode("400");
				genericResponseDto.setStatus("Failure");
				genericResponseDto.setErrorCode("CUSTOMER_NOT_FOUND");
				genericResponseDto.setErrorMessage("unable to process your request");

				future.complete(genericResponseDto);
				return future;
			}

			/**
			 *  get all order list for customer
			 */

			List<Order> orderList = orderRepository.getAllOrderList(allOrderListRequestDto.getCustomerId());

			List<OrderDto> orderDtoList = new ArrayList<OrderDto>();

			for(Order order :orderList) {

				OrderDto orderDto = new OrderDto();
				orderDto.setOrderAmount(order.getOrderAmount());
				orderDto.setOrderId(order.getOrderId());
				orderDto.setOrderPlacedDate(order.getOrderCreatedDate());
				orderDto.setOrderStatus(order.getOrderStatus());

				/**
				 *  get all product List for order
				 */

				List<OrderProductMap> orderProductMapList = orderProductMapRepository.productListByOrderId(order);

				List<ProductDto> productDtoList = new ArrayList<ProductDto>();

				for(OrderProductMap orderProductMap : orderProductMapList) {

					ProductDto productDto = new ProductDto();
					productDto.setProductId(orderProductMap.getProductId().getProductId());
					productDto.setProductQuantity(orderProductMap.getProductQuantity());
					productDto.setTotalPrice(orderProductMap.getTotalAmount());

					productDtoList.add(productDto);
				}

				orderDto.setProductList(productDtoList);

				orderDtoList.add(orderDto);


			}

			responseDto.setCustomerId(allOrderListRequestDto.getCustomerId());
			responseDto.setOrderList(orderDtoList);

			genericResponseDto.setResponseCode("200");
			genericResponseDto.setStatus("Success");
			genericResponseDto.setErrorCode(null);
			genericResponseDto.setErrorMessage(null);
			genericResponseDto.setResponseObj(responseDto);

			future.complete(genericResponseDto);
			return future;

		}catch(Exception ex) {
			System.out.println("Exception occured in allOrderList::"+ex);

			future.complete(genericResponseDto);
			return future;
		}
	}
}
