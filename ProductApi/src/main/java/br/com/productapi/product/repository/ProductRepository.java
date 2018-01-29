package br.com.productapi.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.productapi.product.model.ProductModel;

public interface ProductRepository  extends JpaRepository<ProductModel, Long>{

}
