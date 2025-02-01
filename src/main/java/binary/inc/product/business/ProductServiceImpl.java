package binary.inc.product.business;

import binary.inc.product.port.in.ProductService;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Set<Product> findAll() {
        return Collections.singleton(new Product("macbook", "1000"));
    }

    @Override
    public String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
}
