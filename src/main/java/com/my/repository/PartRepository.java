package com.my.repository;

import com.my.entity.Part;
import com.my.entity.PartId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartRepository extends CrudRepository<Part, PartId> {
    List<Part> findByDescription(String description);
}
