package org.wecancodeit.reviewssitefullstack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssitefullstack.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryByGenre(String genre);
}
