package clothes.clothesproject.domain.repository;

import clothes.clothesproject.domain.entiry.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository

public class MemberRepository{

    @PersistenceContext EntityManager em;

    public void save(Member member){ // 회원을 db에 저장한다.
        if(member.getId()==null) {
            em.persist(member);
        }else {
            em.merge(member);
        }
    }

    public Optional<Member> findByLoginId(String loginId){//로그인 아이디 찾기
        return findAll().stream().filter(m->m.getLoginId().equals(loginId)).findFirst();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }

}
