package io.s3soft.productservice.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.s3soft.productservice.dto.ProductDTO;
import io.s3soft.productservice.dto.SuccessResponse;
import io.s3soft.productservice.model.Product;
import io.s3soft.productservice.service.IProductService;

@RestController
@RequestMapping("/v1/products")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,
        RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class ProductRestController{
	
	@Autowired
	private IProductService productService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> saveProduct(@RequestBody ProductDTO productDTO) {
		Product product=productService.saveProduct(productDTO);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse("Product registration is successful with "+product.getId(),HttpStatus.CREATED.value()),HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<SuccessResponse> updateProduct(@RequestBody ProductDTO productDto,@PathVariable String productId) {
        productService.updateProduct(productDto, productId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse("The product info has been Updated:: "+productId,HttpStatus.OK.value()),HttpStatus.OK);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> getAllProducts(){
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(productService.getAllProducts(),HttpStatus.OK.value()),HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<SuccessResponse> deleteProduct(@PathVariable("productId") String productId) {
	     productService.deleteProductById(productId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse("The product  has been removed:: "+productId,HttpStatus.OK.value()),HttpStatus.OK);
	}
	@GetMapping("/categories/{category}")
	public ResponseEntity<SuccessResponse> productsByCategory(@PathVariable("category")String category) {
	return new ResponseEntity<SuccessResponse>(new SuccessResponse(productService.productsByCategory(category),HttpStatus.OK.value()),HttpStatus.OK);
	}
	
	
	  @GetMapping("/{productId}")
	  public ResponseEntity<SuccessResponse> getProductById(@PathVariable("productId") String productId) { 
		  return new ResponseEntity<SuccessResponse>(new SuccessResponse(productService.getProductById(productId),HttpStatus.OK.value()),HttpStatus.OK); 
	  }
	 
}
