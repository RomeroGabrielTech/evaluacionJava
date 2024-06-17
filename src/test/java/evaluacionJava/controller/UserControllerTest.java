package evaluacionJava.controller;

import evaluacionJava.model.User;
import evaluacionJava.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("plainPassword");

        when(userService.registerUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Juan Rodriguez\", \"email\": \"juan@rodriguez.org\", \"password\": \"hunter2\", \"phones\": [{\"number\": \"1234567\", \"citycode\": \"1\", \"countrycode\": \"57\"}]}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testLoginUser() throws Exception {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("plainPassword");

        when(userService.loginUser(any(String.class), any(String.class))).thenReturn(user);

        mockMvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"juan@rodriguez.org\", \"password\": \"hunter2\"}"))
                .andExpect(status().isOk());
    }
}
