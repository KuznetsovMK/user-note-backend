package my.project.user_note.user;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TestSetup {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM CLIENT_USER_NOTE");
        jdbcTemplate.update("DELETE FROM CLIENT_USER");
        jdbcTemplate.update("DELETE FROM NOTE");
    }
}
