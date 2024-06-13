package ru.test.site.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.test.site.model.SortResult;
import ru.test.site.model.SortedElement;

import java.util.List;

@Repository
public interface SortedElementRepository extends CrudRepository<SortedElement, Long> {
    List<SortedElement> findSortedElementsBySortResultId(SortResult sortResult);
}
