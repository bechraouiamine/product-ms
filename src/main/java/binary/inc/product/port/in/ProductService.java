package binary.inc.product.port.in;

import binary.inc.product.business.Product;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Set;

public interface ProductService {

    Set<Product> findAll();

    String getHostName() throws SocketException, UnknownHostException;
}
