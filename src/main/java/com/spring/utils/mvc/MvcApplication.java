package com.spring.utils.mvc;

import com.spring.utils.mvc.validation.item.Item;
import com.spring.utils.mvc.validation.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MvcApplication {

	@Autowired
	ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}


	@PostConstruct
	public void init() {
		itemRepository.save(new Item("itemA", 10000, 10));

		itemRepository.save(new Item("itemB", 20000, 20));
	}
}
