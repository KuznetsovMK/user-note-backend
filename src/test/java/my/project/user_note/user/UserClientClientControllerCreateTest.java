package my.project.user_note.user;

import io.restassured.RestAssured;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import my.project.user_note.entity.user.ClientUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
class UserClientClientControllerCreateTest {
    @LocalServerPort
    private int localServerPort;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final BeanPropertyRowMapper<ClientUser> CLIENT_USER_BEAN_PROPERTY_ROW_MAPPER = new BeanPropertyRowMapper<>(ClientUser.class);

    @BeforeEach
    void setUp() {
        RestAssured.port = localServerPort;
        RestAssured.baseURI = "http://localhost";
    }

    @SneakyThrows
    @Test
    void test1() {
        var userId = UUID.fromString("a9db8d00-cde4-4ad0-98dc-c1008ac4cd95");
        var userLogin = "testUserLogin";

        var request = Map.of(
                "id", userId,
                "login", userLogin
        );

        given()
                .contentType("application/json")
                .log().all()
                .body(request)
                .when().post("/client-user/create")
                .then()
                .log().all()
                .statusCode(200);

        var sql = """
                SELECT *
                FROM client_user
                WHERE id = 'a9db8d00-cde4-4ad0-98dc-c1008ac4cd95'
                """;

        var clientUsers = namedParameterJdbcTemplate.queryForObject(
                sql, Map.of(), CLIENT_USER_BEAN_PROPERTY_ROW_MAPPER);

        assertNotNull(clientUsers);
        assertEquals(clientUsers.getId(), userId);
        assertEquals(clientUsers.getLogin(), userLogin);
    }
}
