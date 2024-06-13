package ru.test.site.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.test.site.model.SortResult;

@Repository
public interface SortResultRepository extends CrudRepository<SortResult, Long> {
    SortResult findSortResultById(Long id);
}
