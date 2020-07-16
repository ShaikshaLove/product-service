package io.s3soft.productservice.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.s3soft.productservice.dto.ProductDTO;
import io.s3soft.productservice.exception.ProductNotFoundException;
import io.s3soft.productservice.model.Product;
import io.s3soft.productservice.repository.ProductRepository;
import io.s3soft.productservice.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
   
	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(ProductDTO productDTO) {
		Product product=new Product(
				productDTO.getProductName(),
				productDTO.getDescription(),
				productDTO.getMrp(),
				productDTO.getPrice(),
				productDTO.getAvialableQuantity(),
				productDTO.getCategory(),
				productDTO.getManufactureDate(),
				productDTO.getSoldUnits()
				);
		product.setCreatedDate(new Date());		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> productsByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public void deleteProductById(String productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("No product is found with id::"+productId));
	}

	@Override
	public Product updateProduct(ProductDTO productDto,String productId) {
		Product product=null;
		try {
			product=getProductById(productId);
		} catch (ProductNotFoundException e) {
			throw new ProductNotFoundException("Update operation cannot be done as no product is exist:"+productId);
		}
		product.setProductName(productDto.getProductName());
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setAvialableQuantity(productDto.getAvialableQuantity());
		product.setManufactureDate(productDto.getManufactureDate());
		product.setMrp(productDto.getMrp());
		product.setPrice(productDto.getPrice());
		product.setSoldUnits(productDto.getSoldUnits());
		return productRepository.save(product);
	}

}
