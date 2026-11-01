package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@RestController
public class ProductController {
    // Spring creates the ProductService and hands it over.
    @Autowired
    private ProductService productService;//ProductController needs to access to the product operations
    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){//@PathVariable Long id reads the ID from that path.
        return productService.getProductById(id).orElse(null);//getProductById(id)-asks the service to find the product.
        //return the product if found, or null if not found.

    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody DigitalProduct product){//@RequestBody is what tells Spring to build a Product from the JSON you send.
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }// Product is abstract, so Jackson cannot instantiate it directly.


    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

    @GetMapping("/products/summaries")
    public List<String> getSummaries(){
        return productService.getAllSummaries();
    }



}

