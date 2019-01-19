package com.dcmfc.microservice.restexample.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class BeanFilterResource {
	
	@GetMapping("/filter")
	public BeanFilter getBeanFilter()
	{
		return new BeanFilter("valor1", "valor2", "valor3");
	}
	
	@GetMapping("/filter-dinamico")
	public MappingJacksonValue getBeanFilterDinamico()
	{
		BeanFilter bean = new BeanFilter("valor1", "valor2", "valor3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		FilterProvider fp = new SimpleFilterProvider().addFilter("teste-filter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(fp);
		
		return mapping;
	}

}
