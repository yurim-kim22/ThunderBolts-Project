package com.greedy.thunderbolts.model.service.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greedy.thunderbolts.model.dao.MemberMapper;
import com.greedy.thunderbolts.model.dto.MembersDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {
	private final MemberMapper mapper;

    public AuthenticationService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override	
    public UserDetails loadUserByUsername(String membersId) throws UsernameNotFoundException {

   
        log.info("[AuthenticationService] memberId : {}", membersId);

        MembersDTO member = mapper.findByMemberId(membersId);

        log.info("[AuthenticationService] member : {}", membersId);

        if(member == null){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }

        return member;
    }
}
