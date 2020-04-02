package com.cxyz.relative.base.manager;

import com.cxyz.relative.base.data.protocol.User;

public interface UpdateListener {
    public User OnUpdate(User oldUser,User newUser);
}
