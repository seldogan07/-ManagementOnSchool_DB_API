package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static utils.ManagementOnSchoolsAuth.generateToken;

public class ManagementOnSchoolsBaseUrl {

    public static RequestSpecification spec;

    public static void setSpec(){
        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateToken())
                .setBaseUri("https://managementonschools.com/app").build();
    }

}
