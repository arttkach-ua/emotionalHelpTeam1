package com.epam.team1.emotional.help.service;


import com.epam.team1.emotional.help.dto.request.UserAdditionalDataRequestDto;
import com.epam.team1.emotional.help.dto.response.UserResponseDTO;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponseDTO addData(UserAdditionalDataRequestDto userAdditionalDataRequestDto) {

        //UserDetails userDetails = AuthService.getUserDetails();
        System.out.println(AuthService.getUserDetails());
        //Optional<User> optionalUser = userRepository.findByEmail(userDetails.getUsername());
        //User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));
        // System.out.println(user.getClass().getName());
//        if(userAdditionalDataRequestDto.getBirthday()!=null){
//            user.setBirthday(userAdditionalDataRequestDto.getBirthday());
//        }
//        if (userAdditionalDataRequestDto.getGender()!=null){
//            user.setGender(userAdditionalDataRequestDto.getGender());
//        }
//        if (userAdditionalDataRequestDto.getCountry()!=null){
//            user.setCountry(userAdditionalDataRequestDto.getCountry());
//        }
//        userRepository.save(user);
        // return userMapper.mapToResponseDto(user);
        return null;

    }
}
