






package com.example.demo;

        import org.springframework.data.repository.CrudRepository;

        import java.util.ArrayList;

public interface CompanyRepository extends CrudRepository<company,Long> {
    company findById(long id);
    ArrayList<company> findByNameContainingIgnoreCase(String entry1);
}
