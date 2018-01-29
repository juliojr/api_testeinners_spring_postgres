package br.com.productapi.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productapi.product.model.ProductModel;
import br.com.productapi.product.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public List<ProductModel> getAllProducts(){
		return productRepository.findAll();
	}
	@PostMapping
	public ProductModel createProduct(@Valid @RequestBody ProductModel product) {
		 return productRepository.save(product);
	}

}
