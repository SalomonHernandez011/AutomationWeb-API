package Util;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DogBreedListGenerator extends Faker {
    private static final List<String> DOG_BREEDS = DogBreeds.LIST;
    public DogBreedListGenerator() {
    }

    public DogBreedListGenerator(ThreadLocalRandom random) {
        super(random);
    }

    public String dogBreed() {
        return DOG_BREEDS.get(random().nextInt(DOG_BREEDS.size()));
    }
}