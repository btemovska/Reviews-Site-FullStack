package org.wecancodeit.reviewssitefullstack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviewssitefullstack.models.Category;
import org.wecancodeit.reviewssitefullstack.models.Review;
import org.wecancodeit.reviewssitefullstack.repositories.CategoryRepository;
import org.wecancodeit.reviewssitefullstack.repositories.ReviewRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CategoryRepository categoryRepo;
    @Resource
    private ReviewRepository reviewRepo;

    @Override
    public void run(String... args) throws Exception {
        Category action = new Category("Action");
        Category comedy = new Category("Comedy");
        Category drama = new Category("Drama");
        categoryRepo.save(action);
        categoryRepo.save(comedy);
        categoryRepo.save(drama);

        Review captainAmerica = new Review("Captain America", "../images/captainAmerica.jpg", "It Does Not Like Too Many Words. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.", action);
        Review wonderWoman = new Review("Wonder Woman", "../images/wonderWoman.jpg", "It Does Not Like Too Many Words.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.", action);
        Review johnnyEnglish = new Review("Johnny English", "../images/johnnyEnglish.jpg", "It Does Not Like Too Many Words.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.", comedy);
        Review horribleBosses = new Review("Horrible Bosses", "../images/horribleBosses.jpg", "It Does Not Like Too Many Words.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.", comedy);
        Review theGodfather = new Review("The God Father", "../images/theGodfather.jpg", "It Does Not Like Too Many Words.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or.", drama);
        Review spotlight = new Review("Spotlight", "../images/spotlight.jpg", "It Does Not Like Too Many Words.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or.", drama);
        reviewRepo.save(captainAmerica);
        reviewRepo.save(wonderWoman);
        reviewRepo.save(johnnyEnglish);
        reviewRepo.save(horribleBosses);
        reviewRepo.save(theGodfather);
        reviewRepo.save(spotlight);
    }
}
