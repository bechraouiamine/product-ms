package edu.bechraoui.product.services;

import edu.bechraoui.product.model.Product;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by aminebechraoui, on 24/02/2023, in edu.bechraoui.product.services
 */
public interface ProductService {

    Set<Product> findAll();

    String getHostName() throws SocketException, UnknownHostException;
}
