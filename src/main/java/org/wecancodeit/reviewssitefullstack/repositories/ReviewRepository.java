package org.wecancodeit.reviewssitefullstack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssitefullstack.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
