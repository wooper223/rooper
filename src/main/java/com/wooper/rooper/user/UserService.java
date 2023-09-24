package com.wooper.rooper.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public String insertUser(UserVo userVo){
        Optional<User> user = userRepository.findByUserId(userVo.getUserId());
        if(user.isPresent()){
            return "Fail";
        } else {
            User newUser = new User(userVo.getUserId(), userVo.getPassword()
                    , userVo.getTelNo(), userVo.getEmail(), LocalDateTime.now());
            userRepository.save(newUser);
            return "Success";
        }
    }

    public String login(LoginVo loginVo, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            return "Fail : already login";
        }
        Optional<User> user = userRepository.findByUserId(loginVo.getUserId());
        if(user.isPresent()){
            if(user.get().getPassword().equals(loginVo.getPassword())) {
                session = request.getSession();
                session.setAttribute("user", user.get().getUserNo());
                return "Success";
            }
            return "Fail : wrong password";
        }
        return "Fail : wrong id";
    }

    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            return "Success";
        } else {
            return "Fail : No Session";
        }
    }

    public String getAllUserInfo(){
        List<User> users = userRepository.findAll();
        String result = "";
        for(User user: users){
            result += user.toString() + '\n';
        }
        return result;
    }
}
