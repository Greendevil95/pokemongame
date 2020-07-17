package pokemonGame.Repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import pokemonGame.Entity.AbstractEntity;

@NoRepositoryBean
public interface CommonRepository<E extends AbstractEntity> extends PagingAndSortingRepository<E, Long>, JpaSpecificationExecutor<E> {
}
