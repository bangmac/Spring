package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;

import java.util.List;

public interface Repository<T> {
    // khai báo 1 repository chứa các phương thức CRUD chung cho tất cả mọi loại kiểu đối tượng dữ liệu <T>
    // với đối tượng dữ liệu là Customer sữ tạo một Interface CustomerRepository extend lại Interface Repository và truyền vào
    // tham số <T> với kiểu dữ liệu là Customer
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
