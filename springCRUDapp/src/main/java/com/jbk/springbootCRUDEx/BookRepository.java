package com.jbk.springbootCRUDEx;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Spring boot identify the class as a repository
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}

