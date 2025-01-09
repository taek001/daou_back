package recruit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recruit.entity.Disbursement;

@Repository
public interface DisbursementRepo extends JpaRepository<Disbursement, Long> {

}
