package com.zack.myTwitch.service;
import com.zack.myTwitch.DAO.RegisterDAO;
import com.zack.myTwitch.entity.db.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RegisterService {
    @Autowired
    private RegisterDAO registerDao;

    public boolean register(User user) throws IOException {
        return registerDao.register(user);
    }

}
