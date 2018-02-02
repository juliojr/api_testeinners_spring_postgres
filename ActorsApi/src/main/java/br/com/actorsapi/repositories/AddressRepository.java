package br.com.actorsapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.actorsapi.models.AddressModel;

public interface AddressRepository  extends JpaRepository<AddressModel, Long>{
	
	@Query("select a "
			
			+ " from AddressModel a "
			+ " inner join  a.city c "
			+ " inner join c.state s "
			+ " inner join a.district d "
			+ " inner join a.actor ac "
			+ "where ac.id = ?1")
	List<AddressModel> findByActorId(long id);
}
