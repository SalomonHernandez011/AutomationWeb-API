package Util;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CatBreedGenerator extends Faker {
    private static final List<String> CAT_BREEDS = CatBreeds.LIST;
    public CatBreedGenerator() {
    }

    public CatBreedGenerator(ThreadLocalRandom random) {
        super(random);
    }

    public String catBreed() {
        return CAT_BREEDS.get(random().nextInt(CAT_BREEDS.size()));
    }

}
