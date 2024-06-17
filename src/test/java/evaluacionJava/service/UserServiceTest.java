package evaluacionJava.service;

import evaluacionJava.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import evaluacionJava.repository.UserRepository;
import evaluacionJava.util.JwtUtil;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        // Crear un usuario de prueba
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("plainPassword");

        // Configurar los mocks
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(any())).thenReturn("encryptedPassword");
        when(jwtUtil.generateToken(any())).thenReturn("dummyToken");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Llamar al método que estamos probando
        User registeredUser = userService.registerUser(user);

        // Verificar los resultados
        assertNotNull(registeredUser);
        assertEquals("encryptedPassword", registeredUser.getPassword());
        assertEquals("dummyToken", registeredUser.getToken());
    }
}
