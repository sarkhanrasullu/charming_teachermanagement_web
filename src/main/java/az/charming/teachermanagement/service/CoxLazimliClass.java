package az.charming.teachermanagement.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class CoxLazimliClass {

    @PreAuthorize("hasAuthority('TAKE_AN_EXAM')")
    public void coxlazimliMethod(){
        System.out.println("cox lazimli method");
    }

}
