 
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
 
 
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	public Optional<Login> findByName(String name);
}
