package recruit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recruit.entity.Budget;
import recruit.entity.Department;

import java.util.List;

@Repository
public interface BudgetRepo extends JpaRepository<Budget, Long> {

    @Query("SELECT b from Budget b join fetch b.department d where d = ?1 and" +
            " b.year = ?2 and b.quarter = ?3")
    List<Budget> findByDepartmentAndYearAndQuarter(Department department, Integer year, Integer quarter);

}
