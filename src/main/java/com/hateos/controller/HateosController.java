package com.hateos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hateos.binding.Book;

@RestController
public class HateosController {

	@GetMapping(value = "/book/{id}", produces = { "application/json" }, consumes = { "application/json" })
	public Book getBookById(@PathVariable int id) {

		Book b = new Book(123, "Java", "1200", "Sun");

//		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HateosController.class).getAllBook()).withSelfRel();
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HateosController.class)
				.getAllBook())
				.withRel("All Book");

		b.add(link);

		return b;
	}

	@GetMapping(value = "/books")
	public List<Book> getAllBook() {
		Book b1 = new Book(133, "Spring", "4200", "Robot");
		Book b2 = new Book(153, "Java Advance", "12000", "Sun Micra");
		Book b3 = new Book(156, "Python", "1200", "Xyz");

		List<Book> l = new ArrayList<>();
		l.add(b3);
		l.add(b2);
		l.add(b1);

		return l;
	}

}
