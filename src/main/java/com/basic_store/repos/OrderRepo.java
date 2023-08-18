package com.basic_store.repos;


import com.basic_store.models.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<UserOrder, Long> {
}
