package cat.udl.eps.softarch.repository;

import cat.udl.eps.softarch.domain.SellerCounterOffer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by http://rhizomik.net/~roberto/
 */
@RepositoryRestResource
public interface SellerCounterOfferRepository extends PagingAndSortingRepository<SellerCounterOffer, Long> {
}
