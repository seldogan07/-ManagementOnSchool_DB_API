package stepdefinitions.database_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.*;
import static utils.DataBaseUtils.getResultSet;

public class US01_DatabaseStepDefs {
    ResultSet resultSet;

    @Given("get guest user via username {string}")
    public void get_guest_user_via_username(String username) {

//        //Create connection
//        Connection connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
//        //Create Statement
//        Statement statement = connection.createStatement();

        //Create ResultSet
        String sqlQuery = "SELECT * FROM guest_user WHERE username ='" + username + "'";

        resultSet = getResultSet(sqlQuery);


    }

    @Then("body contains birth_day {string}, birth_place {string}, gender {string}, name {string}, phone_number {string}, ssn {string}, surname {string}, username {string}")
    public void body_contains_birth_day_birth_place_gender_name_phone_number_ssn_surname_username(String birth_day, String birth_place, String gender, String name, String phone_number, String ssn, String surname, String username) throws SQLException {
        resultSet.next();//To move the pointer to the next record from header, use next() method

        String actBirth_day = resultSet.getString("birth_day");
        String actBirth_place = resultSet.getString("birth_place");
        String actGender = resultSet.getString("gender");
        String actName = resultSet.getString("name");
        String actPhone_number = resultSet.getString("phone_number");
        String actSsn = resultSet.getString("ssn");
        String actSurname = resultSet.getString("surname");
        String actUsername = resultSet.getString("username");

        assertEquals(birth_day, actBirth_day);
        assertEquals(birth_place, actBirth_place);
        assertEquals(gender, actGender);
        assertEquals(name, actName);
        assertEquals(phone_number, actPhone_number);
        assertEquals(ssn, actSsn);
        assertEquals(surname, actSurname);
        assertEquals(username, actUsername);

    }

    @Then("body should be empty")
    public void bodyShouldBeEmpty() throws SQLException {

        assertFalse(resultSet.next());//Since the ResulSet is empty, next() method will return false

    }

    @Given("get guest user via birth_place {string}")
    public void getGuestUserViaBirth_place(String birth_place) {
        String sql = "SELECT * FROM guest_user WHERE birth_place ='Berlin'";
        resultSet = getResultSet(sql);

    }

    @Then("there must be at least {int} users")
    public void thereMustBeAtLeastUsers(int number) throws SQLException {

        int numOfUsers = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ssn"));
            numOfUsers++;
        }

        System.out.println("numOfUsers = " + numOfUsers);
        assertTrue(numOfUsers > number);
    }
}
