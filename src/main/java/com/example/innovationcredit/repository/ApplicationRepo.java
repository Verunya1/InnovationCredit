package com.example.innovationcredit.repository;

import com.example.innovationcredit.entity.Application;

public interface ApplicationRepo {

    void supply(Application application); // хз что здесь должно передаваться

    Application getStatus(long userId);

    void delete(long userId);
}
