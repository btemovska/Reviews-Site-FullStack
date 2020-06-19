package org.wecancodeit.reviewssitefullstack;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.reviewssitefullstack.models.Category;
import org.wecancodeit.reviewssitefullstack.models.Review;
import org.wecancodeit.reviewssitefullstack.repositories.CategoryRepository;
import org.wecancodeit.reviewssitefullstack.repositories.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ReviewRepository reviewRepo;

    @Test
    public void t1categoryShouldHaveAListOfReviews() {
        Category testCategory = new Category("Test Genre");
        Category testCategory2 = new Category("Test Genre2");
        Review testReview = new Review("Title", "Image", "Content", testCategory);
        Review testReview2 = new Review("Title", "Image", "Content", testCategory2);

        categoryRepo.save(testCategory);
        categoryRepo.save(testCategory2);
        reviewRepo.save(testReview);
        reviewRepo.save(testReview2);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
//        Review retrievedReview = reviewRepo.findById(testReview.getId()).get();
        assertThat(retrievedCategory.getReviews()).contains(testReview);
    }

}
