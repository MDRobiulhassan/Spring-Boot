package com.library.LibraryManagement;

import com.library.LibraryManagement.mapper.AuthorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MapperTest {

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    void testMapper() {
        assertNotNull(authorMapper);
    }
}
