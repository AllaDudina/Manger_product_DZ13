import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product book1 = new Book(1,"Война и мир", 100, "Л.Н. Толстой");
    Product book2 = new Book(2, "Преступление и наказание", 50, "Ф.М. Достоевский");
    Product smartphone1 = new Smartphone(3, "Galaxy S2", 20_000, "Samsung");
    Product smartphone2 = new Smartphone(4, "Iphone 5S", 1_000, "Apple");

    @Test
    public void findAllProducts(){
        ProductRepository repository = new ProductRepository();
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(smartphone1);
        repository.saveProduct(smartphone2);

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeProduct(){
        ProductRepository repository = new ProductRepository();
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(smartphone1);
        repository.removeById(smartphone1.getId());

        Product [] expected = {book1,book2};
        Product [] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
