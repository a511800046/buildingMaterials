package com.business.system.service;

import com.business.system.model.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, String userId);

}
