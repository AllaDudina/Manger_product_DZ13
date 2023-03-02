public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repo) {
        this.repository = repo;
    }

    public void add(Product product) {
        repository.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] products = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    products[i] = result[i];
                }
                products[result.length] = product;
                result = products;
            }
        }

        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
