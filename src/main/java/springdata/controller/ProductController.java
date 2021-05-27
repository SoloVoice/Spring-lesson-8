package springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.model.Product;
import springdata.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productService.getProductById(id).get();
    }

    @GetMapping("/del")
    public List<Product> deleteProduct(@RequestParam(name = "id") Long id) {
        productService.deleteProductById(id);
        return getAllProducts();
    }

    @PostMapping
    public List<Product> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return getAllProducts();
    }
}
