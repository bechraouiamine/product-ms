package binary.inc.product.business;

import java.util.UUID;

public record Product(UUID id,
        String name,
        String price,ProductCategory productCategory) {

    public Product(String name, String price) {
        this(null, name, price, null);
    }
}
