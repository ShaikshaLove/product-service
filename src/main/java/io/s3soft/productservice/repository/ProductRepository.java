package io.s3soft.productservice.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.s3soft.productservice.model.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product>  findByCategory(String category);
}
