package io.s3soft.productservice.service;

import java.util.List;

import io.s3soft.productservice.dto.ProductDTO;
import io.s3soft.productservice.model.Product;

public interface IProductService {
   Product saveProduct(ProductDTO productDTO);
   List<Product> getAllProducts();
   List<Product> productsByCategory(String category);
   void deleteProductById(String productId);
   Product getProductById(String productId);
   Product updateProduct(ProductDTO productDto,String productId);
}
