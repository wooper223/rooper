package com.wooper.rooper.user;

import com.wooper.rooper.config.error.ApiException;
import com.wooper.rooper.config.error.ApiResult;
import com.wooper.rooper.config.error.ErrorCode;
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

    public ApiResult insertUser(UserVo userVo){
        Optional<User> user = userRepository.findByUserId(userVo.getUserId());
        if(user.isPresent()){
            throw new ApiException(ErrorCode.DUPLICATE_LOGIN_ID);
        } else {
            User newUser = new User(userVo.getUserId(), userVo.getPassword()
                    , userVo.getTelNo(), userVo.getEmail(), LocalDateTime.now());
            userRepository.save(newUser);
            return new ApiResult("Success", "user/signin", "sign in");
        }
    }

    public ApiResult login(LoginVo loginVo, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            throw new ApiException(ErrorCode.ALREADY_LOGGED_IN);
        }
        Optional<User> user = userRepository.findByUserId(loginVo.getUserId());
        if(user.isPresent()){
            if(user.get().getPassword().equals(loginVo.getPassword())) {
                session = request.getSession();
                session.setAttribute("user/login", user.get().getUserNo());
                return new ApiResult("Success", "user/login", "login");
            }
            throw new ApiException(ErrorCode.WRONG_PASSWORD);
        }
        throw new ApiException(ErrorCode.ACCOUNT_NOT_FOUND);
    }

    public ApiResult logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            return new ApiResult("Success", "user/logout", "logout");
        } else {
            throw new ApiException(ErrorCode.SESSION_EXPIRED);
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
