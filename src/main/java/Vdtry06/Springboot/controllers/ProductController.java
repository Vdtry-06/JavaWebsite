package Vdtry06.Springboot.controllers;

import Vdtry06.Springboot.models.Product;
import Vdtry06.Springboot.models.ResponseObject;
import Vdtry06.Springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional; // co the null

@RestController // lam viec voi restAPI
@RequestMapping(path = "/api/v1/Products") // anh xa cac request: duong link gui request den controller
public class ProductController {
    // DI = Dependency Injection
    @Autowired // doi tuong repository se duoc tao ra ngay sau khi app duoc tao
    private ProductRepository repository;
    @GetMapping("")
    // this request is: http://localhost:8080/api/v1/Products
    List<Product> getAllProducts() {
        return repository.findAll(); // where is data ?
        // You must save this to Database, Now we have H2 DB = In-memory Database
        // you can also send request using Postman
    };
    // Get detail product
    @GetMapping("/{id}")
    // http://localhost:8080/api/v1/Products/5 <- : PathVariable
    // Let's return an object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable long id) {
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ?
            ResponseEntity.status(HttpStatus.OK).body (
                    new ResponseObject("Ok", "Query product successfully", foundProduct)
                    // you can replace "ok" with your defined "error code"
            ):
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find product with id = " + id, "")
            );
    }
    // insert new product with POST method
    // Postman: Raw, JSON
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        // 2 products must not have the same name !
        List<Product> foundProducts = repository.findByProductName(newProduct.getProductName().trim());
        if(!foundProducts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Product name already taken","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Insert Product successfully", repository.save(newProduct))
        );
    }
    // update, upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updatedProduct = repository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setYear(newProduct.getYear());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Update Product successfully", updatedProduct)
        );
    }
    // Delete a Product => DELETE method
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product to delete", "")
        );
    }
}
