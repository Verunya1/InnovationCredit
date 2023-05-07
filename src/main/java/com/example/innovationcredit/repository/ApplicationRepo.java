package com.example.innovationcredit.repository;

import com.example.innovationcredit.model.entity.Application;

public interface ApplicationRepo {

    void supply(Application application);

    Application getStatus(long userId);

    void delete(long userId);
}
