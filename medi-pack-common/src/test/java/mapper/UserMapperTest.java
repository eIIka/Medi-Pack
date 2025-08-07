package mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ua.ellka.medipack.dto.UserDTO;
import ua.ellka.medipack.mapper.UserMapper;
import ua.ellka.medipack.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static mapper.TestData.*;

class UserMapperTest {
    private UserMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(UserMapper.class);
    }

    @Test
    void toUserDTOTest() {
        UserDTO userDTO = mapper.userToUserDTO(USER);

        assertNotNull(userDTO);
        assertEquals(USER.getId(), userDTO.getId());
        assertEquals(USER.getEmail(), userDTO.getEmail());
        assertEquals(USER.getFirstName(), userDTO.getFirstName());
        assertEquals(USER.getLastName(), userDTO.getLastName());
    }

    @Test
    void toUserTest() {
        User user = mapper.userDTOToUser(USER_DTO);

        assertNotNull(user);
        assertEquals(USER_DTO.getId(), user.getId());
        assertEquals(USER_DTO.getEmail(), user.getEmail());
        assertEquals(USER_DTO.getFirstName(), user.getFirstName());
        assertEquals(USER_DTO.getLastName(), user.getLastName());
    }
}