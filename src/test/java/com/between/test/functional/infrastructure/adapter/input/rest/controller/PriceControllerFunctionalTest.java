package com.between.test.functional.infrastructure.adapter.input.rest.controller;

import com.between.test.PricesApplication;
import com.between.test.infrastructure.adapter.input.rest.dto.model.response.PriceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PricesApplication.class)
class PriceControllerFunctionalTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;


	//1. Prueba 1: Realizar una petición a las 10:00 del día 14 para el producto 35455 y la marca 1 (ZARA).
	@Test
	void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith14T10_Invoked() throws Exception {

		ResultActions res = mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&consultatioDate=2020-06-14T10:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(1,priceDto.getPriceList());
		Assertions.assertEquals(35.50,priceDto.getPrice());

	}
	
	//2. Prueba 2: Realizar una petición a las 16:00 del día 14 para el producto 35455 y la marca 1 (ZARA).
	@Test
	void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith14T16_Invoked() throws Exception {

		ResultActions res =    mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&consultatioDate=2020-06-14T16:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(2,priceDto.getPriceList());
		Assertions.assertEquals(25.45,priceDto.getPrice());

	}


	//Prueba 3: Realizar una petición a las 21:00 del día 14 para el producto 35455 y la marca 1 (ZARA).
	@Test
	void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith14T21_Invoked() throws Exception {

		ResultActions res =    mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&consultatioDate=2020-06-14T21:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(1,priceDto.getPriceList());
		Assertions.assertEquals(35.50,priceDto.getPrice());

	}

	//Prueba 4: Realizar una petición a las 10:00 del día 15 para el producto 35455 y la marca 1 (ZARA).
	@Test
	void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith15T10_Invoked() throws Exception {

		ResultActions res = mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&consultatioDate=2020-06-15T10:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(3,priceDto.getPriceList());
		Assertions.assertEquals(30.50,priceDto.getPrice());
	}

	//Prueba 5: Realizar una petición a las 21:00 del día 16 para el producto 35455 y la marca 1 (ZARA).
	@Test
	void test_FinrCurrentPrice_Should_ShowPrice_When_CallWith16T21_Invoked() throws Exception {

		ResultActions res =    mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&consultatioDate=2020-06-16T21:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);

		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PriceDto priceDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PriceDto.class);
		Assertions.assertEquals(4,priceDto.getPriceList());
		Assertions.assertEquals(38.95,priceDto.getPrice());
	}

	@Test
	void test_FinrCurrentPrice_Should_Return404_When_Invoked() throws Exception {

		mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455&brandId=1&consultatioDate=2020-06-13T10:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isNotFound()

				);
	}

	@Test
	void test_FinrCurrentPrice_Should_Return400_When_Invoked() throws Exception {

		mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=-35455&brandId=1&consultatioDate=2020-06-13T10:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isBadRequest()

				);
	}



	@Test
	void test_FinrCurrentPrice_Should_Return500_When_Invoked() throws Exception {

		mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/price/current?productId=35455777777777777777777777&brandId=1&consultatioDate=2020-06-13T10:00:00")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isInternalServerError()

				);
	}


}


