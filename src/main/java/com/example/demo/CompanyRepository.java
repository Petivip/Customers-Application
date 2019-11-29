






package com.example.demo;

        import org.springframework.data.repository.CrudRepository;

        import java.util.ArrayList;

public interface CompanyRepository extends CrudRepository<company,Long> {
    ArrayList<company> findByNameContainingIgnoreCase(String entry1);
}
