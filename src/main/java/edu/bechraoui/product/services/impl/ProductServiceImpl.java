package edu.bechraoui.product.services.impl;

import edu.bechraoui.product.model.Product;
import edu.bechraoui.product.services.ProductService;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Set;

/**
 * Created by aminebechraoui, on 24/02/2023, in edu.bechraoui.product.services.impl
 */
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
