package beans;

import javax.validation.constraints.*;

public class User {

    /*
     * @NotNull validates that the annotated property value is not null.
     */
    @NotNull(message = "Name cannot be null")
    private String name;

    /*
     * @AssertTrue validates that the annotated property value is true.
     */
    @AssertTrue
    private boolean working;

    /*
     * @Size validates that the annotated property value has a size between
     * the attributes min and max; can be applied to String, Collection, Map, and array properties.
     */
    @Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    /*
     * @Min validates that the annotated property has a value no smaller than the value attribute.
     * @Max validates that the annotated property has a value no larger than the value attribute.
     */
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    /*
     * @Email validates that the annotated property is a valid email address.
     */
    @Email(message = "Email should be valid")
    private String email;


    /*
     * @NotEmpty validates that the property is not null or empty; can be applied to String, Collection, Map or Array
     * values.
     * @NotBlank can be applied only to text values and validates that the property is not null or whitespace.
     * @Positive and @PositiveOrZero apply to numeric values and validate that they are strictly positive, or positive
     * including 0.
     * @Negative and @NegativeOrZero apply to numeric values and validate that they are strictly negative, or negative
     * including 0.
     * @Past and @PastOrPresent validate that a date value is in the past or the past including the present; can be
     * applied to date types including those added in Java 8.
     * @Future and @FutureOrPresent validate that a date value is in the future, or in the future including the present.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
