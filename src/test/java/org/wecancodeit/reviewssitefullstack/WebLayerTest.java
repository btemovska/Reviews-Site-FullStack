package org.wecancodeit.reviewssitefullstack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviewssitefullstack.models.Category;
import org.wecancodeit.reviewssitefullstack.models.Review;
import org.wecancodeit.reviewssitefullstack.repositories.CategoryRepository;
import org.wecancodeit.reviewssitefullstack.repositories.ReviewRepository;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private CategoryRepository categoryRepo;
    @MockBean
    private ReviewRepository reviewRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void t1categoriesShouldBeOkAndReturnCategoriesViewWithCategoriesModelAttribute() throws Exception {
        mockMvc.perform(get("/categories")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("categoriesView")).andExpect(model()
                .attributeExists("categories"));
    }

    @Test
    public void t2booksShouldBeOkAndReturnReviewsViewWithReviewModelAttribute() throws Exception {
        mockMvc.perform(get("/reviews")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("reviewsView")).andExpect(model()
                .attributeExists("reviews"));
    }

    @Test
    public void t3shouldBeOkForASingleCategoryEndpointWithCategoryViewAndCategoryModelAttribute() throws Exception {
        Category testCampus = new Category("Action");
        when(categoryRepo.findCategoryByGenre("Action")).thenReturn(testCampus);
        mockMvc.perform(get("/categories/Action")).andExpect(status().isOk())
                .andExpect(view().name("categoryView"))
                .andExpect(model().attributeExists("category"));
    }

    @Test
    public void t4shouldBeOkForASingleReviewEndpointWithReviewViewAndReviewModelAttribute() throws Exception {
        Category testCategory = new Category("Action");
        Review testReview = new Review("Title", "imageUrl", "content", testCategory);
        when(reviewRepo.findById(1L)).thenReturn(java.util.Optional.of(testReview));
        mockMvc.perform(get("/reviews/1")).andExpect(status().isOk())
                .andExpect(view().name("reviewView"))
                .andExpect(model().attributeExists("review"));
    }
}
