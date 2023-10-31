import com.ganilabs.MicroSecCore.MFA.MultiFactorSupport;
import com.ganilabs.MicroSecCore.annotations.EnableMicroSec;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandler;
import com.ganilabs.MicroSecCore.api.authenticationHandler.AuthenticationHandlerBuilder;
import com.ganilabs.MicroSecCore.api.userData.UserDetailsService;
import com.ganilabs.MicroSecCore.api.authenticationHandler.UserIdentificationService;
import com.ganilabs.MicroSecCore.api.userData.AbstractUserData;
import com.ganilabs.MicroSecCore.api.userData.EmailUserDataService;
import com.ganilabs.MicroSecCore.api.userData.PasswordUserDataService;
import com.ganilabs.MicroSecCore.api.userData.PhoneNumberUserDataService;
import com.ganilabs.MicroSecCore.authenticator.parser.JSONParser;
import com.ganilabs.MicroSecCore.authenticator.parser.ParsingChooser;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

//Configuring AuthenticationStrategies

@EnableMicroSec
class UserIdentifierConfig implements UserIdentificationService {
    @Override
    public AuthenticationHandler getAuthenticationStrategy(){
        return AuthenticationHandlerBuilder.getBuilder().initBuilder().withEmail().withPassword()
                .or().withPhone().withOTP().or().none()
                .build();
    }
}

// Database and user details configuration
@Component
class UserDataProvider implements UserDetailsService {
    @Override
    public AbstractUserData getUserData(UUID user_id) {
        return new UserData();
    }

    @Override
    public void saveUserData(AbstractUserData userData) {
        System.out.println("saving " + userData.toString());
    }
}

// Database and user details configuration
class MockUser {
    public static String email = "ganeshdagadi3@gmail.com";
    public static String password = "pass";
    public static String phone = "12345678";
    public static UUID UserId = new UUID(64 , 0);
    public static Boolean isEnabled = true;
    public static Boolean isVerified = false;
    public static Boolean isMFA = true;
}
@Component
class UserData extends AbstractUserData implements EmailUserDataService, PhoneNumberUserDataService, PasswordUserDataService, MultiFactorSupport {

    @Override
    public UUID getUserId() {
        return MockUser.UserId;
    }

    @Override
    public void setUserId(UUID userId) {
        MockUser.UserId = userId;
    }

    @Override
    public Boolean getEnabled() {
        return MockUser.isEnabled;
    }

    @Override
    public void setEnabled(Boolean isEnabled) {
        MockUser.isEnabled = isEnabled;
    }

    @Override
    public Boolean getVerified() {
        return MockUser.isVerified;
    }

    @Override
    public void setVerified(Boolean isVerified) {
        MockUser.isVerified = isVerified;
    }

    @Override
    public String getEmail() {
        return MockUser.email;
    }

    @Override
    public void setEmail(String email) {
        MockUser.email = email;
    }


    @Override
    public String getPassword() {
        return MockUser.password;
    }

    @Override
    public void setPassword(String password) {
        MockUser.password = password;
    }

    @Override
    public String getPhoneNumber() {
        return MockUser.phone;
    }

    @Override
    public void setPhoneNumber(String phone) {
        MockUser.phone = phone;
    }

    @Override
    public Boolean isMFAEnabled() {
        return MockUser.isMFA;
    }
}


//Request and response configuration
public class Client {

  //  @Test
//    private void testJSONParsingOfBody(){
//        HttpServletRequest  mockedRequest = Mockito.mock(HttpServletRequest.class);
//        when(mockedRequest.)
//    }
}