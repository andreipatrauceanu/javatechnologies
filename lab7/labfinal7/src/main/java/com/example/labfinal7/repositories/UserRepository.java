package com.example.labfinal7.repositories;

import com.example.labfinal7.beans.Login;
import com.example.labfinal7.beans.Register;
import com.example.labfinal7.config.Authentication;
import com.example.labfinal7.config.MyInterceptor;
import com.example.labfinal7.entities.Period;
import com.example.labfinal7.entities.User;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@ManagedBean
@Transactional(rollbackOn = {SQLException.class})
public class UserRepository {

    @Inject
    protected EntityManager userManagerPU;

    @Inject
    private Authentication auth;


    public UserRepository() {
    }

    public String save(Register user) {
        TypedQuery<Period> namedQuery = userManagerPU.createNamedQuery("Period.getAll", Period.class);
        List<Period> periods = namedQuery.getResultList();
        int max = -1;
        Period maxP = null;
        for(Period p : periods){
            if(p.getId()>=max){
                max = p.getId();
                maxP = p;
            }
        }
        if(max==-1){
            userManagerPU.getTransaction().begin();
            User userEntiy = new User();
            userEntiy.setUsername(user.getUsername());
            userEntiy.setPassword(user.getPassword());
            userEntiy.setRole(user.getRole());
            userManagerPU.persist(userEntiy);
            userManagerPU.getTransaction().commit();
            return "register-page";
        }
        else{
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
            if(hour>=Integer.parseInt(maxP.getStartingHour()) && hour<Integer.parseInt(maxP.getEndHour())){
                userManagerPU.getTransaction().begin();
                User userEntiy = new User();
                userEntiy.setUsername(user.getUsername());
                userEntiy.setPassword(user.getPassword());
                userEntiy.setRole(user.getRole());
                userManagerPU.persist(userEntiy);
                userManagerPU.getTransaction().commit();
                return "register-page";
            }
            else {
                return "home-page";
            }
        }
    }

    @Interceptors(MyInterceptor.class)
    public String validate(Login user) {
        TypedQuery<User> query = userManagerPU.createNamedQuery("User.getAll", User.class);
        List<User> results = query.getResultList();
        for (User result : results) {
            if (Objects.equals(user.getUsername(), result.getUsername()) && Objects.equals(user.getPassword(), result.getPassword())) {
                auth.login(result);
                return "user-page";
            }
        }
            return "login-page";
    }

}