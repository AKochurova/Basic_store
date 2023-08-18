package com.basic_store.repos;

import com.basic_store.models.OrderedItem;
import com.basic_store.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends CrudRepository<OrderedItem, Long> {

    List<OrderedItem> findByType(String type);
    List<OrderedItem> findByBuyer(User buyer);
    void deleteById(Long id);

}
