package designpatterns;

public class BuilderPatternMain {
    public static void main(String[] args) {

        // Step 6: Create User using Builder
        User user = new User.Builder()
                .setName("Brahmika")
                .setAge(21)
                .setEmail("brahmika@email.com")
                .build();

        user.display();
    }
}