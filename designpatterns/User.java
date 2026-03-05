package designpatterns;

public class User {

    // Step 1: Private fields
    private String name;
    private int age;
    private String email;

    // Step 2: Private constructor
    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    // Step 3: Static Inner Builder Class
    public static class Builder {

        private String name;
        private int age;
        private String email;

        // Step 4: Setter-like methods returning Builder
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        // Step 5: build() method
        public User build() {
            return new User(this);
        }
    }
}
