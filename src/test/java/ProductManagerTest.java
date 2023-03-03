import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1, "Война и мир", 100, "Л.Н. Толстой");
    Product book2 = new Book(2, "Преступление и наказание", 50, "Ф.М. Достоевский");
    Product smartphone1 = new Smartphone(3, "Galaxy S2", 20_000, "Samsung");
    Product smartphone2 = new Smartphone(4, "Iphone 5S", 1_000, "Apple");

    @Test
    public void shouldAddProduct() {

        manager.add(smartphone2);
        manager.add(book2);
        manager.add(smartphone1);

        Product[] expected = {smartphone2, book2, smartphone1};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchingProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] result = manager.searchBy("на");

        Product[] expected = {book1, book2};
        Product[] actual = result;

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindIfMatchingAllProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] result = manager.searchBy("");

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = result;

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindIfMatchingOneProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] result = manager.searchBy("мир");

        Product[] expected = {book1};
        Product[] actual = result;

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindIfMatchingNullProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] result = manager.searchBy("Каренина");

        Product[] expected = {};
        Product[] actual = result;

        Assertions.assertArrayEquals(expected, actual);

    }
}
