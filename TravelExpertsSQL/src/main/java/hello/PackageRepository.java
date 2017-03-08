package hello;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PackageRepository extends CrudRepository<Package,Long> {

	
	@Transactional
	@Query("select p from Package p where p.packageid = ?1")
	Package GrabPackage(Integer packageid);

}
