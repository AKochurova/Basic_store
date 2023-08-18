package com.basic_store.repos;

import com.basic_store.models.OrderedItem;
import com.basic_store.models.SellProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<SellProduct, Long> {
    List<SellProduct> findByType(String type);
}
